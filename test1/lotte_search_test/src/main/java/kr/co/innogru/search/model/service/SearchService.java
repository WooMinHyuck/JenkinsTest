package kr.co.innogru.search.model.service;

import java.util.List;
import java.util.Map;

public interface SearchService {
	
	public List<Map<String, String>> selectSearchByUserId(String userId);
	public String selectSearchByIdx(String searchIdx);
	public int insertSearch(Map<String, String> paramMap);
	public int updateDelYN(String searchIdx);
	public int discoveryDel(String Idx);
	
	public int discoveryInsert(Map<String, String> paramMap);
	public List<Map<String, String>> discoverySearch();
	public List<Map<String, String>> discoveryMod(String searchIdx);
	public int discoveryUpdate(Map<String, String> paramMap);
}
