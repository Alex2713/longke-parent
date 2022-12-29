package com.longke.service.data.simple.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 输入请求参数示例
 * @author Alex
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "输入请求参数示例")
public class DemoInput {
    /**
     * id
     */
    @NotNull(message = "id不能为空")
    @Schema(description = "id", defaultValue = "1", title = "id")
    private Long id;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    @Schema(description = "名称", defaultValue = "张三")
    private String name;
}
