package com.longke.service.api.simple;

import com.longke.service.api.base.BaseService;
import com.longke.service.data.simple.input.DemoInput;
import com.longke.service.data.simple.output.DemoOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务示例接口
 * @author Alex
 */
@RequestMapping("/simple")
@Tag(name = "服务示例接口")
public interface SimpleService extends BaseService {
    /**
     * 查询数据列表
     * @return 返回结果
     */
    @GetMapping
    @Operation(summary = "查询数据列表")
    List<DemoOutput> list();

    /**
     * 查询数据详情
     * @param id 编号
     * @return 返回结果
     */
    @GetMapping("/{id}")
    @Operation(summary = "查询数据详情")
    @Parameters({
            @Parameter(name = "id",description = "编号", in = ParameterIn.PATH)
    })
    DemoOutput get(@PathVariable Long id);

    /**
     * 统计数据数量
     * @return 返回结果
     */
    @GetMapping("/count")
    @Operation(summary = "统计数据数量")
    Long count();

    /**
     * 新增数据
     * @param demoInput 参数
     * @return 返回结果
     */
    @PostMapping
    @Operation(summary = "新增数据")
    Boolean add(@RequestBody @Validated DemoInput demoInput);

    /**
     * 修改数据
     * @param demoInput 参数
     * @return 返回结果
     */
    @PutMapping
    @Operation(summary = "修改数据")
    Boolean update(@RequestBody @Validated DemoInput demoInput);

    /**
     * 删除数据
     * @param id 编号
     * @return 返回结果
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除数据")
    @Parameters({
            @Parameter(name = "id",description = "编号", in = ParameterIn.PATH)
    })
    Boolean del(@PathVariable Long id);
}
