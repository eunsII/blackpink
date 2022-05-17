package com.githrd.jennie.controller.guestBoard;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class GuestBoard implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/guestBoard/gBoardList";
		
		// 데이터베이스에서 게시글 리스트 가져오고
		GBoardDao gDao = new GBoardDao();
		ArrayList<BoardVO> list = gDao.getGBoardList();
		
		// 뷰에 데이터 심고
		req.setAttribute("LIST", list);
		
		// 뷰 부르고
		return view;
	}

}
