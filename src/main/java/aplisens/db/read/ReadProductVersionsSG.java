package aplisens.db.read;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.entity.ProductVersionSG;
import aplisens.logic.Properties;

public class ReadProductVersionsSG {

	private final Logger log = LoggerFactory.getLogger(getClass());
	List<ProductVersionSG> dbList;
	private Properties properties = Properties.getInstance();
	
	public void read() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductVersionSG.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductVersionSG WHERE temp like '%" + properties.getModelTag().get() + "%'";

		try {
			session.beginTransaction();
			dbList = session.createQuery(hql).getResultList();

			for (ProductVersionSG temp : dbList) {
				log.debug(temp.toString());
			}
		} finally {
			factory.close();
		}
	}

	public List<ProductVersionSG> getDbList() {
		return dbList;
	}

}
