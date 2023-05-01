package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.InputStream;
import Database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/SellerLoginServlet")
@MultipartConfig
public class SellerLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String useremail = request.getParameter("useremail");
        String password = request.getParameter("password");
        String productName = request.getParameter("productname");
        int productPrice = Integer.parseInt(request.getParameter("productprice"));
        String productDescription = request.getParameter("productdescription");
        Part part = request.getPart("imagename");
        String ImageName = part.getSubmittedFileName();
//		String ImageName = request.getParameter("imagename");
        System.out.println(ImageName);

        out.println(username);
        out.println("<br>");
        out.println(useremail);
        out.println("<br>");
        out.println(password);
        out.println("<br>");
        out.println(productName);
        out.println("<br>");
        out.println(productDescription);
        out.println("<br>");
        out.println(ImageName);
        out.println("<br>");
        out.println(productPrice);

        //add to the database
        try {

//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root", "ritesh");
            String sql = "insert into sellerinfo(username,email,password,productname,productDescription,imageName) values(?,?,?,?,?,?)";

            PreparedStatement pst = Database.getConnection().prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, useremail);
            pst.setString(3, password);
            pst.setString(4, productName);
            pst.setString(5, productDescription);
            pst.setString(6, ImageName);
            pst.setInt(7, productPrice);

//                pst.executeUpdate();
            //upload the image server
            String Path = request.getRealPath("") + "Image";
            System.out.println("The File Path  : " + Path);
            out.println(Path);

            File f = new File(Path);
            part.write(Path + File.separator + ImageName);

//                InputStream is = part.getInputStream();
//                byte[] imagedata = new byte[is.available()];
//                is.read((imagedata));
//                
//                String imagePath = request.getRealPath("");
//                System.out.println(imagePath);
//                FileOutputStream fos = new FileOutputStream(imagePath);
            out.println("<br>");
            out.println("Uploaded");
            Database.getConnection().close();
        } catch (SQLException | ClassNotFoundException e) {
            out.println(e);
            out.println("There is an error ");
            e.printStackTrace();
        }
    }
}
