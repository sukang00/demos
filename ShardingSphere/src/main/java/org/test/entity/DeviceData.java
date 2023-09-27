package org.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: device_last_data
 * @Author: jeecg-boot
 * @Date:   2023-07-24
 * @Version: V1.0
 */
@Data
@TableName("device_data")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DeviceData implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    private String id;
	/**设备id*/
    private String deviceId;
	/**客户id*/
    private String customerId;
	/**设备类型*/
    private Integer deviceType;
	/**数据类型*/
    private Integer dataType;
	/**json数据*/
    private String data;
	/**租户id*/
    private Integer tenantId;
	/**createBy*/
    private String createBy;
	/**createTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
	/**updateBy*/
    private String updateBy;
	/**updateTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**检查时间*/
    /**updateTime*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date checkDate;
}
