package com.jxhun.service;

import com.jxhun.bean.StoreBean;
import com.jxhun.util.POIUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Wong
 * Date: 2019/03/18
 * Description:
 * Version: V1.0
 */
@Service
public class StoreService {


    /**
     * 此方法用来读取excle中的坐标等信息，由于读取的是门店信息，所以传入下标为1
     * @param request request对象，用来获取excle路径
     * @return 成功返回结果集合
     */
    public List<StoreBean> excle(HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath(File.separator);  // 使用绝对路径和文件路径拼接得到文件路径

        POIUtil poiUtil = new POIUtil();
        List<List<String>> lists = poiUtil.readExcelForPOI(path + File.separator + "excle" + File.separator + "TencentMap.xlsx", 1);  // 得到上传的excle第二个sheet组合成的集合
        List<StoreBean> storeBeanList = new ArrayList<>();   // 这个list用来装传入数据库的数据
        for (int i = 1; i < lists.size(); i++) {// 循环取出封装，因为第一行是行头，所以不取，从下标1开始取
            StoreBean storeBean = new StoreBean();  // 这个对相应用来封装excle每行的数据
            storeBean.setShopNumber(lists.get(i).get(0));  // 得到门店编号，存入对象
            storeBean.setNameOfStore(lists.get(i).get(1));  // 得到门店名称，存入对象
            storeBean.setOffice(lists.get(i).get(2));  // 得到办事处，存入对象
            storeBean.setAddress(lists.get(i).get(3));  // 得到地址，存入对象
            storeBean.setCoordinate(lists.get(i).get(4));  // 得到坐标，存入对象
            storeBeanList.add(storeBean);  // 存入list
        }
        return storeBeanList;
    }

    public static void main(String[] args) {
        StoreService kaoQinService = new StoreService();
//        kaoQinService.excle();
    }
}
