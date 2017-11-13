package edu.mum.cs.cs544.exercises;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class AppMain {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Session session = null;
	     Transaction tx = null;
	     
	     try{
	    	session=sessionFactory.openSession();
	    	tx=session.beginTransaction();
	    	 
	    	Doctor doctor=new Doctor("D001","Dr. Daniel","Kibrom");
	    	Payment payment=new Payment("01/01/2017",1200);
	    	Patient patient =new Patient("Zerai","1000 N","52557","Fairfield");
	    	Appointment appointment =new Appointment("01/01/2017",patient,payment,doctor);
	    	session.persist(appointment);
	 		tx.commit();
	    	 
	     }
	     catch (HibernateException ex){
	    	 if (tx!=null){
	    		 tx.rollback();
	    		 System.out.println("Error: "+ex.getMessage());
	    	 }
	     }
	     finally{
	    	 if (session!=null){
	    		 session.close();
	    	 }
	     }
	     
			try {
				session = sessionFactory.openSession();
				// tx = session.beginTransaction();
				@SuppressWarnings("unused")
				List<Appointment> appointmentlist = session.createQuery("from Appointment").list();
				for (Appointment a : appointmentlist) {
					System.out.println(a.toString());
				}
				
				System.out.println(
						"************************************Stage 2 Complete*******************************************");
				
				List<Patient> patientlist = session.createQuery("from Patient").list();
				for (Patient p : patientlist) {
					System.out.println(p.toString());
				}
				
				System.out.println(
						"************************************Stage 3 Complete*******************************************");

				List<Doctor> doctorlist = session.createQuery("from Doctor").list();
				for (Doctor d : doctorlist) {
					System.out.println(d.toString());
				}
				
				System.out.println(
						"************************************Stage 4 Complete*******************************************");


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
