
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String sql = "SELECT * FROM products where pcode=?";
        try{
            Connection con=Data.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(code));
            ResultSet rs=ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Product-Details</h3>");
            out.println("<hr>");
            rs.next();
            String s1=rs.getString(1);//code
            String s2=rs.getString(2);//name
            String s3=rs.getString(3);//desc
            String s4=rs.getString(4);//catg
            String s5=rs.getString(5);//price
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<td>Code</td>");
            out.println("<td>"+s1+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Name</td>");
            out.println("<td>"+s2+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Desc</td>");
            out.println("<td>"+s3+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Catg</td>");
            out.println("<td>"+s4+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Price</td>");
            out.println("<td>"+s5+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=CartManager?code="+s1+">Add-To-Cart</a><br>");
            out.println("<a href=CategoryPage>Categories</a><br>");
            out.println("<a href=buyerpage.jsp>BuyerPage</a><br>");
            out.println("</body>");
            out.println("</html>");
            
            con.close();
        }catch(Exception e){
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
