package com.zest.web.client.service.talent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zest.web.client.dao.talent.TalentDAO;
import com.zest.web.client.model.talent.Talent_info;
import com.zest.web.client.model.classification.ZoneVO;
import com.zest.web.client.model.talent.TalentTimeUtil;
import com.zest.web.client.model.talent.TalentVO;
import com.zest.web.client.model.talent.Talent_contentVO;
import com.zest.web.client.model.talent.Talent_notOneDayTime;
import com.zest.web.client.model.tutor.TuTorVO;
import com.zest.web.client.service.zone.ZoneSearchService;

@Service
public class TalentInsertServiceImpl implements TalentInsertService {

	@Autowired
	private TalentDAO talentDAO;

	@Autowired
	private ZoneSearchService zoneSearch;

	// 강의 등록하기
	@Override
	public void insertTalent(TalentVO talentVO, Talent_contentVO contentVO, Talent_info talentInfo, TuTorVO tutorVO,
			TalentTimeUtil timeUtil) {
		/*
		 * talent 저장
		 */

		int meet_count = 0;
		// 몇 회차 수업인지 알아내고 값 저장하기
		if (timeUtil.getOneday() == 1) {// 원데이 항목
			meet_count = 1;
		} else {
			meet_count = contentVO.getTc_curriculum().length;
		}
		talentVO.setTalent_meet_count(meet_count);
		// total Price 넣기
		talentVO.setTalent_total_price(
				talentVO.getTalent_price_hour() * talentVO.getTalent_meet_count() * talentVO.getTalent_meet_time());
		// 등록한 튜터의 no 넣기com
		talentVO.setTalent_tt_no(tutorVO.getTt_no());
		// talent 내용 넣고 넣은 talent의 primary key 받아오기
		System.out.println(talentVO.toString());
		int no = talentDAO.insertTalent(talentVO);

		// int no = 3;
		/*
		 * talent_content 저장
		 */
		// Talent_Content table에 내용 넣기
		contentVO.setTalent_no(no);
		contentVO.setTutor_no(tutorVO.getTt_no());

		// 이미지경로 업데이트하기
		File talentFolder = new File("c:/zest/talent/" + talentVO.getTalent_category_id() + "/" + no);
		if (!talentFolder.exists()) { // 해당 폴더가 없으면 생성
			talentFolder.mkdirs();
		} // 업로드

		// 파일,사진 로컬에 저장하기
		for (int i = 0; i < contentVO.getTalentImg().length; i++) {
			MultipartFile file = contentVO.getTalentImg()[i];
			if (!file.isEmpty()) {
				String talentImgOriginalFileName = file.getOriginalFilename();
				String localFileName = "c:/zest/talent/" + talentVO.getTalent_category_id() + "/" + no + "/img" + i
						+ "." + getFileExtension(talentImgOriginalFileName);
				try {
					file.transferTo(new File(localFileName));
				} catch (IllegalStateException | IOException e) { //
					e.printStackTrace();
				}
			}
		}
		// 사진경로 vo 객체에 넣어주기
		String imagePath = "c:/zest/talent/" + talentVO.getTalent_category_id() + "/" + no + "/";
		contentVO.setTc_image_path(imagePath);

		for (int z = 0; z < contentVO.getTc_curriculum().length; z++) {
			System.out.println("원데이 수업 커리쿨렴" + contentVO.getTc_curriculum()[z].trim());
		}

		String html = ""; // 배열 처리되어있는 커리큘럼 항목 나누기

		if (timeUtil.getOneday() != 1) {// 원데이 아닌 항목

			for (int j = 0; j < contentVO.getTc_curriculum().length; j++) { // 해당 커리큘럼이 마지막일시
				if (j == contentVO.getTc_curriculum().length - 1) {
					html += contentVO.getTc_curriculum()[j].trim();
					contentVO.setTc_curri(html);
				} else {
					html += contentVO.getTc_curriculum()[j].trim() + "!@#%";
				}
			}

		} else { // oneDay 항목
			for (int j = 0; j < contentVO.getTc_curriculum().length; j++) { // 해당 커리큘럼이 마지막일시
				if (j == contentVO.getTc_curriculum().length - 1) {
					html += contentVO.getTc_curriculum()[j].trim();
					contentVO.setTc_curri(html);
				} else {
					html += contentVO.getTc_curriculum()[j].trim();
				}
			}
		}
		System.out.println(contentVO.toString());
		talentDAO.insertTC(contentVO);
		/*
		 * talent_info 저장
		 */

		// db 에 넣을 talent_info List 처리
		System.out.println(timeUtil.toString());
		List<Talent_info> tt_infoList = new ArrayList<>();
		// 시간 항목 넣기
		for (int z = 0; z < timeUtil.getCount(); z++) {
			if (timeUtil.getOneday() != 1) { // 원데이 아닌 항목
				Talent_info tt_infoVO = new Talent_info();
				String key = "zone" + (z + 1);
				TalentTimeUtil z1 = timeUtil.getTimeData().get(key);
				// info 테이블에 zone id 값 가져오기
				ZoneVO zoneVo = new ZoneVO();
				zoneVo.setZone_name(z1.getZone_id());
				System.out.println(z1.getZone_id());
				zoneVo = zoneSearch.getZoneVOforName(zoneVo);

				System.out.println(zoneVo.toString());

				// db에 검색해서 해당 id값 저장
				tt_infoVO.setZone_id(zoneVo.getZone_id());
				// timeData 항목 처리 하기
				if (z1.getMon() != null) {// 월요일
					Talent_notOneDayTime tt_notOneTimeData = new Talent_notOneDayTime();
					for (int x = 0; x < z1.getMon().size(); x++) {
						// 시간 협의 일때
						if (x == 0) {
							if (z1.getMon().get(x).contains("시간협의")) {
								tt_infoVO.setTi_mon(0);
								break;
							}
							tt_notOneTimeData.setTime1(z1.getMon().get(x));
						}
						if (x == 1) {
							if (!z1.getMon().get(x).equals("")) {
								tt_notOneTimeData.setTime2(z1.getMon().get(x));
							}
						}
						if (x == 2) {
							if (!z1.getMon().get(x).equals("")) {
								tt_notOneTimeData.setTime3(z1.getMon().get(x));
							}
						}
						// 마지막 data일시 해당 내용을 db에 저장하고 저장된 primary key값을 talent_info 에 저장한다.
						if (x == z1.getMon().size() - 1) {
							System.out.println(tt_notOneTimeData.toString());
							tt_infoVO.setTi_mon(talentDAO.insertNotOneDayTime(tt_notOneTimeData));
						}
					}
				} // end 월

				if (z1.getTue() != null) {// 화요일
					Talent_notOneDayTime tt_notOneTimeData = new Talent_notOneDayTime();
					for (int x = 0; x < z1.getTue().size(); x++) {
						// 시간 협의 일때
						if (x == 0) {
							if (z1.getTue().get(x).contains("시간협의")) {
								tt_infoVO.setTi_tue(0);
								break;
							}
							tt_notOneTimeData.setTime1(z1.getTue().get(x));
						}
						if (x == 1) {
							if (!z1.getTue().get(x).equals("")) {
								tt_notOneTimeData.setTime2(z1.getTue().get(x));
							}
						}
						if (x == 2) {
							if (!z1.getTue().get(x).equals("")) {
								tt_notOneTimeData.setTime3(z1.getTue().get(x));
							}
						}
						// 마지막 data일시 해당 내용을 db에 저장하고 저장된 primary key값을 talent_info 에 저장한다.
						if (x == z1.getTue().size() - 1) {
							System.out.println(tt_notOneTimeData.toString());
							tt_infoVO.setTi_tue(talentDAO.insertNotOneDayTime(tt_notOneTimeData));
						}
					}
				} // end 화

				if (z1.getWed() != null) {// 수요일
					Talent_notOneDayTime tt_notOneTimeData = new Talent_notOneDayTime();
					for (int x = 0; x < z1.getWed().size(); x++) {
						// 시간 협의 일때
						if (x == 0) {
							if (z1.getWed().get(x).contains("시간협의")) {
								tt_infoVO.setTi_wed(0);
								break;
							}
							tt_notOneTimeData.setTime1(z1.getWed().get(x));
						}
						if (x == 1) {
							if (!z1.getWed().get(x).equals("")) {
								tt_notOneTimeData.setTime2(z1.getWed().get(x));
							}
						}
						if (x == 2) {
							if (!z1.getWed().get(x).equals("")) {
								tt_notOneTimeData.setTime3(z1.getWed().get(x));
							}
						}
						// 마지막 data일시 해당 내용을 db에 저장하고 저장된 primary key값을 talent_info 에 저장한다.
						if (x == z1.getWed().size() - 1) {
							System.out.println(tt_notOneTimeData.toString());
							tt_infoVO.setTi_wed(talentDAO.insertNotOneDayTime(tt_notOneTimeData));
						}
					}
				} // end 수

				if (z1.getTur() != null) {// 목요일
					Talent_notOneDayTime tt_notOneTimeData = new Talent_notOneDayTime();
					for (int x = 0; x < z1.getTur().size(); x++) {
						// 시간 협의 일때
						if (x == 0) {
							if (z1.getTur().get(x).contains("시간협의")) {
								tt_infoVO.setTi_tur(0);
								break;
							}
							tt_notOneTimeData.setTime1(z1.getTur().get(x));
						}
						if (x == 1) {
							if (!z1.getTur().get(x).equals("")) {
								tt_notOneTimeData.setTime2(z1.getTur().get(x));
							}
						}
						if (x == 2) {
							if (!z1.getTur().get(x).equals("")) {
								tt_notOneTimeData.setTime3(z1.getTur().get(x));
							}
						}
						// 마지막 data일시 해당 내용을 db에 저장하고 저장된 primary key값을 talent_info 에 저장한다.
						if (x == z1.getTur().size() - 1) {
							System.out.println(tt_notOneTimeData.toString());
							tt_infoVO.setTi_tur(talentDAO.insertNotOneDayTime(tt_notOneTimeData));
						}
					}
				} // end 목

				if (z1.getFri() != null) {// 금요일
					Talent_notOneDayTime tt_notOneTimeData = new Talent_notOneDayTime();
					for (int x = 0; x < z1.getFri().size(); x++) {
						// 시간 협의 일때
						if (x == 0) {
							if (z1.getFri().get(x).contains("시간협의")) {
								tt_infoVO.setTi_fri(0);
								break;
							}
							tt_notOneTimeData.setTime1(z1.getFri().get(x));
						}
						if (x == 1) {
							if (!z1.getFri().get(x).equals("")) {
								tt_notOneTimeData.setTime2(z1.getFri().get(x));
							}
						}
						if (x == 2) {
							if (!z1.getFri().get(x).equals("")) {
								tt_notOneTimeData.setTime3(z1.getFri().get(x));
							}
						}
						// 마지막 data일시 해당 내용을 db에 저장하고 저장된 primary key값을 talent_info 에 저장한다.
						if (x == z1.getFri().size() - 1) {
							System.out.println(tt_notOneTimeData.toString());
							tt_infoVO.setTi_fri(talentDAO.insertNotOneDayTime(tt_notOneTimeData));
						}
					}
				} // end 금

				if (z1.getSat() != null) {// 토요일
					Talent_notOneDayTime tt_notOneTimeData = new Talent_notOneDayTime();
					for (int x = 0; x < z1.getSat().size(); x++) {
						// 시간 협의 일때
						if (x == 0) {
							if (z1.getSat().get(x).contains("시간협의")) {
								tt_infoVO.setTi_sat(0);
								break;
							}
							tt_notOneTimeData.setTime1(z1.getSat().get(x));
						}
						if (x == 1) {
							if (!z1.getSat().get(x).equals("")) {
								tt_notOneTimeData.setTime2(z1.getSat().get(x));
							}
						}
						if (x == 2) {
							if (!z1.getSat().get(x).equals("")) {
								tt_notOneTimeData.setTime3(z1.getSat().get(x));
							}
						}
						// 마지막 data일시 해당 내용을 db에 저장하고 저장된 primary key값을 talent_info 에 저장한다.
						if (x == z1.getSat().size() - 1) {
							System.out.println(tt_notOneTimeData.toString());
							tt_infoVO.setTi_sat(talentDAO.insertNotOneDayTime(tt_notOneTimeData));
						}
					}
				} // end 토요일

				if (z1.getSun() != null) {// 일요일
					Talent_notOneDayTime tt_notOneTimeData = new Talent_notOneDayTime();
					for (int x = 0; x < z1.getSun().size(); x++) {
						// 시간 협의 일때
						if (x == 0) {
							if (z1.getSun().get(x).contains("시간협의")) {
								tt_infoVO.setTi_sun(0);
								break;
							}
							tt_notOneTimeData.setTime1(z1.getSun().get(x));
						}
						if (x == 1) {
							if (!z1.getSun().get(x).equals("")) {
								tt_notOneTimeData.setTime2(z1.getSun().get(x));
							}
						}
						if (x == 2) {
							if (!z1.getSun().get(x).equals("")) {
								tt_notOneTimeData.setTime3(z1.getSun().get(x));
							}
						}
						// 마지막 data일시 해당 내용을 db에 저장하고 저장된 primary key값을 talent_info 에 저장한다.
						if (x == z1.getSun().size() - 1) {
							System.out.println(tt_notOneTimeData.toString());
							tt_infoVO.setTi_sun(talentDAO.insertNotOneDayTime(tt_notOneTimeData));
						}
					}
				} // end 일

				// info 객체를 List에 저장한다
				tt_infoVO.setTalent_no(no);
				tt_infoVO.setTi_status(0);// 원데이 항목이 아님을 명시한다.
				tt_infoList.add(tt_infoVO);
			} else {// 원데이 항목
				Talent_info tt_infoVO = new Talent_info();
				String key = "zone" + (z + 1);
				TalentTimeUtil z1 = timeUtil.getTimeData().get(key);
				// info 테이블에 zone id 값 가져오기
				ZoneVO zoneVo = new ZoneVO();
				zoneVo.setZone_name(z1.getZone_id());

				zoneVo = zoneSearch.getZoneVOforName(zoneVo);
				System.out.println("oneDayTime에서 저장되는 지역" + zoneVo.toString());
				tt_infoVO.setZone_id(zoneVo.getZone_id()); // info에 해당 id값 저장
				if (z1.getMon_onday() != 0) {// 각각의 요일항목 저장
					tt_infoVO.setTi_mon(z1.getMon_onday());
				}
				if (z1.getTue_onday() != 0) {
					tt_infoVO.setTi_tue(z1.getTue_onday());
				}
				if (z1.getWed_onday() != 0) {
					tt_infoVO.setTi_wed(z1.getWed_onday());
				}
				if (z1.getTur_onday() != 0) {
					tt_infoVO.setTi_tur(z1.getTur_onday());
				}
				if (z1.getFri_onday() != 0) {
					tt_infoVO.setTi_fri(z1.getFri_onday());
				}
				if (z1.getSat_onday() != 0) {
					tt_infoVO.setTi_sat(z1.getSat_onday());
				}
				if (z1.getSun_onday() != 0) {
					tt_infoVO.setTi_sun(z1.getSun_onday());
				}
				// info 객체를 List에 저장한다
				tt_infoVO.setTalent_no(no);
				tt_infoVO.setTi_status(1);// 원데이 항목임을 명시한다.
				tt_infoList.add(tt_infoVO);

			}

		} // end for문

		// Talent Info 테이블에 내용을 db에 저장한다.
		for (Talent_info ti : tt_infoList) {
			System.out.println(ti.toString());
		}
		for (Talent_info ti : tt_infoList) {
			talentDAO.insertTI(ti);
		}

	}

	// 파일확장자 구하는 메서드
	String getFileExtension(String data) {
		int pos = data.lastIndexOf(".");
		String ext = data.substring(pos + 1);
		return ext;
	}

}
