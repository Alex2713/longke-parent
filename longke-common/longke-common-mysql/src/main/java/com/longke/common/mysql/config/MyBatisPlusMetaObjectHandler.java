package com.longke.common.mysql.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.longke.common.mysql.enums.ActiveFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * MyBatisPlus 对象字段公共处理
 * @author Alex
 */
@Slf4j
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createBy", Long.class, 1L);
        this.strictInsertFill(metaObject, "createTime", Long.class, System.currentTimeMillis());
        this.strictInsertFill(metaObject, "updateBy", Long.class, 1L);
        this.strictInsertFill(metaObject, "updateTime", Long.class, System.currentTimeMillis());
        this.strictInsertFill(metaObject, "activeFlag", ActiveFlagEnum.class, ActiveFlagEnum.DEFAULT);
        this.strictInsertFill(metaObject, "version", Integer.class, 1);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updateBy", Long.class, 1L);
        this.strictUpdateFill(metaObject, "updateTime", Long.class, System.currentTimeMillis());
    }
}
