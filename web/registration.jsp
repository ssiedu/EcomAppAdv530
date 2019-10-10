<html>
        <script>

        var request;

        function one() {
            var v1=document.getElementById("email").value;
            request = new XMLHttpRequest();
            request.onreadystatechange = two;
            request.open("get", "Check.jsp?id"+v1, true);
            request.send(null);
        }
        function two() {
            if (request.status == 200 && request.readyState == 4)
                document.getElementById("data").innerHTML = request.responseText;
        }
    </script>

    <body>
        <h3>ECommerce-Application</h3>
        <h3>Registration Form</h3>
        <hr>
        <form action="SaveUser" method="get">
            <table >
            <tr>
                <td>Email</td><td><input type="text" id="email" name="email"/></td><td> <input type="button" value="Chk-Avlb" onclick="one()" /></td><td><div id="data">Result</div></td>
            </tr>
            <tr>
                <td>Password</td><td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Name</td><td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Address</td><td><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td>Mobile</td><td><input type="text" name="mobile"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
