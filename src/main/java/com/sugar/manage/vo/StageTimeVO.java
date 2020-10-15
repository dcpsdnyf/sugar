package com.sugar.manage.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StageTimeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String stageType;

    private String stageName;

    private Integer stageDay;

    private String status;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

}