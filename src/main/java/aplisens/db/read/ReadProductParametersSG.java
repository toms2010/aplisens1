package aplisens.db.read;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.entity.ProductParametersSG;
import aplisens.logic.Properties;

public class ReadProductParametersSG {

	private final Logger log = LoggerFactory.getLogger(getClass());
	List<ProductParametersSG> dbList;
	private Properties properties = Properties.getInstance();

	public void read() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductParametersSG.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		String hql = "FROM ProductParametersSG WHERE temp like '%" + properties.getModelTag().get() + "%'";
		try {
			session.beginTransaction();
			dbList = session.createQuery(hql).getResultList();

			for (ProductParametersSG temp : dbList) {
				log.debug(temp.toString());
			}
		} finally {
			factory.close();
		}
	}

	public List<ProductParametersSG> getDbList() {
		return dbList;
	}

}
