package top.wuhaojie.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/10/12 21:46
 * Version: 1.0
 */
@Setter
@Getter
public class ResponseEntity<T> {

    private int code;

    private String msg;

    private T data;

    public ResponseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
