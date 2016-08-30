package com.myapp.controllers

import com.myapp.dao.GenericDao
import com.myapp.model.Product
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaSystemException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException

@RestController
@RequestMapping("/data/admin/product")
class ProductDataController {

    final Logger log = Logger.getLogger(this.class)

    final static Map OK_MESSAGE = [ message: 'ok' ]

    @Autowired
    GenericDao dao

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody List<Product> products() {
        dao.query('from Product p')
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    @ResponseBody Product product(@PathVariable('id') Long id) {
        dao.find(Product.class, id)
    }

    @RequestMapping(method = [ RequestMethod.POST ] )
    @ResponseBody Map save(@RequestBody Product product) {

        dao.save(product)

        OK_MESSAGE
    }

    @RequestMapping(value="{id}", method = [ RequestMethod.PUT] )
    @ResponseBody Map update(@PathVariable('id') Long id, @RequestBody Product product) {

        dao.merge(product)

        OK_MESSAGE
    }


    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    @ResponseBody Map delete(@PathVariable('id') Long id) {

        Product product = dao.find(Product.class, id)

        dao.remove(product)

        OK_MESSAGE
    }


    @ExceptionHandler(Throwable.class)
    ResponseEntity<String> handleException(HttpServletRequest request, Throwable t) {

        log.error('json controller exception: ' + t.class + ' : ' + request.requestURI,t)

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set('Content-Type', 'application/json; charset=UTF-8');
        String content = "{ \"error\" : \"${t.message}\" }" as java.lang.String
        return new ResponseEntity<String>(content, responseHeaders, HttpStatus.BAD_REQUEST)
    }



}
