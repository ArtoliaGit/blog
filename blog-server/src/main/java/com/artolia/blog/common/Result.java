package com.artolia.blog.common;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Artolia Pendragon
 * @version 1.0.0
 * @Description 返回json
 * @createTime 2019年03月24日 14:31:00
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 2455156933806338812L;

    private Integer code;
    private String message;
    private T data;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
