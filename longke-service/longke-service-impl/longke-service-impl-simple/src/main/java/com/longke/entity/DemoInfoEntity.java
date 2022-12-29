package com.longke.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.longke.common.mysql.entity.BasicsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * demo信息表
 * @author Alex
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "demo_info")
public class DemoInfoEntity extends BasicsEntity {
    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
}
