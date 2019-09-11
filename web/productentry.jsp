<html>
    <body>
        <h3>ECommerce-Application</h3>
        <h3>Product Entry Form</h3>
        <hr>
        <form action="SaveProduct" method="get">
            <table >
            <tr>
                <td>PCode</td><td><input type="text" name="pcode"/></td>
            </tr>
            <tr>
                <td>PName</td><td><input type="text" name="pname"/></td>
            </tr>
            <tr>
                <td>PDesc</td><td><input type="text" name="pdesc"/></td>
            </tr>
            <tr>
                        <td>Catg</td><td><select name="pcat">
                                <option>books</option>
                                <option>computers</option>
                                <option>electronics</option>
                                <option>mobiles</option>
                                <option>furniture</option>
                                <option>others</option>
                          </select></td>
            </tr>
            <tr>
                <td>Price</td><td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>
