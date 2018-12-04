
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Connection.Connection1;
import java.sql.*;
import java.util.*;
public class Payment extends HttpServlet
{
    Connection1 obj=new Connection1();
public void processRequest(HttpServletRequest res,HttpServletResponse rec) throws IOException,ServletException
{
    rec.setContentType("text/html");
    PrintWriter out=rec.getWriter();
    String username=res.getParameter("username");
    String userid=res.getParameter("userid");
    String accno=res.getParameter("accno");
    String aname=res.getParameter("aname");
    String pin=res.getParameter("pin");
    String ammount=res.getParameter("ammount");
    out.println("<html><body>");
    try
    {
        int num=paymentID();
    String sql="insert into payment(username,userid,accno,aname,ammount,paymentID) values (?,?,?,?,?,?)";
    PreparedStatement ps=obj.con.prepareStatement(sql);
    ps.setString(1, username);
    ps.setString(2, userid);
    ps.setString(3, accno);
    ps.setString(4, aname);
    ps.setString(5,ammount);
    ps.setInt(6,num);
    ps.executeUpdate();
     
    out.println("payment Successfylly");
    out.println("PaymentID->"+num);
    out.println("<a href=Home.html>Go to Home</a>");
    }
    catch(Exception e)
    {
        out.println(e.getMessage());
    }
    out.println("</body></html>");
}
  
 public void doGet(HttpServletRequest res,HttpServletResponse rec) throws IOException ,ServletException
    {
        processRequest(res,rec);
    }
    public void doPost(HttpServletRequest res,HttpServletResponse rec) throws IOException ,ServletException
    {
        processRequest(res,rec);
    }
    public int paymentID()
    {
        Random rand=new Random();
        int num=rand.nextInt(1000);
        return num;
    }
}
