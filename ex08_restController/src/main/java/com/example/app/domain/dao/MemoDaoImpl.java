package com.example.app.domain.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.domain.dto.MemoDto;

@Repository
public class MemoDaoImpl {
	
//	@Autowired
//	private DataSource dataSource1;
//	
//	public int insert(MemoDto memoDto) throws SQLException{
//		Connection con = dataSource1.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into tbl_memo values(?,?,?,?)");
//		pstmt.setInt(1,  memoDto.getId());
//		pstmt.setString(2,memoDto.getText());
//		pstmt.setString(3,memoDto.getWriter());	
//		pstmt.setTimestamp(4,Timestamp.valueOf(memoDto.getCreateAt()));
//		int result = pstmt.executeUpdate();
//		return result;
//	}
	
	
	@Autowired
	private SqlSession sqlsession;
	private static String namespace="com.example.app.domain.mapper.MemoMapper.";
	
	public int insert(MemoDto memoDto) throws SQLException{
		sqlsession.insert(namespace+"insert",memoDto);
		System.out.println("MemoDaoImpl's insert invoke... " + memoDto);
		return memoDto.getId(); //자동증가한 다음 숫자의 Id값 리턴(Select Key)
	}
	
	
}
