package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Repository
public class PhoneService {
	
	@Autowired
	private PhoneDao pDao;
	
	public int personInsert(PersonVo pVo) {
		int count = -1;
		count = pDao.personInsert(pVo);
		return count;
	}
	
	public int personDelete(int personId) {
		int count = -1;
		count = pDao.personDelete(personId);
		return count;
	}
	
	public int personUpdate(PersonVo pVo) {
		int count = -1;
		count = pDao.personUpdate(pVo);
		return count;
	}
	
	public List<PersonVo> personSelect(){
		List<PersonVo> pList = pDao.personSelect();
		return pList;
	}
	
	public PersonVo getPerson(int personId) {
		PersonVo pVo = pDao.getPerson(personId);
		return pVo;
	}
}
