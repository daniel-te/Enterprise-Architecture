package cs544.excercise04_1;

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



/**
 * Hello world!
 *
 */
public class App_Student_School 
{
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	static{
		Configuration configuration=new Configuration();
		configuration.configure();
		serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	}
	
    public static void main( String[] args )
    {
    	Session session=null;
		Transaction tx=null;
		int aId=0,bId=0,cId;
		try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
          //  List<Book> books=new ArrayList();
        //   Date d=new Date();
        //   d.setYear(1998);
        School s=new School();
        Student s1=new Student();
        //session.persist(s1);
        s1.setFirstName("Daniel");
        Student s2=new Student();
        //session.persist(s2);
        s2.setFirstName("Samuel");
        s2.setStudentid(s2.getId()+501);
        s.addStudents(s2);
        s1.setStudentid(s1.getId()+500);
        s.addStudents(s1);
        
        session.persist(s);   

		
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
		try {
            session = sessionFactory.openSession();
          //  tx = session.beginTransaction();
            @SuppressWarnings("unused")
			List<School> schoollist=session.createQuery("from School").list();
            for(School b:schoollist){
            	System.out.println(b.toString());
            	//for()
            	System.out.println(b.getStudents());
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
    }
}
