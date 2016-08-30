package com.myapp.config.security

import com.myapp.model.User
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class UserRequestFilter implements Filter {




    @Override
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        setUserAttribute(request)

        chain.doFilter(request, response)

    }

    void setUserAttribute(HttpServletRequest req) {

        UsernamePasswordAuthenticationToken principal = (UsernamePasswordAuthenticationToken) req.userPrincipal
        if(principal == null) {
            return
        }

        User user = principal.principal

        req.setAttribute('user', user)
    }

    @Override
    void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    void destroy() { }
}
