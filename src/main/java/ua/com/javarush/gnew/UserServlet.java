package ua.com.javarush.gnew;

import com.google.gson.Gson;
import ua.com.javarush.gnew.model.User;
import ua.com.javarush.gnew.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private static UserRepository userRepository = UserRepository.getInstance();
    private static Gson gson = new Gson();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");

        ArrayList<User> users = userRepository.getAll();
        String json = gson.toJson(users);

        PrintWriter writer = resp.getWriter();
        writer.print(json);

        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        User user = new User(id, name, email);

        userRepository.add(user);
    }
}
