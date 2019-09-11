import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveProduct extends HttpServlet {

    private Connection con;
    private PreparedStatement ps;
    
    public void init(){
        try{
            con=Data.connect();
            String sql="insert into products values(?,?,?,?,?)";
            ps=con.prepareStatement(sql);        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        
        //reads the request
        String s1=request.getParameter("pcode");
        String s2=request.getParameter("pname");
        String s3=request.getParameter("pdesc");
        String s4=request.getParameter("pcat");
        String s5=request.getParameter("price");
        //process the request
        try{
            
            ps.setInt(1, Integer.parseInt(s1));
            ps.setString(2, s2);
            ps.setString(3, s3);
            ps.setString(4, s4);
            ps.setInt(5, Integer.parseInt(s5));
            ps.executeUpdate();
            out.println("<html>");
            out.println("<body>");
            out.println("<hr>");
            out.println("<h3>Product-Successfully-Added</h3>");
            out.println("<h4><a href=adminpage.jsp>AdminPage</a></h4>");
            out.println("<h4><a href=productentry.jsp>Add-More</a></h4>");
            out.println("<hr>");
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            out.println(e);
        }
        
        
        //provides the response
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
