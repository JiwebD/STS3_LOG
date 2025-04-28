package DbTests;


import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

@ExtendWith(SpringExtension.class)	
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
class MybatisTests {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private MemoMapper memoMapper;
	
	//MyBatis 연결 테스트
	@Test
	@Disabled
	void t1() {
		assertNotNull(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		assertNotNull(sqlSession);
		Connection conn = sqlSession.getConnection();
	}

	//
//	@Test
//	void test1() {
//		memoMapper.insert(new MemoDto(3,"b","a@exemple.com", LocalDateTime.now()));
//		memoMapper.update(new MemoDto(3,"d","d@exemple.com", LocalDateTime.now()));
//		memoMapper.delete(1);
//		System.out.println(memoMapper.selectAt(3));
		
//		List<MemoDto> list = memoMapper.selectAll();
//		list.forEach(System.out::println);
		
//		List<Map<String,Object>>list = memoMapper.selectAllResultMap();
		
//		list.forEach(System.out::println);
		
		//XML 방식
//		memoMapper.insertXml(new MemoDto(2020,"e","e@naver.com",LocalDateTime.now()));
		
//		List<Map<String,Object>> list = memoMapper.selectAllResultMapXml();
//		list.forEach(System.out::println);
		
//		MemoDto dto = new MemoDto(null,"a111","a111@naver.com",LocalDateTime.now());		
//		memoMapper.insert(dto);
//		System.out.println("RESULT : " + dto);

		
		
	@Test
	void test3() {
		
		Map<String,Object> param = new HashMap();
		param.put("type", "writer");
		param.put("keyword", "naver");
		
//		List< Map<String,Object> > response = memoMapper.Select_if_xml(param);
//		response.forEach(System.out::println);
		
		List< Map<String,Object> > response = memoMapper.Select_when_xml(param);
		response.forEach(System.out::println);
		
	}

}
