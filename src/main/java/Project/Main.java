package Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Hibernate.config.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sfactory=meta.buildSessionFactory();
		Session session=sfactory.openSession();
		
		Transaction t=session.beginTransaction();	
		
		try {
			Country C=new Country();
			C.setCode(+91);
			C.setCountryname("India");
			
			States s1=new States();
			s1.setState_name("Telangana");
			
			States s2=new States();
			s2.setState_name("Karnataka");
			
			States s3=new States();
			s3.setState_name("TamilNadu");
			
			C.getStates().add(s1);			
			C.getStates().add(s2);
			C.getStates().add(s3);
			
			s1.setCountry(C);
			s2.setCountry(C);
			s3.setCountry(C);
			session.save(C);
			t.commit();
			
		}finally {
			sfactory.close();
			session.close();
		}

	}

}
