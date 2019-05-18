package com.jxhun.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yanmin
 * Date: 2019/05/18
 * Description:  excel读写工具类，需要poi-4.0.1.jar、poi-ooxml-4.0.1.jar、poi-ooxml-schemas-4.0.1.jar、xmlbeans-3.0.2.jar四个核心jar包
 * 还需要commons-collections4-4.2.jar和commons-compress-1.18.jar两个辅助包
 * Version: V1.0
 */
public class POIUtil {

    /**
     * 根据fileType不同读取excel文件
     *
     * @param path 请求硬盘物理路径中的一个excel文件可以是xls，也可以是xlsx文件
     * @param sheetIndex sheet的下标，第一个sheet下标为0
     * @return 返回数据列表
     */
    public List<List<String>> readExcelForPOI(String path, int sheetIndex) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);   // 获取文件的后缀名
        List<List<String>> lists = new ArrayList<>();          // 里面的list代表每一行数据，外面list代表所有行数据，实际项目中，需要把excel中的每一行数据做成POJO对象处理
        InputStream is = null;                                             // 生成输入流
        try {
            is = new FileInputStream(path);
            Workbook wb = null;
            if (fileType.equals("xls")) {                  // 判断是2003版本还是2007之后的版本，xls为2003版本，xlsx为2007版本
                wb = new HSSFWorkbook(is);                 // HSSFWorkbook类型对应2003版本
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);                 // XSSFWorkbook类型对应2007之后版本
            } else {
                return null;
            }

            Sheet sheet = wb.getSheetAt(sheetIndex);             //读取工作页sheet，index默认从0开始，如果存在多个sheet，那么需要循环Sheet判断
            for (Row row : sheet) {                       //循环读取第一个工作页中的每一行记录
                ArrayList<String> list = new ArrayList<>();
                for (Cell cell : row) {                   // 循环读取一行中的每一列数据
                    cell.setCellType(CellType.STRING);    // 根据不同类型转化成字符串
                    list.add(cell.getStringCellValue());   // 获取当前列中的数据
                }
                lists.add(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lists;
    }
}
