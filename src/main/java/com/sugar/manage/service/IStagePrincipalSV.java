package com.sugar.manage.service;

import com.sugar.manage.dao.model.TStagePrincipal;
import com.sugar.manage.dao.vo.TStagePrincipalVO;

import java.util.List;

public interface IStagePrincipalSV {

    List<TStagePrincipal> selectStagePrincipalList(TStagePrincipalVO vo);
}
