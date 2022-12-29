package com.longke.common.xxl.job.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * swagger 配置文件
 * @author Alex
 */
@Data
@Component
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobProperties implements Serializable {
    /**
     * admin 配置
     **/
    private XxlJobAdminProperties admin;

    /**
     * 执行器通讯TOKEN [选填]：非空时启用；
     **/
    private String accessToken = "";

    /**
     * 执行器
     **/
    private XxlJobExecProperties executor;
}
