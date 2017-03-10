<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
    <%
    out.print("<label>停止服务！</label>");
/*     request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    
    String span = request.getParameter("span");
    
    if(span != null && span.equals("submit")) {
    	String p1 = request.getParameter("param1");
        String p2 = request.getParameter("param2");
        if(p1 != null && p1.trim().hashCode() != 0 && p2 != null && p2.trim().hashCode() != 0) {
        	try {
        		Connection conn = null;
            	String className = "com.mysql.jdbc.Driver";
            	String url = "jdbc:mysql://localhost:3306/chuangyejia?user=root&password=root";
            	Class.forName(className);
            	String id = UUID.randomUUID().toString().replaceAll("-", "");
    			conn = DriverManager.getConnection(url);
    			String sql = "insert into user(userId, userNickName, userPassword, userTel) values(?, ?, '123456', ?)";
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, id);
    			pstmt.setString(2, p1);
    			pstmt.setString(3, p2);
    			int count = pstmt.executeUpdate();
    			if(count == 1) {
    				out.print("<label>成功</label>");
    			} else {
    				out.print("<label>失败</label>");
    			}
    			
    			pstmt.close();
    			conn.close();
    			
        	} catch(Exception e) {
        		System.out.println("失败");
        	}
        }
    } */
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admin.jsp" type="post">
		<input name="param1" type="text" placeholder="昵称" />
		<input name="param2" type="tel" placeholder="电话" />
		<input type="hidden" name="span" value="submit" />
		<button type="submit">提交</button>
	</form>
</body>
</html>