

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Connection.Connection1;
import java.sql.*;

public class PaymentDetails extends HttpServlet
{
    Connection1 org=new Connection1();
protected void processRequest(HttpServletRequest res, HttpServletResponse rec) throws ServletException,IOException
    {
        rec.setContentType("text/html");
        PrintWriter out=rec.getWriter();
        
        out.println("<center>");
        out.println("<h1><b>User Paymenet details</b></h1><br>");
        out.println("<table bgcolor=green>");
        out.println("<tr><td>username  </td><td>userid  </td><td>Account no  </td><td>aname  </td><td>ammount  </td><td>Paymenet Id  </td></tr><br>");
        try
        {
            String sql="select * from payment";
            PreparedStatement ps=org.con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                //out.println(rs.getString(1));
               out.println("<tr><td>"+rs.getString(1)+"  </td><td>"+rs.getString(2)+"  </td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"  </td></tr><br>"); 
            }
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
        out.println("</table>");
        out.println("<u><a href=Admin_login.html>Login</a></u>    <u><a href=Home.html>Home</a></u>");
        out.println("</center>");
        
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

   