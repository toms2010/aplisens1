package aplisens.db.read;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.entity.ProductType;

public class ReadProductType {

	private final Logger log = LoggerFactory.getLogger(getClass());
	List<ProductType> dbList;

	public void read() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductType.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		String hql= "FROM ProductType GROUP BY tag";
		try {
			session.beginTransaction();
			dbList = session.createQuery(hql).getResultList();
			for (ProductType temp : dbList) {
				log.debug(temp.toString());
			}
		} finally {
			factory.close();
		}
	}

	public List<ProductType> getDbList() {
		return dbList;
	}

}
