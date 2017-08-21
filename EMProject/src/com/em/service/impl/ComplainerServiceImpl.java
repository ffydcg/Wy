package com.em.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.em.mapper.ComplainerMapper;
import com.em.model.Complainer;
import com.em.service.ComplainerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ComplainerServiceImpl implements ComplainerService {
    @Autowired
    private ComplainerMapper complainerMapper;
	@Override
	public PageInfo<Complainer> queryComplainerPage(String complainerName,
			int page, int rows) {
		// TODO Auto-generated method stub
		if(complainerName!=null){
			Complainer complainer=new Complainer();
			complainer.setComOwnerName(complainerName);;
	        PageHelper.startPage(page, rows);  
	        PageInfo<Complainer> pages = new PageInfo<Complainer>(complainerMapper.select(complainer));  
	        return pages;  	
		}else{
			 PageHelper.startPage(page, rows);  
		     PageInfo<Complainer> pages = new PageInfo<Complainer>(complainerMapper.selectAll());  
		     return pages;  	
		}
	}

	@Override
	public int complainerrAdd(Complainer complainer) {
		// TODO Auto-generated method stub
		return complainerMapper.insertSelective(complainer);
	}

	@Override
	public Complainer queryComplainerById(int id) {
		// TODO Auto-generated method stub
		Complainer o=new Complainer();
		o.setId(id);
		o=complainerMapper.selectByPrimaryKey(o);
		return o;
	}

	@Override
	public int updateComplainer(Complainer complainer) {
		// TODO Auto-generated method stub
		return complainerMapper.updateByPrimaryKeySelective(complainer);
	}

	@Override
	public int deleteComplainer(int id) {
		// TODO Auto-generated method stub
		Complainer o=new Complainer();
		o.setId(id);
		return complainerMapper.deleteByPrimaryKey(o);
	}

	@Override
	public PageInfo<Complainer> querComplainerByName(String name, int page,
			int rows) {
		// TODO Auto-generated method stub
		Example ex=new Example(Complainer.class);
		Example.Criteria criteria=ex.createCriteria();
		criteria.andLike("comOwnerName", name);
        PageHelper.startPage(page, rows);  
        PageInfo<Complainer> pages = new PageInfo<Complainer>(complainerMapper.selectByExample(ex));  
        return pages;  	
	}

}
