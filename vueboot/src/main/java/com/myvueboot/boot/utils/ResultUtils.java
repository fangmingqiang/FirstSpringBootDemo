package com.myvueboot.boot.utils;


import com.myvueboot.boot.result.ResultVo;

public class ResultUtils {

    public static ResultVo vo(String msg, Integer code, Object data) {
        return new ResultVo(msg, code, data);
    }

    /**
     * 无参数
     *
     * @return
     */
    public static ResultVo success() {
        return vo(null, 400, null);
    }

    /**
     * 一个参数
     *
     * @param msg
     * @return
     */
    public static ResultVo success(String msg) {
        return vo(msg, 400, null);
    }

    /**
     * 两个参数
     *
     * @param msg
     * @param data
     * @return
     */
    public static ResultVo success(String msg, Object data) {
        return vo(msg, 400, data);
    }

    /**
     * 全部参数
     *
     * @param msg
     * @param code
     * @param data
     * @return
     */
    public static ResultVo success(String msg, Integer code, Object data) {
        return vo(msg, code, data);
    }

    /**
     * 无参数
     *
     * @return
     */
    public static ResultVo error() {
        return vo(null, 500, null);
    }

    /**
     * 一个参数
     *
     * @param msg
     * @return
     */
    public static ResultVo error(String msg) {
        return vo(msg, 500, null);
    }

    /**
     * 两个参数
     *
     * @param msg
     * @param data
     * @return
     */
    public static ResultVo error(String msg, Object data) {
        return vo(msg, 500, data);
    }

    /**
     * 全部参数
     *
     * @param msg
     * @param code
     * @param data
     * @return
     */
    public static ResultVo error(String msg, Integer code, Object data) {
        return vo(msg, code, data);
    }

}
