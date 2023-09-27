package org.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.test.entity.DeviceData;
import org.test.service.IDeviceDataService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: sukang
 * @CreateTime: 2023-08-14
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/processor/deviceData")
@Slf4j
public class DeviceDataController {


    @Autowired
    @Qualifier("deviceDataServiceImpl")
    private IDeviceDataService deviceDataServiceImpl;

    /**
     *
     * @param deviceData
     * @return
     */
    @PostMapping("/add")
    public String addDeviceData(@RequestBody DeviceData deviceData){
        deviceDataServiceImpl.save(deviceData);
        return "添加成功";
    }

    /**
     *
     * @return
     */
    @GetMapping("/list")
    public String list(@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime){
        List<DeviceData> list = deviceDataServiceImpl.list(Wrappers.lambdaQuery(DeviceData.class).between(DeviceData::getCreateTime, startTime, endTime));
        return JSONObject.toJSONString(list);
    }

}
