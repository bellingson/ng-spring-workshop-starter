package com.myapp.controllers

import com.myapp.dao.GenericDao
import com.myapp.model.Product
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import java.security.Principal


@Controller
class ProductViewController {

    final Logger log = Logger.getLogger(this.class)

    @Autowired
    GenericDao dao

    @RequestMapping("/")
    String home() {
        'redirect:/products'
    }

    @RequestMapping(value="/products", method = RequestMethod.GET)
    void products(Model model, Principal principal) {

        log.debug("PR: ${principal}")

        model.products = dao.query('from Product p')

    }

    @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
    String product(Model model, @PathVariable('id') Long id) {

        model.product = dao.find(Product.class, id)

        'product_view'
    }




}
