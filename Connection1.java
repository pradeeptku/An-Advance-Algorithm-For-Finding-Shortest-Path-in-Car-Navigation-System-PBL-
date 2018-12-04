/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.*;

/**
 *
 * @author BIMAN
 */
public class Connection1
{
public String erro;
public Connection con=null;
    public Connection1()
    {
        
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:get","","");
        }
        catch(Exception e)
        {
            erro="Connection problem";
        }
    }    
}
