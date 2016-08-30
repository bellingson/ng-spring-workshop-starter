package com.myapp.config.security


import com.myapp.model.User
import org.apache.log4j.Logger

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.PersistenceContextType

@Service
class MyUserDetailsService implements UserDetailsService {

    final Logger log = Logger.getLogger(this.class)

    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager entityManager


    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = entityManager.createQuery('from User u where u.username = :username')
                    .setParameter('username', username)
                    .getSingleResult()


        if(user == null)
            return null


        log.debug("UR: ${user.roles}")
        log.debug("PW: ${user.password}")


        return user
    }
}
