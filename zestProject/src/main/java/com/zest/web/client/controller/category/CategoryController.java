package com.zest.web.client.controller.category;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.page.CategoryPageVO;
import com.zest.web.client.service.CategoryPageService;
import com.zest.web.util.Paging;

// 카테고리 페이지 컨트롤러
@Controller
public class CategoryController {

	@Autowired
	CategoryPageService categoryPageService;

	@Autowired
	Paging paging;

	// 카테고리 페이지 리스트 반환(대분류)
	@RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
	public ModelAndView categoryPage(ModelAndView modelAndView, @PathVariable String category,
			@RequestParam(required = false) String pageNum, @RequestParam(required = false) String search_type,
			@RequestParam(required = false) String search_text) {

		System.out.println("카테고리 컨트롤러 - 받아온 카테고리 종류: " + category);
		System.out.println("받아온 검색 텍스트: " + search_text);

		// 카테고리가 hot일 때와 다른 카테고리를 분류
		if (category.equals("hot")) {

			System.out.println("카테고리를 인기수업으로 받아옴");

			// VO에 받아온 카테고리를 입력
			CategoryPageVO vo = new CategoryPageVO();
			vo.setTalent_category_id(category); // View에서 받아온 URL 입력

			if (pageNum == null || pageNum == "")
				pageNum = "1";

			// 현재페이지
			int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
			int pageSize = 9; // 페이지당 보여줄 글
			int pageBlockSize = 3; // 페이지 블록의 사이즈

			// 검색설정확인
			if (search_type == null)
				search_type = "";
			if (search_text == null)
				search_text = "";

			// service로 넘겨줄 map객체 생성
			Map<String, Object> map = new HashMap<>();
			map.put("search_type", search_type);
			map.put("search_text", search_text);
			map.put("talent_category_id", vo.getTalent_category_id());

			// 총 글 수 가져오기
			int count = categoryPageService.getCategoryPageListCount(map);
			System.out.println("대분류 페이지의 강의 갯수 : " + count);

			// 페이징처리 설정
			paging.setPaging(pageSize, pageBlockSize, count, currentPage);
			// 페이지에서 가져올 글 설정
			map.put("startRow", paging.getWriting_Start());
			map.put("endRow", paging.getWriting_End());
			
			System.out.println( paging.getWriting_Start()+"...."+paging.getWriting_End());
			
			// 카테고리 페이지 리스트를 받아옴
			List<CategoryPageVO> categoryPageList = categoryPageService.getCategoryPageList(map);
			System.out.println("받아온 카테고리 리스트:" + categoryPageList.toString());

			// ------------------- 이미지 작업 ----------------------------

			Map<String, Object> model = new HashMap<>();

			for (int j = 0; j < categoryPageList.size(); j++) {
				System.out.println(categoryPageList.size());
				System.out.println("11111111111");
				File dirFile = new File(categoryPageList.get(j).getTc_image_path()); // 이미지 패키지 경로
																						// c:\zest\talent\MUSIC\3
				System.out.println(dirFile);

				File[] files = dirFile.listFiles(); // 파일 담기
				if(files == null) {
					System.out.println("해당 파일이 존재하지 않습니다.");
					continue;
				}

				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) {
						if (i == 0) {
							String tempPath = files[i].getParent(); // c:\zest\talent\BEAUTY\1
							String tempFileName = files[i].getName(); // img0.jpg
							String subPath = tempPath.substring(8); // talent\BEAUTY\1

							System.out.println("sub Path : " + subPath);
							System.out.println("tempPtah 값 : " + tempPath);
							System.out.println("tempFileName 값: " + tempFileName);

							Map<String, String> image = new HashMap<>();
							categoryPageList.get(j).setTc_image_path("/LocalImage/" + subPath + "/" + tempFileName);
							break;
						}
					}
				}
			}

			// ------------------- 이미지 작업 끝 ----------------------------

			// View에 넘기는 데이터
			model.put("result", "대분류");
			model.put("count", count);
			model.put("categoryPageList", categoryPageList);
			model.put("pageNum", pageNum);
			model.put("search_text", search_text);
			model.put("search_type", search_type);
			model.put("bp", paging);

