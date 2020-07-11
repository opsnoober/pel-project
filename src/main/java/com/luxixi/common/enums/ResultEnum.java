package com.luxixi.common.enums;

/**
 * 状态码枚举
 * 1000~1999 表示参数错误
 * 2000~2999 表示用户错误
 * 3000~3999 表示接口错误
 * 4000~4999 表示资源错误
 * @author xiaoyu
 */
public enum ResultEnum {

    REQUEST_SUCCESS(200, "操作成功!"),

    REQUEST_TYPE_ERROR(302, "请求方式错误!"),

    REQUEST_ILLEGAL_ERROR(400, "操作失败,非法请求!"),

    REQUEST_AUTH_NOT_ENOUGH(401, "权限不足,无法访问!"),

    REQUEST_OPERATION_ERROR(500, "操作失败,系统异常!"),

    REQUEST_AUTH_ERROR(501, "登录信息已过期,请先登录!"),

    REQUEST_PARTY_AUTH_ERROR(502, "获取用户信息失败!"),

    REQUEST_SERVER_ERROR(503, "服务器繁忙,请稍后重试!"),

    /**
     * 参数操作
     */
    PARAM_ERROR(1000, "请求参数不符合要求!"),
    PARAM_ERROR_NULL(1001, "请求参数不可为空!"),
    PARAM_TYPE_ERROR(1003, "请求参数类型与目标类型不符!"),
    MAX_UPLOAD_ERROR(1005, "上传文件过大,请确认文件大小!"),
    UPLOAD_NULL_ERROR(1006, "上传文件为空,请确认文件!"),
    VALIDATION_CODE(1013,"参数验证错误"),
    LACK_PARAM_NULL(1014,"缺少请求参数");


    private Integer status;

    private String message;

    ResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
