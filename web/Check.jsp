<%@page import="java.sql.*"%>
<%
    String id=request.getParameter("id");
    String sql="select email from users where email=?";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdata", "root", "root");
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1, id);
    ResultSet rs=ps.executeQuery();
    boolean b=rs.next();
    if(b==false){
        out.println("available");
    }else{
        out.println("not-available");
    }
    con.close();
%>