package by.jd2.hib_ex02.main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex02.bean.User;
import by.jd2.hib_ex02.bean.UserDetail;

public class Main {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class).addAnnotatedClass(UserDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd/mm/yyyy");
			Timestamp tb = new Timestamp(birthdayFormat.parse("02/02/2019").getTime());
			
			UserDetail userDetails = new UserDetail("Belarus", "Minsk", tb);
			User user = new User(
					"Bob",
					"Dou",
					"dou44@mail.com.by",
					"passwordstub",
					"saltstub",
					new Timestamp(System.currentTimeMillis()),
					userDetails
			);

			session.save(user);
			
			session.getTransaction().commit();

			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
