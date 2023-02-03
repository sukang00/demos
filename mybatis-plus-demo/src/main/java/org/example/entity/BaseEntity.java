package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/2/2 17:47
 */
public class BaseEntity {

    @TableLogic
//    @TableField(value = "flag")
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
