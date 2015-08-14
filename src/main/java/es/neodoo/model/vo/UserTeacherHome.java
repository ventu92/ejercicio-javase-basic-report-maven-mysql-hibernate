package es.neodoo.model.vo;

// default package
// Generated 14-ago-2015 12:06:57 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class UserTeacher.
 * @see .UserTeacher
 * @author Hibernate Tools
 */
@Stateless
public class UserTeacherHome {

	private static final Log log = LogFactory.getLog(UserTeacherHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UserTeacher transientInstance) {
		log.debug("persisting UserTeacher instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserTeacher persistentInstance) {
		log.debug("removing UserTeacher instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserTeacher merge(UserTeacher detachedInstance) {
		log.debug("merging UserTeacher instance");
		try {
			UserTeacher result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserTeacher findById(Integer id) {
		log.debug("getting UserTeacher instance with id: " + id);
		try {
			UserTeacher instance = entityManager.find(UserTeacher.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
