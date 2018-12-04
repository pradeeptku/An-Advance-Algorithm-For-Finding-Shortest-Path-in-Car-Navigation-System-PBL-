
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import Connection.Connection1;
public class Register extends HttpServlet 
{
    Connection1 obj=new Connection1();
    public void processRequest(HttpServletRequest res,HttpServletResponse rec) throws IOException,ServletException
    {
        rec.setContentType("text/html");
        PrintWriter out=rec.getWriter();
        String username=res.getParameter("username");
        String password=res.getParameter("password");
        String conpass=res.getParameter("conpass");
        String address=res.getParameter("address");
        String email=res.getParameter("email");
        String contact=res.getParameter("contact");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration status</title>");
        out.println("</head>");
        out.println("<body>");
        
       
        if((username.length()>8)&&(password.equalsIgnoreCase(conpass))&&(address!=null)&&(email!=null)&&(password.length()>8))
        {
            try
            {
               
                    
                    if(obj.con!=null)
                    {
                        
                        int num=randomnumber();
                        String sql="insert into register(username,password,address,email,contact,userid) values(?,?,?,?,?,?)";
                        PreparedStatement s=obj.con.prepareStatement(sql);
                        s.setString(1, username);
                        s.setString(2, password);
                        s.setString(3, address);
                       s.setString(4, email);
                       s.setString(5,contact);
                        s.setInt(6, num);
                        s.executeUpdate();
                        out.println("<center>");
                        out.println("<table><h1>");
                            out.println("<tr>");
                            out.println("<td bgcolor=red>username</td><td bgcolor=green>"+username+"</td></tr>");
                            out.println("<tr>");
                            out.println("<td bgcolor=yellow>Password</td><td bgcolor=blue>"+password+"</td></tr>");
                            out.println("<tr>");
                            out.println("<td bgcolor=red>userid</td><td bgcolor=yellow>"+num+"</td></tr>");
                            out.println("<tr>");
                            out.println("<td>Register status</td><td bgcolor=green>Register Succesfully</td></tr>");
                        out.println("</h1></table>");
                        out.println("<b>");
                        out.println("<a href=Register.html>Go to again regtration page</a>");
                        out.println("<u><a href=User_login.html>Login</a>");
                        out.println("</b>");
               
                        out.println("</center>");
                        obj.con.close();
                        s.close();
                    }
                    else
                    {
                        out.println("Connection Problem");
                    }
                    
            }
            catch(Exception e)
            {
               out.println(obj.erro);
               out.println("<a href=Register.html>Go to again regtration page</a>");
            }
            
        }
        else
        {
       out.println("plz enter all information correctly");
       out.println("<a href=Register.html>Go to again regtration page</a>");
        }
       
       out.println("</body>");
       out.println("</html>");
    }
    public void doGet(HttpServletRequest res,HttpServletResponse rec) throws IOException ,ServletException
    {
        processRequest(res,rec);
    }
    public void doPost(HttpServletRequest res,HttpServletResponse rec) throws IOException ,ServletException
    {
        processRequest(res,rec);
    }
   public int randomnumber()
   {
       Random rand=new Random();
       int num=rand.nextInt(100000);
       return num;
   }
}
