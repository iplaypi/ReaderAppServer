package pers.perry.readerapp.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pers.perry.readerapp.util.DBHelper;

public class DaoSupportImpl<T> implements DaoSupport<T> {

	private static final Log log = LogFactory.getLog(DaoSupportImpl.class);
	private Class<T> clazz;
	protected Session session;

	@SuppressWarnings("unchecked")
	public DaoSupportImpl() {
		super();
		// 利用反射，得到类的真正类型
		// 获取当前new的对象的泛型的父类类型(this不是指本类,而是指当前new的对象)
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		// 获取第一个类型参数的真实类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql = "from " + clazz.getSimpleName();
		List<T> list = null;
		session = DBHelper.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			log.error(e.getMessage());
		} finally {
			session.close();
		}
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Integer id) {
		T t = null;
		session = DBHelper.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			t = (T) session.get(clazz, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			log.error(e.getMessage());
		} finally {
			session.close();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByIds(Integer[] ids) {
		List<T> list = null;
		if (0 == ids.length) {
			return Collections.emptyList();
		} else {
			session = DBHelper.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				list = session
						.createQuery(
								"from " + clazz.getSimpleName()
										+ " where id in (:ids)")
						.setParameterList("ids", ids).list();
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				log.error(e.getMessage());
			} finally {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Integer getMaxId() {
		String hql = "select max(_id) from " + clazz.getSimpleName();
		Integer maxId = 0;
		session = DBHelper.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			maxId = (Integer) session.createQuery(hql).uniqueResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			log.error(e.getMessage());
		} finally {
			session.close();
		}
		return maxId;
	}

	@Override
	public boolean save(T entity) {
		boolean result = false;
		session = DBHelper.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(entity);
			tx.commit();
			result = true;
		} catch (Exception e) {
			tx.rollback();
			log.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean delete(Integer id) {
		boolean result = true;
		Object obj = getById(id);
		// 存在才去删除(查询出来的)
		if (null != obj) {
			session = DBHelper.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				session.delete(obj);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				log.error(e.getMessage());
				result = false;
			} finally {
				session.close();
			}
		}
		return result;
	}

	@Override
	public boolean update(T entity) {
		boolean result = false;
		session = DBHelper.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(entity);
			tx.commit();
			result = true;
		} catch (Exception e) {
			tx.rollback();
			log.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
