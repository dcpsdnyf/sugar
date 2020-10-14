package com.sugar.manage.dao.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TStagePrincipalVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String stageNum;

    private String stageName;

    private Integer userId;

    private String principalName;

    private Integer projectId;

    private String status;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

}