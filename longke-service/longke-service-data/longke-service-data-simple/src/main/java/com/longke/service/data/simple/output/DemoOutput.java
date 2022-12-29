package com.longke.service.data.simple.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 输出结果示例
 * @author Alex
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "输出结果示例")
public class DemoOutput {
    /**
     * id
     */
    @Schema(description = "id", defaultValue = "1", title = "id")
    private Long id;

    /**
     * 名称
     */
    @Schema(description = "名称", defaultValue = "张三")
    private String name;
}
