package com.em.service;

import com.em.model.Complainer;
import com.github.pagehelper.PageInfo;

public interface ComplainerService {
	PageInfo<Complainer> queryComplainerPage(String complainer,int page,int rows);
    int complainerrAdd(Complainer owner);
    Complainer queryComplainerById(int id);
    int updateComplainer(Complainer owner);
    int deleteComplainer(int id);
    PageInfo<Complainer> querComplainerByName(String name,int page,int rows);
}
