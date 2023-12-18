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
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/read")
public class ReadUsers extends HttpServlet {
    private static SessionFactory sessionFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        List<User> users = session.createQuery("FROM User").list();
        req.setAttribute("users", users);


        transaction.commit();
        session.close();

        getServletContext().getRequestDispatcher("/pages/read.jsp").forward(req, resp);
    }

}
