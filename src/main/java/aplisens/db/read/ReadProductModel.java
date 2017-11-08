package aplisens.db.read;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.entity.ProductModel;
import aplisens.logic.Properties;

public class ReadProductModel {

	private final Logger log = LoggerFactory.getLogger(getClass());
	List<ProductModel> dbList;
	private Properties properties = Properties.getInstance();

	public void read() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductModel.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		String hql = "FROM ProductModel WHERE tag='" + properties.getTypeTag().get() + "'";
		try {
			session.beginTransaction();
			dbList = session.createQuery(hql).getResultList();

			for (ProductModel temp : dbList) {
				log.debug(temp.toString());
			}
		} finally {
			factory.close();
		}
	}

	public List<ProductModel> getDbList() {
		return dbList;
	}

}
