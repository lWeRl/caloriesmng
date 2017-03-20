package org.lwerl.caloriesmng.web;

import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private static final LoggerWrapper LOG = LoggerWrapper.get(GlobalControllerExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOG.error("Exception at request " + req.getRequestURL(), e);
        ModelAndView mav = new ModelAndView("exception/exception");
        mav.addObject("exception", e);
        return mav;
    }
}
