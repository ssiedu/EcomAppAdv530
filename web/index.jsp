<html>
    <body>
        <h3>ECommerce-Application</h3>
        <hr>
        <form action="VerifyUser" method="get">
            <table >
            <tr>
                <td>Email</td><td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>Password</td><td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Usertype</td><td><select name="utype"><option>admin</option><option>buyer</option></select></td>
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
