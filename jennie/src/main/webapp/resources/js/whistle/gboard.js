$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href', '/whistle/');
	});
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member/join.blp');
	});
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.blp');
	});
	$('#obtn').click(function(){
		$(location).attr('href', '/whistle/member/logout.blp');
	});
});