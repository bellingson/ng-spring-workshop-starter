package com.myapp.model

import org.apache.log4j.Logger
import org.hibernate.annotations.Formula
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

//import org.springframework.security.authentication.encoding.ShaPasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


import javax.persistence.*

import javax.validation.constraints.NotNull

/*
*    http://docs.spring.io/spring-security/site/docs/3.2.3.RELEASE/reference/htmlsingle/#user-schema
*/

@Entity
@Table(name="users")
class User extends EntityImpl implements UserDetails {

    @Transient
    final Logger log = Logger.getLogger(this.class)

    @NotNull(message = "First name is required")
    String firstName

    @NotNull(message = "Last name is required")
    String lastName

    @Formula("concat(concat(firstName,' '),lastName)")
    String name

    @NotNull(message = "Email is required")
    @Column(unique=true)
    String email

    @NotNull(message = "User name is required")
    @Column(unique = true)
    String username

    String password

    @OneToMany(mappedBy = 'user', cascade = [CascadeType.ALL])
    Set<Authority> roles

    Authority addAuthority(String authority) {

        log.debug('add 1')

        if(roles == null)
            roles = []

        log.debug('add 2')

        Authority role = roles.find { r -> r.authority == authority }
        if(role) {
            return role
        }

        log.debug('add 3')

        role = new Authority(user: this, authority: authority )

        roles << role

        log.debug('add 4: ' + this.roles)

        return role
    }

    Boolean hasAuthority(String authority) {
        Authority role = roles.find { r -> r.authority == authority }
        if(role) {
            return true
        }

        return false
    }

    Boolean getIsAdmin() {
        hasAuthority(Authority.ADMIN)
    }

    static String hash(String string) {
//        return new ShaPasswordEncoder().encodePassword(string,null)
        new BCryptPasswordEncoder().encode(string)
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
    }

    @Override
    boolean isAccountNonExpired() {
        return true
    }

    @Override
    boolean isAccountNonLocked() {
        return true
    }

    @Override
    boolean isCredentialsNonExpired() {
        return true
    }

    @Override
    boolean isEnabled() {
        return true
    }
}
