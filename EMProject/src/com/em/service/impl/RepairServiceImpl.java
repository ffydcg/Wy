package com.em.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.em.mapper.RepairMapper;
import com.em.model.Owner;
import com.em.model.Repair;
import com.em.service.RepairService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class RepairServiceImpl implements RepairService {
   @Autowired
   private RepairMapper repairMapper;
	@Override
	public PageInfo<Repair> queryRepairPage(String repairOwnerNo, int page, int rows) {
		// TODO Auto-generated method stub
		if(repairOwnerNo!=null){
			Repair repair=new Repair();
			repair.setRepairOwnerNo(repairOwnerNo);
	        PageHelper.startPage(page, rows);  
	        PageInfo<Repair> pages = new PageInfo<Repair>(repairMapper.select(repair));  
	        return pages;  	
		}else{
			 PageHelper.startPage(page, rows);  
		     PageInfo<Repair> pages = new PageInfo<Repair>(repairMapper.selectAll());  
		     return pages;  	
		}
	}

	@Override
	public int repairAdd(Repair repair) {
		// TODO Auto-generated method stub
		return repairMapper.insertSelective(repair);
	}

	@Override
	public Repair queryRepairById(int id) {
		// TODO Auto-generated method stub
		Repair o=new Repair();
		o.setId(id);
		o=repairMapper.selectByPrimaryKey(o);
		return o;
	}

	@Override
	public int updateRepair(Repair repair) {
		// TODO Auto-generated method stub
		return repairMapper.updateByPrimaryKeySelective(repair);
	}

	@Override
	public int deleteRepair(int id) {
		// TODO Auto-generated method stub
		Repair o=new Repair();
		o.setId(id);
		return repairMapper.deleteByPrimaryKey(o);
	}

	@Override
	public PageInfo<Repair> querRepairByName(String name, int page, int rows) {
		// TODO Auto-generated method stub
		Example ex=new Example(Repair.class);
		Example.Criteria criteria=ex.createCriteria();
		criteria.andLike("repairOwnerName", name);
        PageHelper.startPage(page, rows);  
        PageInfo<Repair> pages = new PageInfo<Repair>(repairMapper.selectByExample(ex));  
        return pages;  	
	}

}
