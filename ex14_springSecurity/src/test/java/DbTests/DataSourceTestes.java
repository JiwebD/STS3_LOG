//package DbTests;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//
//import javax.sql.DataSource;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.example.app.domain.dao.MemoDaoImpl;
//import com.example.app.domain.dto.MemoDto;
//
//
//@ExtendWith(SpringExtension.class)	
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
//class DataSourceTestes {
//
//	@Autowired
//	private DataSource dataSource1;
//	
//	@Autowired
//	private DataSource dataSource2;
//	
//	@Autowired
//	private DataSource dataSource3;
//	
//	@Autowired
//	private MemoDaoImpl memoDaoImpl;
//	
//	@Test
//	@Disabled
//	void test1() throws SQLException {
//		System.out.println(dataSource1);
//		Connection con = dataSource1.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values(1,2,'abcd','abcd','abcd','a')");
//		pstmt.executeUpdate();
//	}
//	
//	@Test
//	@Disabled
//	void test2() throws Exception {
//		memoDaoImpl.insert(new MemoDto(2,"b","c", LocalDateTime.now(),null));
//
//	}
//	
//	@Test
//	@Disabled
//	void test3() throws Exception {
//		System.out.println(dataSource2);
//		Connection con = dataSource2.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values(3,3,'aaa','bbb','ccc','a')");
//		pstmt.executeUpdate();
//	}
//	
//	@Test
//	void test4() throws Exception {
//		System.out.println(dataSource3);
//		Connection con = dataSource3.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values(4,4,'aaa','bbb','ccc','a')");
//		pstmt.executeUpdate();
//	}
//		
//
//}
