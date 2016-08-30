package com.myapp.model

import javax.persistence.*

@MappedSuperclass
class EntityImpl {

    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

}
