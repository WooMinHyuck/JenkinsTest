package kr.co.innogru.search.model.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

import com.sun.mail.iap.Response;

import kr.co.innogru.search.model.dao.SearchDAO;

@Service
public class SearchServiceImpl implements SearchService {
	
	private final SearchDAO searchDAO;
	
	public SearchServiceImpl(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}
	
	@Override
	public List<Map<String, String>> selectSearchByUserId(String userId) {
		return searchDAO.selectSearchByUserId(userId);
	}
	
	@Override
	public String selectSearchByIdx(String searchIdx) {
		return searchDAO.selectSearchByIdx(searchIdx);
	}

	@Override
	public int insertSearch(Map<String, String> paramMap) {
		return searchDAO.insertSearch(paramMap);
	}

	@Override
	public int updateDelYN(String searchIdx) {
		return searchDAO.updateDelYN(searchIdx);
	}
	
	@Override
	public List<Map<String, String>> discoverySearch() {
		return searchDAO.discoverySearch();
	}
	
	@Override
	public int discoveryDel(String Idx) {
		return searchDAO.discoveryDel(Idx);
	}
	
	@Override
	public int discoveryInsert(Map<String, String> paramMap) {
		return searchDAO.discoveryInsert(paramMap);
	}
	
	@Override
	public List<Map<String, String>> discoveryMod(String searchIdx) {
		return searchDAO.discoveryMod(searchIdx);
	}
	
	@Override
	public int discoveryUpdate(Map<String, String> paramMap) {
		return searchDAO.discoveryUpdate(paramMap);
	}
}
