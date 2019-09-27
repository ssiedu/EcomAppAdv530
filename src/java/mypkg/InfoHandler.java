package mypkg;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class InfoHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try{
        out.println("<h3>Xyz Company</h3>");
        out.println("<p>Its An Ecom Company</p>");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
