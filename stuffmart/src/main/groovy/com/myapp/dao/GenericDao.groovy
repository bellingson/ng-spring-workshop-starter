package com.myapp.dao

import com.myapp.model.EntityImpl

interface GenericDao {

    void save(List<EntityImpl> entities)

    void save(EntityImpl entity)

    List<EntityImpl> query(String query)


    void merge(EntityImpl entity)

    EntityImpl find(String query, Map params)

    EntityImpl find(Class clazz, Long id)

    void remove(EntityImpl entity)

    void remove(Collection<EntityImpl> items)

    void remove(Class clazz, Long id)

    void doWithTryCatch(Closure c)

    void flush()

}
