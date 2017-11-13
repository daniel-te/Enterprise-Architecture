package cs544.excercise05_1;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App_Customer_Product {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		int aId = 0, bId = 0, cId;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// List<Book> books=new ArrayList();
			// Date d=new Date();
			// d.setYear(1998);
			Customer c = new Customer();
			c.setFirst("Daniel");
			c.setLast("Te");
			Order order = new Order();
			order.setDate(new Date(System.currentTimeMillis()));
			c.addOrder(order);
			OrderLine orderline = new OrderLine();
			orderline.setQuantity(2);
			Product product1 = new CD("Heal The World","Pop Music","Danny");
//			product1.setName("abel");
//			product1.setDescription("tewelde");
			Product product2 = new Product();
			product2.setName("Laptop");
			product2.setDescription("Toshiba");
			// order.
			orderline.setProduct(product1);
			order.addOrderLine(orderline);
			session.persist(c);
			
			System.out.println(
					"************************************Stage 1 Complete*******************************************");
			tx.commit();

		} catch (HibernateException e) {
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
			// tx = session.beginTransaction();
			@SuppressWarnings("unused")
			List<Customer> customerlist = session.createQuery("from Customer").list();
			for (Customer b : customerlist) {
				System.out.println(b.toString());
			}
			
			System.out.println(
					"************************************Stage 2 Complete*******************************************");
			
			List<CD> CDlist = session.createQuery("from CD").list();
			for (CD c : CDlist) {
				System.out.println(c.toString());
			}
			
			System.out.println(
					"************************************Stage 3 Complete*******************************************");

		} catch (HibernateException e) {
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
