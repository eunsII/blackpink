package com.githrd.jennie.controller.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.jennie.controller.BlpInter;

public class ReboardComment implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/reboard/reboardComment";
		// 할일
		// 로그인 체크
		
		// 파라미터 받고
		
		// 데이터베이스 조회
		
		// VO 만들어서 데이터 채우고
		
		// 데이터 심고
		
		// 뷰 부르고...
		return view;
	}

}
