
import java.io.IOException;
import java.io.PrintWriter;
    import java.sql.*;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VenderServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter pw;
        response.setContentType("text/html");
        pw =response.getWriter();
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String service=request.getParameter("service");
        String phoneno=request.getParameter("phoneno");
        
        String email=request.getParameter("email");
        String city=request.getParameter("city");
        
       
        
        
       
        
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/tatamotors";
                   String user="root";
                   String Password="";
                   
                   Connection con= DriverManager.getConnection(url,user,Password);
                           String query="Insert into Vender values(?,?,?,?,?,?);";
                           PreparedStatement pstmt=con.prepareStatement(query);
                           pstmt.setString(1,fname);
                           pstmt.setString(2,lname);
                           pstmt.setString(3,service);
                           pstmt.setString(4,phoneno);
                           
                           pstmt.setString(5,email);
                           pstmt.setString(6,city);
                           
                           
                           
                           int x=pstmt.executeUpdate();
                           if(x==1)
                           {
                               pw.println("Data Submitted Successfully....");
                           }
                                             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        pw.close();
    }
       
    }

 