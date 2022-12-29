package com.longke.service.data.base.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用数据响应对象
 * @param <T> 对象类型
 * @author Alex
 */
@Data
@Schema(description = "通用数据响应对象")
public class Results<T> implements Serializable {

    /**
     * 响应码
     */
    @Schema(description = "响应码", defaultValue = "200")
    private Integer state;

    /**
     * 时间戳
     */
    @Schema(description = "时间戳", defaultValue = "1567425139000")
    private Long time;

    /**
     * 响应信息
     */
    @Schema(description = "响应信息", defaultValue = "SUCCESS")
    private String message;

    /**
     * 响应数据
     */
    @Schema(description = "响应数据")
    private T content;

    /**
     * 构造函数
     * @param state 响应码
     * @param message 响应信息
     * @param content 响应数据
     */
    private Results(Integer state, String message, T content) {
        this.state = state;
        this.message = message;
        this.content = content;
        this.time = System.currentTimeMillis();
    }

    /**
     * SUCCESS
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> SUCCESS() {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), null);
    }

    /**
     * SUCCESS
     * @param message 响应信息
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> SUCCESS(String message) {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), message, null);
    }

    /**
     * SUCCESS
     * @param content 响应数据
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> SUCCESS(T content) {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), content);
    }

    /**
     * SUCCESS
     * @param message 响应信息
     * @param content 响应数据
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> SUCCESS(String message, T content) {
        ResultsMsg resultsMsg = ResultsMsg.OK;
        return new Results<>(resultsMsg.getState(), message, content);
    }

    /**
     * ERROR
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> ERROR() {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), null);
    }

    /**
     * ERROR
     * @param message 响应信息
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> ERROR(String message) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), message, null);
    }

    /**
     * ERROR
     * @param content 响应数据
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> ERROR(T content) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), content);
    }

    /**
     * ERROR
     * @param state 结果码
     * @param message 响应信息
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> ERROR(Integer state, String message) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(state, message, null);
    }

    /**
     * ERROR
     * @param message 响应信息
     * @param content 响应数据
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> ERROR(String message, T content) {
        ResultsMsg resultsMsg = ResultsMsg.SEVER_ERROR;
        return new Results<>(resultsMsg.getState(), message, content);
    }

    /**
     * RESULT
     * @param resultsMsg 结果信息
     * @param <T> 结果类型
     * @return 响应结果
     */
    public static <T> Results<T> RESULT(ResultsMsg resultsMsg) {
        return new Results<>(resultsMsg.getState(), resultsMsg.getMessage(), null);
    }

    /**
     * RESULT
     * @param state 响应码
     * @param message 响应信息
     * @param content 响应数据
     * @param <T> 响应类型
     * @return 响应结果
     */
    public static <T> Results<T> RESULT(Integer state, String message, T content) {
        return new Results<>(state, message, content);
    }

    /**
     * 判断响应结果是否成功
     * @param results  响应结果
     * @param <T> 响应类型
     * @return true 成功 false 失败
     */
    public static <T> boolean isSuccess(Results<T> results) {
        if (results == null) {
            return false;
        }
        return ResultsMsg.OK.getState().equals(results.getState());
    }
}
