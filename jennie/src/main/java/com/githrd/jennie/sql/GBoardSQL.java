package com.githrd.jennie.sql;

public class GBoardSQL {
	public final int SEL_GBRD_LIST 	= 		1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_GBRD_LIST:
			buff.append("SELECT ");
			buff.append("    rno, gno, id, body, wdate, savename ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            ROWNUM rno, gno, id, body, wdate, savename ");
			buff.append("        FROM ");
			buff.append("            ( ");
			buff.append("                SELECT ");
			buff.append("                    gno, id, body, wdate, savename ");
			buff.append("                FROM ");
			buff.append("                    member m, guestboard g, avatar a ");
			buff.append("                WHERE ");
			buff.append("                    g.isshow = 'Y' ");
			buff.append("                    AND mno = writer ");
			buff.append("                    AND avt = ano ");
			buff.append("                ORDER BY ");
			buff.append("                    wdate DESC ");
			buff.append("            ) ");
			buff.append("    ) ");
//			buff.append("WHERE ");
//			buff.append("    rno BETWEEN ? AND ? ");
			break;
		}
		return buff.toString();
	}
}
