package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhoneDao phoneDao;
	
	// 전체 리스트 가져오기
	public List<PersonVo> exeList() {
		return phoneDao.personList();
	}
	
	// 한명 데이터 가져오기
	public PersonVo exeSelectOne(int no) {
		return phoneDao.selectOne(no);
	}
	
	
	// 등록
	public int exeWrite(PersonVo personVo) {
		int count = phoneDao.personInsert(personVo);
		return count;
	}
	
	// 수정
	public int exeModify(PersonVo personVo) {
		int count = phoneDao.personUpdate(personVo);
		return count;
	}
	
	// 삭제 
	public int exeDelete(int no) {
		int count = phoneDao.delete(no);
		return count;
	}

	
}
