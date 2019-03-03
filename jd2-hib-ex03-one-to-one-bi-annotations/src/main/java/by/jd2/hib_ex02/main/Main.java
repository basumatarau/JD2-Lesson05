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
		addUserAdnUserDetails();
		//retrieveUserAndUserDetails();
		//deleteUserAndUserDetails();
	}
	

	public static void addUserAdnUserDetails() throws ParseException {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd/mm/yyyy");
			Timestamp tb = new Timestamp(birthdayFormat.parse("03/03/2019").getTime());

			UserDetail userDetails = new UserDetail("Belarus", "Minsk", tb);
			User user = new User("Bob", "Dou`", "dou785@mail.com.by", "passwordstub", "saltstub",
					new Timestamp(System.currentTimeMillis()), userDetails);

			session.save(user);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	public static void retrieveUserAndUserDetails() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int id = 7;
		UserDetail userDetail = session.get(UserDetail.class, id);

		System.out.println(userDetail.getCity());
		System.out.println(userDetail.getCity() + " - " + userDetail.getUser().getEmail());

		session.getTransaction().commit();

		factory.close();
	}

	public static void deleteUserAndUserDetails() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int id = 9;
		UserDetail userDetail = session.get(UserDetail.class, id);

		session.delete(userDetail);

		session.getTransaction().commit();

		factory.close();

	}


}
