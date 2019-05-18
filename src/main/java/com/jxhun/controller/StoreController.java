package com.jxhun.controller;

import com.jxhun.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/05/18
 * Description:
 * Version: V1.0
 */
@Controller
public class StoreController {


    private final StoreService storeService;


    /**
     * 构造函数注入
     *
     * @param storeService storeservice对象，用来调用其方法
     */
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * 这个接口用来读取excle中的数据
     * @param request 用来获取路径
     * @return 成功返回json字符串到前端
     */
    @RequestMapping(value = "/excle", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> store(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();  // 这个map用来存入结果
        map.put("returncode",200);  // 成功状态码
        map.put("msg",200);         // 成功信息
        map.put("data",storeService.excle(request)); // 返回结果信息
        return map;
    }
}
