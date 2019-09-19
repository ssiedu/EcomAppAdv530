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
           <a href="">Search-Product</a>
           <a href="DisplayCart">View-Cart</a>
           <a href="EndSession">Logout</a>
        </pre>
        <hr>
    </body>
</html>
