package com.zest.web.dbTest;


import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zest.web.client.model.LectureVO;


public class DbTest {
	
	static org.slf4j.Logger logger = LoggerFactory.getLogger(DbTest.class);
	
	@Test
	//Amazon DB 연결 테스트
	public void dbTest() throws Exception {					
		
		SqlSessionTemplate sqlSessionTemplate = getSqlSession();
				
		int result = sqlSessionTemplate.selectOne("com.mybatis.test.selectCount");
		System.out.println("결과 : "+result);		
		
		LectureVO lectureVO = new LectureVO();
		lectureVO.setCategory_id("MUSIC");
		
		List list = sqlSessionTemplate.selectList("com.mybatis.test.getCategoryId",lectureVO);
		
		for(int i=0;i<list.size();i++) {
			logger.info(list.get(i).toString());
		}
	}
	
	//카테고리 리스트 테스트
	@Test
	public void getCategoryTest() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = getSqlSession();
		
		List list = sqlSessionTemplate.selectList("com.zest.category.getCategoryList");
		for(int i=0;i<list.size();i++) {
			logger.info(list.get(i).toString());
		}
	}
	
	@Test
	public void getLectureTest()throws Exception{
		
		LectureVO lectureVO = new LectureVO();
		lectureVO.setCategory_id("DESIGN");
		SqlSessionTemplate session = getSqlSession();
		
		List list  = session.selectList("com.zest.lecture.getLectureList",lectureVO);
		for(int i=0;i<list.size();i++) {
			logger.info(list.get(i).toString());
		}
		
	}
	
	//sqlSession 가져오기
	SqlSessionTemplate getSqlSession() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//BasicDataS
		
		dataSource.setUrl("jdbc:log4jdbc:mariadb://zest.cmz2ikcdxqw8.ap-northeast-2.rds.amazonaws.com:3306/ZEST");
		//dataSource.setDriverClassName(org.mariadb.jdbc.Driver.class.getName());
		//log spider 사용
		dataSource.setDriverClassName(net.sf.log4jdbc.DriverSpy.class.getName());
		dataSource.setUsername("root");
		dataSource.setPassword("20180514");
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();		
		
		Resource resource = new ClassPathResource("myBatis/myBatis-config.xml");
		factoryBean.setConfigLocation(resource);	
		factoryBean.setDataSource(dataSource);
		
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factoryBean.getObject());
		
		return sqlSessionTemplate;
		
	}
	
	
}
