package by.jd2.hib_ex01.main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex01.bean.User;
import by.jd2.hib_ex01.bean.UserDetail;

public class Main {

	public static void main(String[] args) throws ParseException {

		//addUserAdnUserDetails();
		//retrieveUserAndUserDetails();
		deleteUserAndUserDetails();

	}

	public static void addUserAdnUserDetails() throws ParseException {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd/mm/yyyy");
			Timestamp tb = new Timestamp(birthdayFormat.parse("03/03/2019").getTime());

			UserDetail userDetails = new UserDetail("Belarus", "Minsk", tb);
			User user = new User("Bob`", "Dou`", "dou55@mail.com.by", "passwordstub", "saltstub",
					new Timestamp(System.currentTimeMillis()), userDetails);

			session.save(user);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	public static void retrieveUserAndUserDetails() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 4;
			User user = session.get(User.class, 5);

			if (user != null) {
				System.out.println(user.getEmail() + " - ");
			}

			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

	public static void deleteUserAndUserDetails() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int id = 4;
		User user = session.get(User.class, id);

		if (user != null) {
			session.delete(user);
		}

		session.getTransaction().commit();

		factory.close();

	}

}
