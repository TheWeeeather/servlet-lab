package servlets;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/update")
public class UpdateUser extends HttpServlet {
    private static SessionFactory sessionFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");

        String birthdayDate = req.getParameter("birthday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date bDate;
        try {
            bDate = dateFormat.parse(birthdayDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        User user = (User) session.get(User.class, id);
        user.setName(name);
        user.setBirthdayDate(bDate);
        session.update(user);

        transaction.commit();
        session.close();
        resp.sendRedirect("/read");
    }
}
