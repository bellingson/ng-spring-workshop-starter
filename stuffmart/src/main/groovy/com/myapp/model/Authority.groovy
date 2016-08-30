package com.myapp.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.springframework.security.core.GrantedAuthority

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull



@Entity
@Table(name="authorities")
class Authority extends EntityImpl implements GrantedAuthority {

    final static String ADMIN = 'ROLE_ADMIN'
    final static String CUSTOMER = 'ROLE_CUSTOMER'

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="userId", nullable=false, updatable=false)
    User user

    @NotNull(message = "Authority name is required")
    String authority

//    String toString() {
//        authority
//    }

}
