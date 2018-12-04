

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SessionTransfer extends HttpServlet 
{
public void processRequest(HttpServletRequest res,HttpServletResponse rec) throws IOException,ServletException
{
   rec.setContentType("text/html");
   PrintWriter out=rec.getWriter();
  res.getRequestDispatcher("Payment.html").include(res, rec);
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
