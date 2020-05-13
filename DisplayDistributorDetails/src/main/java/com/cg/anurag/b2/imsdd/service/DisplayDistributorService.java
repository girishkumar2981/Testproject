package com.cg.anurag.b2.imsdd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.anurag.b2.imsdd.dao.DisplayDistributorDAO;
import com.cg.anurag.b2.imsdd.dto.DisplayDistributor;
@Service
public class DisplayDistributorService {
	@Autowired
	DisplayDistributorDAO ddao;
	public void setDdao(DisplayDistributorDAO ddao) {
		this.ddao = ddao;
	}
	@Transactional
	public DisplayDistributor getDistributorDetails(String distributorId)
	{
		return ddao.findById(distributorId).get();
	}
	@Transactional
	public DisplayDistributor deleteDistributorDetails(String distributorId)
	{
		DisplayDistributor dd=ddao.findById(distributorId).get();
		if(dd!=null)
		{
			ddao.deleteById(distributorId);
		}
		return dd;
	}
	@Transactional
	public List<DisplayDistributor> getAllDistributors() {
		return ddao.findAll();
		
	}
	@Transactional
	public DisplayDistributor addDistributorDetails(DisplayDistributor d)
	{
		return ddao.save(d);
	}
	@Transactional
	public boolean updateDistributorDetails(DisplayDistributor d)
	{
		DisplayDistributor ddss=ddao.findById(d.getDistributorId()).get();
		if(ddss!=null)
		{
			ddss.setDistributorId(d.getDistributorId());
			ddss.setName(d.getName());
			ddss.setAddress(d.getAddress());
			ddss.setPhoneno(d.getPhoneno());
			return true;
		}
		return false;
	}
}
