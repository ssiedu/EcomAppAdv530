import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String utype=request.getParameter("utype");
        
        if(utype.equals("admin")){
            if(email.equals("admin@gmail.com") && password.equals("indore")){
              response.sendRedirect("adminpage.jsp");
            }else{
                response.sendRedirect("index.jsp");
                //out.println("Invalid Admin Credentials");
            }
        }else if(utype.equals("buyer")){
            
            String sql="SELECT * FROM users where email=? AND password=?";     
            try{
                Connection con=Data.connect();
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                boolean b=rs.next();
                if(b==true){
                    
                    //storing email in session
                    
                    //step-1 (fetch the sessio)
                    HttpSession session=request.getSession();
                    //step-2 (store the data in session)
                    session.setAttribute("user", email);
                    
                    
                    
                    
                    
                    String ch=request.getParameter("c1");
                    if(ch!=null){
                        //step-1 (create cookie object)
                        Cookie c1=new Cookie("id",email);
                        Cookie c2=new Cookie("pw",password);
                        //step-2 (set the maximum age)
                        c1.setMaxAge(60*60*24*7);
                        c2.setMaxAge(60*60*24*7);
                        //step-3 (add cookie to response)
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
                    
                    
                   response.sendRedirect("buyerpage.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                }
                con.close();
            }catch(Exception e){
                out.println(e);
            }
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
