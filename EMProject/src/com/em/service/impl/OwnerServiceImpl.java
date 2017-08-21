package com.em.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.em.mapper.OwnerMapper;
import com.em.model.Owner;
import com.em.service.OwnerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerMapper ownerMapper;
	@Override
	public PageInfo<Owner> queryOwnerPage(String ownerNo, int page, int rows) {
		// TODO Auto-generated method stub
		if(ownerNo!=null){
			Owner owner=new Owner();
			owner.setOwnerNo(ownerNo);
	        PageHelper.startPage(page, rows);  
	        PageInfo<Owner> pages = new PageInfo<Owner>(ownerMapper.select(owner));  
	        return pages;  	
		}else{
			 PageHelper.startPage(page, rows);  
		     PageInfo<Owner> pages = new PageInfo<Owner>(ownerMapper.selectAll());  
		     return pages;  	
		}

		
	}
	@Override
    public int ownerAdd(Owner owner){
    	return ownerMapper.insertSelective(owner);
    }
	@Override
	public Owner queryOwnerById(int id) {
		// TODO Auto-generated method stub
		Owner o=new Owner();
		o.setId(id);
		o=ownerMapper.selectByPrimaryKey(o);
		return o;
	}
	@Override
	public int updateOwner(Owner owner) {
		// TODO Auto-generated method stub
		return ownerMapper.updateByPrimaryKeySelective(owner);
	}
	@Override
	public int deleteOwner(int id) {
		// TODO Auto-generated method stub
		Owner o=new Owner();
		o.setId(id);
		return ownerMapper.deleteByPrimaryKey(o);
		
	}
	@Override
	public PageInfo<Owner> querOwnerByName(String name, int page, int rows) {
		// TODO Auto-generated method stub
		Example ex=new Example(Owner.class);
		Example.Criteria criteria=ex.createCriteria();
		criteria.andLike("ownerName", name);
        PageHelper.startPage(page, rows);  
        PageInfo<Owner> pages = new PageInfo<Owner>(ownerMapper.selectByExample(ex));  
        return pages;  	
	}
}
