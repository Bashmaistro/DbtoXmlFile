package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gelen veriyi al
        String veri = request.getParameter("veri");

        // Veritabanına bağlan
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoestore", "root", "17510067300");

            // Veriyi veritabanına yaz
            String query = "INSERT INTO tablo (sutun) VALUES (?)";
            PreparedStatement statement = ((Connection) conn).prepareStatement(query);
            statement.setString(1, veri);
            statement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
