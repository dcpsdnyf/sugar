package com.sugar.manage.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TUserRoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String roleId;

    private Long userId;

    private String projectId;

}