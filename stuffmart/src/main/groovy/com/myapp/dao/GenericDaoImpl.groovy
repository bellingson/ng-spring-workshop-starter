package com.myapp.dao

import com.myapp.model.EntityImpl

import org.apache.log4j.Logger

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional


import javax.persistence.EntityManager
import javax.persistence.NoResultException
import javax.persistence.PersistenceContext
import javax.persistence.PersistenceContextType
import javax.persistence.Query

@Repository("genericDao")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
class GenericDaoImpl implements GenericDao {

    final Logger log = Logger.getLogger(this.class)

    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em


    void persist(Closure c) {

    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
    List<EntityImpl> query(String query) {

        Query q = em.createQuery(query)
        q.getResultList()
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
    EntityImpl find(String query, Map params) {

        try {
            Query q = em.createQuery(query)
            for(Map.Entry e : params.entrySet()) {
                q.setParameter(e.key,e.value)
            }
            return q.getSingleResult()
        } catch(NoResultException ne) {
            return null
        }
    }

    EntityImpl find(Class clazz, Long id) {
        em.find(clazz,id)
    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    void save(EntityImpl entity) {

        em.persist(entity)

    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    void save(List<EntityImpl> entities) {

        entities.each { entity ->
            em.persist(entity)
        }

    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    void merge(EntityImpl entity) {

        doWithTryCatch {

//            log.debug("EM OPEN: ${em.isOpen()}")

            //em.merge(entity)
            em.merge(entity)

            //em.flush()

            log.debug("saved entity: ${entity.id}")

        }
    }

    void doWithTryCatch(Closure c) {

        try {
            c()
        } catch (Throwable t) {
            log.error("DAO ERROR: ${t.message}",t)
        }

    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    void flush() {

        doWithTryCatch {
            em.flush()
        }

    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    void remove(EntityImpl entity) {
       em.remove(entity)
    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    void remove(Collection<EntityImpl> items) {

        items.each { em.remove(it) }

    }

    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    void remove(Class clazz, Long id) {

        EntityImpl entity = find(clazz, id)
        if(entity == null)
            throw new Exception("Item does not exist")

        em.remove(entity)

    }



}
