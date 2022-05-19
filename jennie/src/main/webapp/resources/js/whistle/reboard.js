$(document).ready(function(){
	/* 페이지 버튼 클릭이벤트 처리 */
	$('.pbtn').click(function(){
		// 페이지번호 읽고
		var pno = $(this).attr('id');
		// 페이지 번호 셋팅하고
		$('#nowPage').val(pno);
		// 폼 태그 전송
		$('#frm').submit();
	});
	
	/*
	// 홈버튼 클릭 이벤트 처리 
	$('#hbtn').click(function(){
		$(location).attr('href', '/whistle/main.blp');
	});
	
	// 로그인 버튼 클릭 이벤트 처리 
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.blp');
	});
	
	// 회원 가입 버튼 클릭 이벤트 처리 
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member.join.blp');
	});
	
	// 로그아웃 버튼 클릭이벤트 처리 
	$('#obtn').click(function(){
		$(location).attr('href', '/whistle/member/logout.blp');
	});
	*/
	
	$('.menubtn').click(function(){
		var bid = $(this).attr('id');
		
		var addr = '/whistle/';
		switch(bid){
		case 'hbtn':
			// 기본 주소를 사용
			break;
		case 'lbtn':
			addr = '/whistle/member/login.blp';
			break;
		case 'jbtn':
			addr = '/whistle/member/join.blp';
			break;
		case 'obtn':
			addr = '/whistle/member/logout.blp';
			break;
		case 'wbtn':
			$('#frm').attr('action', '/whistle/reboard/reboardWrite.blp');
			$('#frm').submit();
			return;
		}
		
		$(location).attr('href', addr);
	});
	
	$('#listbtn').click(function(){
		// form 태그의 액션 속성값 변경
		$('#frm').attr('action', '/whistle/reboard/reboardList.blp');
		// 사용하지 않는 태그 비활성시키고
		$('#mno').prop('disabled', true);
		$('#body').prop('disabled', true);
		
		$('#frm').submit();
	});
	
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	
	$('#wpbtn').click(function(){
		// 입력된 글 유효성 검사
		var txt = $('#body').val();
		
		txt = txt.trim();
		if(!txt || txt.length == 0){
			$('#body').val('');
			$('#body').focus();
			return;
		}
		
		$('#body').val(txt);
		
		$('#frm').submit();
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});