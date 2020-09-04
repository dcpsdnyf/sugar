package com.sugar.manage.dao.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer limit;

    private Integer offset;

    private Integer page;
}
