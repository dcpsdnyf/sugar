package com.sugar.manage.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TUserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String englishName;

    private String status;

    private String remark;

    private String createdStaff;

    private Date createdTime;

    private String updatedStaff;

    private Date updatedTime;

    private String userAccount;

}
