package edu.mum.cs.cs544.exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppBook {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

			// Create new instance of Book and set values in it
			Book book1 = new Book("How to get Happiness", "2341324", "Daniel", 120.00, df.parse("04/17/2015"));
			// save the car
			session.persist(book1);
			// Create new instance of Book and set values in it
			Book book2 = new Book("The last king", "12341234", "Abraham", 76.00, df.parse("04/17/2007"));
			// save the car
			session.persist(book2);
			Book book3 = new Book("The Best Gift", "3413412", "David", 54.00, df.parse("04/17/2012"));
			// save the car
			session.persist(book3);

			tx.commit();

		} catch (HibernateException | ParseException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

        try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();


			System.out.println("-------------------------");

			Query query1 = session.createQuery("from Book");
			List<Book> bookList = query1.list();
			//toString() method is overrided in the Book Class
			for (Book book : bookList)
				System.out.println(book);

			tx.commit();

		} catch (HibernateException  e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

    		System.out.println("-------------------------");

    		Book book1 = (Book) session.get(Book.class, 2L);
    		book1.setTitle("Anaconda");
    		book1.setPrice(75);
            session.persist(book1);
            Book book2 = (Book) session.get(Book.class, 3L);
            session.delete(book2);
            tx.commit();

        } catch (HibernateException  e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        

        
        try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();


			System.out.println("-------------------------");

			Query query2 = session.createQuery("from Book");
			List<Book> bookList2 = query2.list();
			//toString() method is overrided in the Book Class
			for (Book book : bookList2)
				System.out.println(book);

			tx.commit();

		} catch (HibernateException  e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
        
	}

}
