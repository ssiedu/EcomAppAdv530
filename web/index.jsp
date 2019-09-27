<%@taglib  uri="/WEB-INF/tlds/mylib.tld" prefix="sample" %>

<sample:info/>

<%
    //session.setMaxInactiveInterval(150);
    
    
    String v1="",v2="";
    
    //step-1 (read all the cookies coming with request
        Cookie ck[]=request.getCookies();
    //step-2 (search for the desired one)
    if(ck!=null)
    for(int i=0; i<ck.length; i++){
        String name=ck[i].getName();
        if(name.equals("id")){
            v1=ck[i].getValue();
        }else if(name.equals("pw")){
            v2=ck[i].getValue();
        }
    }
%>
<html>
    <body>
        <h3>ECommerce-Application</h3>
        <hr>
        <form action="VerifyUser" method="get">
            <table >
            <tr>
                <td>Email</td><td><input type="text" name="email" value="<%=v1%>"/></td>
            </tr>
            <tr>
                <td>Password</td><td><input type="password" name="password" value="<%=v2%>"/></td>
            </tr>
            <tr>
                <td>Usertype</td><td><select name="utype"><option>buyer</option><option>admin</option></select></td>
            </tr>
            <tr>
                <td>Save Password</td><td><input type="checkbox" name="c1" value="yes" checked="checked"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="registration.jsp">New-User</a>
    </body>
</html>
