package ua.com.javarush.gnew;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/test")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");


        String response = """ 
                <html>
                <head>
                    <style>
                        
                    </style>
                </head>
                
             
                
                <body>
                <h1> Hello world! </h1>
                
                <div> Text </div>
                </body>
            
                </html>
                
                """;



        resp.setHeader("Content-Type", "text/html");
        PrintWriter writer = resp.getWriter();

        writer.write(response);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("POST RESPONSE");

        writer.close();
    }
}
