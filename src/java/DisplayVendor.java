import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DisplayVendor extends HttpServlet {

   
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/tatamotors";
                   String user="root";
                   String Password="";
                   
                   Connection con= DriverManager.getConnection(url,user,Password);
                           
                   
                   
                   
           
                    PreparedStatement ps=con.prepareStatement("select * from vender");
                           
                    out.print("<center><table width=50% border=1>");
                    out.print("<caption>Vendor Details</caption>"); 
                           
                    ResultSet rs=ps.executeQuery(); 
                    
                    ResultSetMetaData rsmd=rs.getMetaData();
                    int total=rsmd.getColumnCount();
                    
                    out.print("<tr>");
                    for(int i=1; i<=total; i++)
                    {
                       out.print("<th>"+rsmd.getColumnName(i)+"</th>");
                    }
                    
                    out.print("</tr>");
                    
                    while(rs.next())
                    {
                    out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
                    }
                    out.print("</table></center>");
                    
                           
                           
               }
        catch(Exception e)
        {
          System.out.println(e);
          
        }
        finally
        {
             out.close();
        }
    }
    
}