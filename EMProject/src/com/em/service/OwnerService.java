package com.em.service;


import com.em.model.Owner;
import com.github.pagehelper.PageInfo;

public interface OwnerService {
	PageInfo<Owner> queryOwnerPage(String ownerId,int page,int rows);
    int ownerAdd(Owner owner);
    Owner queryOwnerById(int id);
    int updateOwner(Owner owner);
    int deleteOwner(int id);
    PageInfo<Owner> querOwnerByName(String name,int page,int rows);
}
