/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.hibernateSample.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Mariusz
 * @param <T>
 * @param <PK>
 */
public abstract class GenericExtendedDao<T, PK extends Serializable> {
    private static final Logger logger = LoggerFactory.getLogger(GenericExtendedDao.class);
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public GenericExtendedDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }
    
    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
    
    protected void getCloseSession() {
         HibernateUtil.getSessionFactory().close();
    }

    protected Class<T> getType() {
        return this.type;
    }

    protected String getClassName() {
        return type.getName();
    }



    public void flushSession() {
        getSession().flush();
        logger.info("flush");
    }

    public void clearSession() {
        getSession().clear();
        logger.info("clear");
    }

    public void refresh(T entity) {
        getSession().refresh(entity);
        logger.info("refresh");
    }

    public void add(T entity) {
        getSession().save(entity);
        logger.info("save " + entity.getClass().getSimpleName());
    }

    public void merge(T entity) {
        getSession().merge(entity);
        logger.info("merge " + entity.getClass().getSimpleName());
    }

    public void delete(T entity) {
        getSession().delete(entity);
        logger.info("delete " + entity.getClass().getSimpleName());
    }
    
    public void delete(PK id) {
		T entityToDelete = get(id);
        if(entityToDelete != null){
            delete(entityToDelete);
        }
    }

    public void update(T entity) {
    	getSession().flush();
        getSession().update(entity);
        logger.info("update " + entity.getClass().getSimpleName());
    }

    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
        logger.info("saveOrUpdate " + entity.getClass().getSimpleName());
    }
    
    @SuppressWarnings("unchecked")
    public T get(PK id) {
        return (T) getSession().load(type, id);
    }

    @Deprecated
    public T findById(PK id) {
        T found = type.cast(getSession().byId(type));
        return found;
    }

    @SuppressWarnings("unchecked")
    public List<T> findByQuery(String namedQuery) {
        logger.info("Find by query: " + namedQuery);
        return getSession().getNamedQuery(namedQuery).list();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByQuery(String namedQuery, Integer number) {
        logger.info("Find by query: " + namedQuery + ", id = " + number);
		return getSession().getNamedQuery(namedQuery).setInteger("id", number).list();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByQuery(String namedQuery, String paramName, String paramValue) {
        logger.info("Find by query: " + namedQuery + ", where + " + paramName + " = " + paramValue);
		return getSession().getNamedQuery(namedQuery).setString(paramName, paramValue).list();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        logger.info("Find all by criteria");
        return getSession().createCriteria(type).list();
    }
    
    public Long count() {
        logger.info("count");
        Long count = (Long) getSession().createCriteria(type)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        if(count == null) {
            return 0L;
        }
        else {
            return count;
        }
    }
    
    public Integer generateId() {
    	return count().intValue() + 1;
    }
}
