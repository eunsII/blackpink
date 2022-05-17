package com.githrd.jennie.dao;

/**
 *  이 클래스는 방명록 관련 데이터베이스 작업을 전담해서 처리할 기능의 클래스
 * @author	전은석
 * @since	2022/05/17
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022/05/17	-	담당자 : 전은석
 * 								클래스 제작
 * 								리스트가져오기 전담 처리함수 제작
 * 							
 *
 */

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.githrd.jennie.db.*;
import com.githrd.jennie.sql.*;
import com.githrd.jennie.vo.*;

public class GBoardDao {
	private BlpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private GBoardSQL gSQL;
	
	public GBoardDao() {
		// 커넥션 풀 찾고
		db = new BlpDBCP();
		// 질의명령 준비
		gSQL = new GBoardSQL();
	}
	
	// 게시글 리스트 가져오기 전담 처리함수
	public ArrayList<BoardVO> getGBoardList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// 커넥션
		con =db.getCon();
		// 질의명령
		String sql = gSQL.getSQL(gSQL.SEL_GBRD_LIST);
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성(페이징처리)
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 결과에서 꺼내서 VO에 담고
				BoardVO bVO = new BoardVO();
				int rno = rs.getInt("rno");
				int bno = rs.getInt("gno");
				String id = rs.getString("id");
				String body = rs.getString("body");
				String avatar = rs.getString("savename");
				Date wdate = rs.getDate("wdate");
				Time wtime = rs.getTime("wdate");
				// vo에 채우고
				bVO.setRno(rno);
				bVO.setBno(bno);
				bVO.setId(id);
				bVO.setBody(body);
				bVO.setAvatar(avatar);
				bVO.setWdate(wdate);
				bVO.setWtime(wtime);
				bVO.setSdate();
				
				// VO를 list에 담고
				list.add(bVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// list 반환하고
		return list;
	}
}
