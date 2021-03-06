package cs544.excercise03_2.part5;

import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
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

public class AppSuperCustomer {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	static{
		Configuration configuration=new Configuration();
		configuration.configure();
		serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String [] args){
		Session session=null;
		Transaction tx=null;
		int aId=0,bId=0,cId;
		try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
          //  List<Book> books=new ArrayList();
           Date d=new Date();
         //  d.setYear(1998);
        Customer1 c=new Customer1();
        c.setName("Daniel");
      //  e.setlName("Te");
        session.persist(c);
        Reservation1 r=new Reservation1();
        r.setCustomer(c);
        r.setDate(d);
        Book1 b=new Book1();
        b.setAuthor(c.getName());
        
        
        
        session.persist(b);

       
		System.out.println("************************************Stage 1 Complete*******************************************");
		tx.commit();
		
		}
		catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
		//session.close();
		try {
            session = sessionFactory.openSession();
          //  tx = session.beginTransaction();
            @SuppressWarnings("unused")
			List<Reservation1> rlist=session.createQuery("from Reservation").list();
            for(Reservation1 b:rlist){
            	System.out.println(b.toString());
            	System.out.println(b.getCustomer().getName());
            }
          //  tx.
    		System.out.println("************************************Stage 2 Complete*******************************************");

                        
		}
		catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
	System.exit(0);
		
}

}
