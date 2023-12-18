package servlets;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
    private static SessionFactory sessionFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/delete.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        int id = Integer.parseInt(req.getParameter("id"));

        User user = (User) session.get(User.class, id);
        session.delete(user);

        session.getTransaction().commit();
        session.close();
        resp.sendRedirect("/read");
    }
}
