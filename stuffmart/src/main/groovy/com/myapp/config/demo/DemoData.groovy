package com.myapp.config.demo

import com.myapp.dao.GenericDao
import com.myapp.model.Product
import com.myapp.model.Authority
import com.myapp.model.User

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired

import javax.annotation.PostConstruct

class DemoData {


    final Logger log = Logger.getLogger(this.class)

    final static String IPSUM = """Bacon ipsum dolor amet meatball biltong ground round alcatra short ribs chicken pancetta brisket. Leberkas meatball beef drumstick ribeye. Pork pancetta meatloaf brisket picanha sausage, pork belly venison. Andouille tongue pork belly, cow short ribs filet mignon t-bone chuck bacon hamburger corned beef spare ribs turkey turducken. Brisket tri-tip andouille ham hock venison, kevin ball tip picanha. Pork loin alcatra ball tip tail.\n\n
                            Frankfurter sausage cow, porchetta pig strip steak alcatra pork sirloin doner hamburger cupim andouille beef ribs kevin. Ham hock beef ribs corned beef, turducken shank capicola alcatra prosciutto kevin ball tip strip steak andouille picanha biltong brisket. Shank pork chop capicola ribeye turkey, meatball ham prosciutto. Ribeye turkey bacon flank t-bone beef ribs ground round porchetta shankle short loin rump short ribs cow."""

    @Autowired
    GenericDao dao

    @PostConstruct
    void afterLoad() {

        log.debug("loading data: start")

        List items = [
                new Product(name: 'Tiffany Clock', description: IPSUM, price: 99.00, imageName: 'clock.jpg'),
                new Product(name: 'Self-Driving Car', description: IPSUM, price: 29000.00, imageName: 'car.jpg'),
                new Product(name: 'Big Gulp', description: IPSUM, price: 19.00, imageName: 'wine.jpg'),
                new Product(name: 'Gift Certificate', description: IPSUM, price: 2.00 ),
                new Product(name: 'Cup of Coffee', description: IPSUM, price: 19.00 ),
                new Product(name: 'Steak Knives', description: IPSUM, price: 6.00 )
        ]

        dao.save(items)

        User admin = new User(firstName: 'admin', lastName: 'admin', email: 'admin', username: 'admin', password: User.hash('admin'))
        admin.addAuthority(Authority.ADMIN)

        User customer = new User(firstName: 'Bob', lastName: 'Smith', email: 'customer', username: 'customer', password: User.hash('customer'))
        customer.addAuthority(Authority.CUSTOMER)

        dao.save([admin, customer])

        log.debug("loading data: complete")

    }


}