			modelAndView.addAllObjects(model);
			modelAndView.setViewName("category/categoryPage");
			return modelAndView;
		} else {

			// VO에 받아온 카테고리를 입력
			CategoryPageVO vo = new CategoryPageVO();
			vo.setTalent_category_id(category); // View에서 받아온 URL 입력
			// ----------------------------- 시작 -------------------------

			if (pageNum == null || pageNum == "")
				pageNum = "1";

			// 현재페이지
			int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
			int pageSize = 9; // 페이지당 보여줄 글
			int pageBlockSize = 5; // 페이지 블록의 사이즈

			// 검색설정확인
			if (search_type == null)
				search_type = "";
			if (search_text == null)
				search_text = "";

			// service로 넘겨줄 map객체 생성
			Map<String, Object> map = new HashMap<>();
			map.put("search_type", search_type);
			map.put("search_text", search_text);
			map.put("talent_category_id", category);

			// 총 글 수 가져오기
			int count = categoryPageService.getCategoryPageListCount(map);
			System.out.println("대분류 페이지의 강의 갯수 : " + count);

			// 페이징처리 설정
			paging.setPaging(pageSize, pageBlockSize, count, currentPage);
			// 페이지에서 가져올 글 설정
			map.put("startRow", paging.getWriting_Start());
			map.put("endRow", paging.getWriting_End());
			map.put("talent_category_id", vo.getTalent_category_id());

			// ------------------------ 끝 -----------------------------

			// 카테고리 페이지 리스트를 받아옴
			List<CategoryPageVO> categoryPageList = categoryPageService.getCategoryPageList(map);
			System.out.println("받아온 카테고리 리스트:" + categoryPageList.toString());

			// ------------------- 이미지 작업 ----------------------------

			Map<String, Object> model = new HashMap<>();

			for (int j = 0; j < categoryPageList.size(); j++) {
				System.out.println(categoryPageList.size());
				System.out.println("11111111111");
				File dirFile = new File(categoryPageList.get(j).getTc_image_path()); // 이미지 패키지 경로
																						// c:\zest\talent\MUSIC\3
				System.out.println(dirFile);

				File[] files = dirFile.listFiles(); // 파일 담기
				if(files == null) {
					System.out.println("해당 파일이 존재하지 않습니다.");
					continue;
				}

				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) {
						if (i == 0) {
							String tempPath = files[i].getParent(); // c:\zest\talent\BEAUTY\1
							String tempFileName = files[i].getName(); // img0.jpg
							String subPath = tempPath.substring(8); // talent\BEAUTY\1

							System.out.println("sub Path : " + subPath);
							System.out.println("tempPtah 값 : " + tempPath);
							System.out.println("tempFileName 값: " + tempFileName);

							Map<String, String> image = new HashMap<>();
							categoryPageList.get(j).setTc_image_path("/LocalImage/" + subPath + "/" + tempFileName);
							break;
						}
					}
				}
			}

			// ------------------- 이미지 작업 끝 ----------------------------

			// View에 넘기는 데이터
			model.put("result", "대분류");
			model.put("count", count);
			model.put("categoryPageList", categoryPageList);
			model.put("pageNum", pageNum);
			model.put("search_text", search_text);
			model.put("search_type", search_type);
			model.put("bp", paging);

			modelAndView.addAllObjects(model);
			modelAndView.setViewName("category/categoryPage");
			return modelAndView;
		}
	}

	// 카테고리 페이지 리스트 반환(소분류)
	@RequestMapping(value = "/category/{category}/{lecture}", method = RequestMethod.GET)
	public ModelAndView categoryLecturePage(ModelAndView modelAndView, @PathVariable String category,
			@PathVariable String lecture, @RequestParam(required = false) String pageNum,
			@RequestParam(required = false) String search_type, @RequestParam(required = false) String search_text) {

		System.out.println("카테고리 컨트롤러 - 받아온 카테고리(소분류) 종류: " + lecture);
		System.out.println("검색된 텍스트: " + search_text);
		// VO에 받아온 카테고리를 입력
		CategoryPageVO vo = new CategoryPageVO();
		vo.setTalent_lecture_id(lecture); // View에서 받아온 URL 입력

		// ----------------------------- 시작 -------------------------

		if (pageNum == null || pageNum == "")
			pageNum = "1";

		// 현재페이지
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
		int pageSize = 9; // 페이지당 보여줄 글
		int pageBlockSize = 5; // 페이지 블록의 사이즈

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";

		// service로 넘겨줄 map객체 생성
		Map<String, Object> map = new HashMap<>();
		map.put("search_type", search_type);
		map.put("search_text", search_text);
		map.put("lecture_id", lecture);

		// 총 글 수 가져오기
		int count = categoryPageService.getCategoryPageListCount(map);
		System.out.println(count);

		// 페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());
		map.put("talent_category_id", vo.getTalent_category_id());
		map.put("talent_lecture_id", vo.getTalent_lecture_id());

		// ------------------------ 끝 -----------------------------

		// 카테고리 페이지 리스트를 받아옴
		List<CategoryPageVO> categoryPageList = categoryPageService.getLecturePageList(map);
		System.out.println("받아온 카테고리 리스트:" + categoryPageList.toString());

		// ------------------- 이미지 작업 ----------------------------

		Map<String, Object> model = new HashMap<>();

		for (int j = 0; j < categoryPageList.size(); j++) {
			System.out.println(categoryPageList.size());
			System.out.println("11111111111");
			File dirFile = new File(categoryPageList.get(j).getTc_image_path()); // 이미지 패키지 경로 c:\zest\talent\MUSIC\3
			System.out.println(dirFile);

			File[] files = dirFile.listFiles(); // 파일 담기
			if(files == null) {
				System.out.println("해당 파일이 존재하지 않습니다.");
				continue;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					if (i == 0) {
						String tempPath = files[i].getParent(); // c:\zest\talent\BEAUTY\1
						String tempFileName = files[i].getName(); // img0.jpg
						String subPath = tempPath.substring(8); // talent\BEAUTY\1

						System.out.println("sub Path : " + subPath);
						System.out.println("tempPtah 값 : " + tempPath);
						System.out.println("tempFileName 값: " + tempFileName);

						Map<String, String> image = new HashMap<>();
						/* image.put("image"+j, "/LocalImage/" + subPath + "/" + tempFileName); */

						categoryPageList.get(j).setTc_image_path("/LocalImage/" + subPath + "/" + tempFileName);

						/* model.put("image" + j, "/LocalImage/" + subPath + "/" + tempFileName); */
						break;
					}
					/* break; */
				}
				/* break; */
			}
		}

		// ------------------- 이미지 작업 끝 ----------------------------

		// View에 넘기는 데이터
		model.put("result", "소분류");
		model.put("lecture", lecture);
		model.put("category", category);
		model.put("count", count);
		model.put("categoryPageList", categoryPageList);
		model.put("pageNum", pageNum);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("bp", paging);

		modelAndView.addAllObjects(model);
		modelAndView.setViewName("category/categoryPage");
		return modelAndView;
	}

	// 메인화면에서 검색시 카테고리 페이지 리스트 반환
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView mainCategoryPage(ModelAndView modelAndView, @RequestParam(required = false) String pageNum,
			@RequestParam(required = false) String search_type, @RequestParam(required = false) String search_text) {

		System.out.println("메인화면에서 검색 카테고리 컨트롤러");
		System.out.println("받아온 검색 텍스트: " + search_text);

		if (pageNum == null || pageNum == "")
			pageNum = "1";

		// 현재페이지
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
		int pageSize = 9; // 페이지당 보여줄 글
		int pageBlockSize = 5; // 페이지 블록의 사이즈

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";

		// service로 넘겨줄 map객체 생성
		Map<String, Object> map = new HashMap<>();
		map.put("search_type", search_type);
		map.put("search_text", search_text);

		// 총 글 수 가져오기
		int count = categoryPageService.getCategoryPageListCount(map);
		System.out.println("대분류 페이지의 강의 갯수 : " + count);

		// 페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());

		// 카테고리 페이지 리스트를 받아옴
		List<CategoryPageVO> categoryPageList = categoryPageService.getCategoryPageList(map);
		System.out.println("받아온 카테고리 리스트:" + categoryPageList.toString());

		// ------------------- 이미지 작업 ----------------------------

		Map<String, Object> model = new HashMap<>();

		for (int j = 0; j < categoryPageList.size(); j++) {
			System.out.println(categoryPageList.size());
			System.out.println("11111111111");
			File dirFile = new File(categoryPageList.get(j).getTc_image_path()); // 이미지 패키지 경로 c:\zest\talent\MUSIC\3
			System.out.println(dirFile);

			File[] files = dirFile.listFiles(); // 파일 담기
			if(files == null) {
				System.out.println("해당 파일이 존재하지 않습니다.");
				continue;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					if (i == 0) {
						String tempPath = files[i].getParent(); // c:\zest\talent\BEAUTY\1
						String tempFileName = files[i].getName(); // img0.jpg
						String subPath = tempPath.substring(8); // talent\BEAUTY\1

						System.out.println("sub Path : " + subPath);
						System.out.println("tempPtah 값 : " + tempPath);
						System.out.println("tempFileName 값: " + tempFileName);

						Map<String, String> image = new HashMap<>();

						categoryPageList.get(j).setTc_image_path("/LocalImage/" + subPath + "/" + tempFileName);
						break;
					}
				}
			}
		}

		// ------------------- 이미지 작업 끝 ----------------------------

		// View에 넘기는 데이터
		model.put("result", "메인");
		model.put("count", count);
		model.put("categoryPageList", categoryPageList);
		model.put("pageNum", pageNum);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("bp", paging);

		modelAndView.addAllObjects(model);
		modelAndView.setViewName("category/categoryPage");
		return modelAndView;
	}
}
