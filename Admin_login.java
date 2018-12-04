
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Connection.Connection1;
import java.sql.*;
public class Admin_login extends HttpServlet
{
Connection1 obj=new Connection1();
    
    protected void processRequest(HttpServletRequest res, HttpServletResponse rec)throws ServletException, IOException 
    {
        rec.setContentType("text/html");
        PrintWriter out=rec.getWriter();
        String username=res.getParameter("username");
        String password=res.getParameter("password");
        
        try
        {
        String sql=" select username from admin_login where username=? and password=?";
        PreparedStatement ps=obj.con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            res.getRequestDispatcher("Admin.html").include(res, rec);
            out.println("Login Successfully....");
            out.println("username "+username);
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
