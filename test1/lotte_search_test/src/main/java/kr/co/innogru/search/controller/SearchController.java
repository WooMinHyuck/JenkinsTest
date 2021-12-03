package kr.co.innogru.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.innogru.search.model.service.SearchService;

@Controller
public class SearchController {
	
	private final SearchService searchService;
	
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}
	
	@GetMapping("search")
	public String mySearch(Model model, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		List<Map<String, String>> res = searchService.selectSearchByUserId("test_user");
		model.addAttribute("res", res);
		
		return "search/search";
	}
	
	@GetMapping("newsearch")
	public String newSearch() {
		return "search/newSearch";
	}
	
	@PostMapping("newsearch")
	public String insertNewSearch(@RequestParam HashMap<String, String> paramMap, Model model, HttpServletResponse response) {
		
		String newSearchWord = paramMap.get("searchWord");
		String uuid = UUID.randomUUID().toString();
		
		//쿠키 생성
		Cookie cookie = new Cookie("searchWord_" + uuid, newSearchWord);
		cookie.setComment("내가 찾은 검색어");
		cookie.setPath("/");
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		
		if(searchService.insertSearch(paramMap) > 0) {
			model.addAttribute("alertMsg", "검색어 등록 성공");
			model.addAttribute("url", "/search");
		}else {
			model.addAttribute("alertMsg", "검색어 등록 실패");
			model.addAttribute("url", "/search");
		}
		
		return "common/result";
	}
	
	@RequestMapping(value = "/delsearch", method = RequestMethod.GET)
	public String deleteSearch(@RequestParam String searchIdx, Model model, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		
		if(searchService.updateDelYN(searchIdx) > 0) {
			for (Cookie cook : cookies) {
				if(cook.getValue().equals(searchService.selectSearchByIdx(searchIdx))) {
					cook.setMaxAge(0);
					response.addCookie(cook);
				}
			}
						
			model.addAttribute("alertMsg", "검색어 삭제 성공");
			model.addAttribute("url", "/search");
		}else {
			model.addAttribute("alertMsg", "검색어 삭제 실패");
			model.addAttribute("url", "/search");
		}
		
		return "common/result";
	}
	
	
	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	public String discoverySearch(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
		List<Map<String, String>> res = searchService.discoverySearch();
		model.addAttribute("res", res);
		/*System.out.println("res" + res);		*/		
		
		
		return "search/discovery";
	}
	
	@RequestMapping(value = "/discoveryDel", method = RequestMethod.GET)
	public String discoveryDel(@RequestParam String Idx ,Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
		int result = searchService.discoveryDel(Idx);
						
		
		
		return "common/result";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String Insert(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "search/insert";
	}
	
	@RequestMapping(value = "/DiscoveryInsert", method = RequestMethod.GET)
	public String discoveryInsert(@RequestParam HashMap<String, String> paramMap, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		int insert = searchService.discoveryInsert(paramMap);
		
		
		return "/home";
	}
	
	@RequestMapping(value = "/discoveryMod", method = RequestMethod.GET)
	public String discoveryMod(@RequestParam String Idx ,Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
		List<Map<String, String>> res = searchService.discoveryMod(Idx);
		model.addAttribute("res", res);				
		System.out.println("res" + res);
		
		
		return "search/modify";
	}
	
	@RequestMapping(value = "/DiscoveryUpdate", method = RequestMethod.POST)
	public String discoveryUpdate(@RequestParam HashMap<String, String> paramMap,Model model, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("paramMap" + paramMap);
		int res = searchService.discoveryUpdate(paramMap);
		System.out.println("res" + res);
		
		return "/home";
	}
	
	
}
