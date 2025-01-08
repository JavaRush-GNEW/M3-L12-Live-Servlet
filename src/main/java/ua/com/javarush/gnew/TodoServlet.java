package ua.com.javarush.gnew;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/todo")
public class TodoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        PrintWriter writer = resp.getWriter();

        ArrayList<String> todoList = (ArrayList<String>) session.getAttribute("todo-list");

        if (todoList == null){
            todoList = new ArrayList<>();
        }

        StringBuilder html = new StringBuilder();

        html.append("<html>");

        html.append("<head>");
        html.append("</head>");

        html.append("<body>");

            html.append("<h1> TODO LIST </h1>");

            html.append("<ul>");
                for (String listItem : todoList) {
                    html.append("<li>").append(listItem).append("</li>");
                }
            html.append("<ul>");

            html.append("<form method='post'>");

                html.append("<input type='text' name='item'/>");
                html.append("<input type='text' name='test'/>");
                html.append("<input type='submit' value='add'/>");

            html.append("</form>");

        html.append("</body>");

        html.append("</html>");

        resp.getWriter().println(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item = req.getParameter("item");

        HttpSession session = req.getSession(true);

        ArrayList<String> todoList = (ArrayList<String>) session.getAttribute("todo-list");

        if (todoList == null){
            todoList = new ArrayList<>();
        }

        todoList.add(item);
        session.setAttribute("todo-list", todoList);

        resp.sendRedirect(req.getContextPath() + "/todo");
    }
}
