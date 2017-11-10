package cs544.excercise03_2.part3;

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

public class AppStudent {
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
        //   Date d=new Date();
        //   d.setYear(1998);
        Student e=new Student();
        e.setfName("Daniel");
        e.setlName("Te");
        session.persist(e);
        Course d=new Course();
        d.setName("EA");
       // d.getEmployees().add(e);
       // Employee p=new Employee();
       // p.setName("Dawit");
       // d.getEmployees().add(p);
        session.persist(d);

        //session.persist(a);

		//session.persist(b);
		//session.persist(c);
		// aId=a.getId();
		// bId=b.getId();
		// cId=c.getId();
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
			List<Student> studentlist=session.createQuery("from Student").list();
            for(Student b:studentlist){
            	System.out.println(b.toString());
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
