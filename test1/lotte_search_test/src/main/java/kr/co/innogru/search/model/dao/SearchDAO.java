package kr.co.innogru.search.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	//사용자 아이디로 검색어 출력
	public List<Map<String, String>> selectSearchByUserId(String userId) {
		return session.selectList("mapper.Mybatis.selectSearchByUserId", userId);
	}
	
	//인덱스로 검색어 출력
	public String selectSearchByIdx(String searchIdx) {
		return session.selectOne("mapper.Mybatis.selectSearchByIdx", searchIdx);
	}
	
	//selectKey를 사용하여 검색어 등록
	public int insertSearch(Map<String, String> paramMap) {
		return session.insert("mapper.Mybatis.insertSearch", paramMap);
	}
	
	//search_idx로 검색어 삭제(del_yn 값 'N'으로 업데이트)
	public int updateDelYN(String searchIdx) {
		return session.update("mapper.Mybatis.updateDelYN", searchIdx);
	}
	
	public List<Map<String, String>> discoverySearch() {
		return session.selectList("mapper.Mybatis.discoverySearch");
	}
	
	public int discoveryDel(String Idx) {
		return session.delete("mapper.Mybatis.discoveryDel", Idx);
	}
	
	public int discoveryInsert(Map<String, String> paramMap) {
		return session.insert("mapper.Mybatis.discoveryInsert", paramMap);
	}
	
	public List<Map<String, String>> discoveryMod(String Idx) {
		return session.selectList("mapper.Mybatis.discoveryMod", Idx);
	}
	
	public int discoveryUpdate(Map<String, String> paramMap) {
		System.out.println("DAODAO" + paramMap);
		int result = session.update("mapper.Mybatis.discoveryUpdate", paramMap);
		System.out.println("result" + result);
		return session.update("mapper.Mybatis.discoveryUpdate", paramMap);
	}
	
}
