package org.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import org.test.entity.DeviceData;
import org.test.mapper.DeviceDataMapper;
import org.test.service.IDeviceDataService;

/**
 * @Description: device_last_data
 * @Author: jeecg-boot
 * @Date:   2023-07-24
 * @Version: V1.0
 */
@Service
public class DeviceDataServiceImpl extends ServiceImpl<DeviceDataMapper, DeviceData> implements IDeviceDataService {

}
