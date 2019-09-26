<%@page isThreadSafe="false"  errorPage="myerrors.jsp"  language="java" contentType="text/html" import="java.sql.*, java.util.Stack" %>


<%!
        Stack stk;
        public int highDis=20;
        int getDiscount(int price){
            int discount=0;
            if(price>=1000){
                discount=price*20/100;
            }else{
                discount=price*10/100;
            }
            return discount;
        }
%>

<%
    int code=Integer.parseInt(request.getParameter("t1"));
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/ecomdata";
    Connection con=DriverManager.getConnection(url, "root","root");
    String sql="select * from products where pcode=?";
    java.sql.PreparedStatement ps=con.prepareStatement(sql);
    ps.setInt(1, code);
    java.sql.ResultSet rs=ps.executeQuery();
    rs.next();
    String s1=rs.getString(1);
    String s2=rs.getString(2);
    String s3=rs.getString(3);
    String s4=rs.getString(4);
    String s5=rs.getString(5);
%>
<html>
    <body>
        <h3>Product-Details</h3>
        <hr>
        <pre>
            PCode   <%=s1%>
            Name    <%=s2%>
            Desc    <%=s3%>
            Catg    <%=s4%>
            Price   <%=s5%>
            Disc    <%=getDiscount(Integer.parseInt(s5))%>
                    
        </pre>
        <hr>
        <a href="search.jsp">Search-More</a><br>
        <a href="buyerpage.jsp">Home</a><br>
    </body>
</html>
    
<%
    con.close();
%>    
    