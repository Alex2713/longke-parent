package com.longke.common.mysql.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 数据状态 枚举字典
 * @author Alex
 */
public enum ActiveFlagEnum {
    /**
     * 有效
     */
    DEFAULT((byte) 0, "正常"),
    /**
     * 无效
     */
    DELETE((byte) 1, "已删除");

    ActiveFlagEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 编码
     *  数据库存的值是code
     */
    @EnumValue
    private Byte code;

    /**
     * 说明
     */
    private String desc;

    public Byte getCode() {
        return this.code;
    }
}
