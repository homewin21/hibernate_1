package manager;

import user.User;
import org.hibernate.*;
import org.hibernate.service.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;


public class UserManager {
	public static void main(String[] args) throws Exception {
		
	//	  �����hibernate5.x���°汾��������ע�����ͻỰ��������Ӧ���õ������µ����������,����ᱨ�� Configuration
	//	Configuration  conf = new Configuration() .configure(); 
	//	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build(); 
	//	SessionFactory sessionFactory =conf.buildSessionFactory(serviceRegistry);
		 
		// ��������ע�����
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// �����Ự��������
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// ����Session
		Session session = sessionFactory.openSession();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// ������Ϣ����
		User n = new User();
		// ������Ϣ�������Ϣ����
		n.setUsername("nihao1");
		n.setPassword("zz1");
		n.setAddress("cn");
		// ������Ϣ
		session.save(n);
		// �ύ����
		tx.commit();
		// �ر�Session
		session.close();
		sessionFactory.close();
	}
}
