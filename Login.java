

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Connection.Connection1;
import java.sql.*;
import javax.servlet.RequestDispatcher;
public class Login extends HttpServlet {
Connection1 obj=new Connection1();
    
    protected void processRequest(HttpServletRequest res, HttpServletResponse rec) throws ServletException,IOException
    {
        
    rec.setContentType("text/html");
    PrintWriter out=rec.getWriter();
    String username=res.getParameter("username");
    String password=res.getParameter("password");
    String userid=res.getParameter("userid");
    
       try
       {
           String sql="select username,userid from register where username=? and password=? and userid=?";
           PreparedStatement s=obj.con.prepareStatement(sql);
           s.setString(1, username);
           s.setString(2, password);
           s.setString(3, userid);
           
           ResultSet rs=s.executeQuery();
           if(rs.next())
           {   
               
               RequestDispatcher myDispatch = res.getRequestDispatcher("user_home.html");
                
               myDispatch.forward(res, rec);
               
            }
           else
           {
               out.println("<script type=\"text/javascript\">");
       out.println("alert('User or password incorrect');");
       out.println("</script>");
       RequestDispatcher myDispatch = res.getRequestDispatcher("Home.html");
       myDispatch.forward(res, rec);
           }
       }
       catch(Exception e)
       {
           out.println(obj.erro);
       }
    
}
    public void doGet(HttpServletRequest res,HttpServletResponse rec) throws IOException ,ServletException
    {
        processRequest(res,rec);
    }
    public void doPost(HttpServletRequest res,HttpServletResponse rec) throws IOException ,ServletException
    {
        processRequest(res,rec);
    }
}
