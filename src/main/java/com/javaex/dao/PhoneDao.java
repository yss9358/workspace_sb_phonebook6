package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 전체 리스트 가져오기
	public List<PersonVo> personList() {
		return sqlSession.selectList("phonebook.list");
	}
	
	// 한명 데이터 가져오기
	public PersonVo selectOne(int no) {
		return sqlSession.selectOne("phonebook.selectOne", no);
	}
	
	// 등록
	public int personInsert(PersonVo personVo) {
		int count = sqlSession.insert("phonebook.insert",personVo);
		return count;
	}

	// 수정
	public int personUpdate(PersonVo personVo) {
		int count = sqlSession.update("phonebook.update",personVo);
		return count;
	}
	
	// 삭제
	public int delete(int no) {
		int count = sqlSession.delete("phonebook.delete",no);
		return count;
	}
}
