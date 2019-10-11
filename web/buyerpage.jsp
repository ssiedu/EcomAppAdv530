<%@taglib  uri="/WEB-INF/tlds/mylib.tld" prefix="data" %>
<%@include file="header.jsp" %>
<%
    String user=(String)session.getAttribute("user");
    
        if(user==null){
            response.sendRedirect("index.jsp");
        }
        
    int n=session.getMaxInactiveInterval();
   
%>

<html>
    <body>
        <h3>WELCOME-<%=user%></h3>
        <h5>If you remain idle for <%=n%> seconds, your session will expire</h5>
        
        <hr>
        <pre>
           <a href="CategoryPage">Explore-Store</a>
           <a href="Shopping.jsp">View-Products</a>
           <a href="search.jsp">Search-Product</a>
           <a href="pricelist.jsp">View-Price-List</a>
           <a href="DisplayCart">View-Cart</a>
           <a href="EndSession">Logout</a>
        </pre>
        <hr>
        <data:prices/>
    </body>
</html>
