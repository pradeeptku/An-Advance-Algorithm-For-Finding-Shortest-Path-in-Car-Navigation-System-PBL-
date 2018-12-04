/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Connection.Connection1;
import java.sql.*;
public class Card extends HttpServlet
{
    Connection1 obj=new Connection1();
    public void processRequest(HttpServletRequest res,HttpServletResponse rec) throws IOException,ServletException
{
   rec.setContentType("text/html");
   PrintWriter out=rec.getWriter();
   String size=res.getParameter("size");
   int quan=Integer.parseInt(res.getParameter("quan"));
   String type=res.getParameter("type");
   String fcolor=res.getParameter("fcolor");
   String bcolor=res.getParameter("bcolor");
   int price=0;
   if(size.equalsIgnoreCase("Small"))
       price=10*quan;
   else if(size.equalsIgnoreCase("Medium"))
       price=15*quan;
   else if(size.equalsIgnoreCase("Large"))
       price=20*quan;
   try
   {
       String sql="insert into Card(size,type,fcolor,bcolor,price) values (?,?,?,?,?)";
    PreparedStatement ps=obj.con.prepareStatement(sql);
    ps.setString(1, size);
    ps.setString(2, type);
    ps.setString(3, fcolor);
    ps.setString(4, bcolor);
    ps.setInt(5,price);
    ps.executeUpdate();
    out.println("<center>");
    
    out.println("<tr><td>Card Size-></td>"+size+"<td></td></tr><br>");
    out.println("<tr><td>Card type-></td>"+type+"<td></td></tr><br>");
    out.println("<tr><td>Card front Color-></td>"+fcolor+"<td></td></tr><br>");
    out.println("<tr><td>Card back color-></td>"+bcolor+"<td></td></tr><br>");
    out.println("<tr><td>Card quantity-></td>"+quan+"<td></td></tr><br>");
    out.println("<tr><td>Card Total Price-></td>"+price+"<td></td></tr><br>");
    
    out.println("<u><b><a href=Paymentc.html>Go for paymenet</a></b></u>");
    out.println("</center>");
   }
   catch(Exception e)
   {
       out.println("Connection problem");
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
