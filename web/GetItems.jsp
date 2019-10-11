<%@page import="java.sql.*"%>
<%
    String cat=request.getParameter("t1");
    String qr="select * from products where pcat=?";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdata","root","root");
    PreparedStatement ps=con.prepareStatement(qr);
    ps.setString(1,cat);
    ResultSet rs=ps.executeQuery();
%>
<table border="2" width="2" cellspacing="2" cellpadding="3">
    <thead>
        <tr>
            <th>Code</th>
            <th>Title</th>
            <th>Desc</th>
            <th>Catg</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
<%
    while(rs.next()){
        String s1=rs.getString(1);
        String s2=rs.getString(2);
        String s3=rs.getString(3);
        String s4=rs.getString(4);
        String s5=rs.getString(5);
%>    
        
        <tr>
            <td><%=s1%></td>
            <td><%=s2%></td>
            <td><%=s3%></td>
            <td><%=s4%></td>
            <td><%=s5%></td>
        </tr>
  
 <%
    }
    con.close();
 %>
    </tbody>
</table>
