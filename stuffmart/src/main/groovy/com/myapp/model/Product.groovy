package com.myapp.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Lob
import javax.validation.constraints.NotNull
import java.beans.Transient

@Entity
class Product extends EntityImpl {

    @NotNull(message = "Name is required")
    String name

    @NotNull(message = "Price is required")
    Float price

    @Lob
    @Column(name="description", length=1024)
    String description

    String imageName

    @Transient
    String getImagePath() {
        imageName ? "/image/${imageName}" : "/image/placeholder.jpg"
    }

    @Transient
    String getSummary() {
        description?.size() > 100 ? description.substring(0, 100) : description
    }


}
