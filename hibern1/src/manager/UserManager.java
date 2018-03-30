package manager;

import user.User;
import org.hibernate.*;
import org.hibernate.service.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;


public class UserManager {
	public static void main(String[] args) throws Exception {
		
	//	  如果在hibernate5.x以下版本创建服务注册对象和会话工厂对象应该用的是如下的语句来创建,否则会报错。 Configuration
	//	Configuration  conf = new Configuration() .configure(); 
	//	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build(); 
	//	SessionFactory sessionFactory =conf.buildSessionFactory(serviceRegistry);
		 
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// 创建会话工厂对象
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// 创建Session
		Session session = sessionFactory.openSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 创建消息对象
		User n = new User();
		// 设置消息标题和消息内容
		n.setUsername("nihao1");
		n.setPassword("zz1");
		n.setAddress("cn");
		// 保存消息
		session.save(n);
		// 提交事务
		tx.commit();
		// 关闭Session
		session.close();
		sessionFactory.close();
	}
}
