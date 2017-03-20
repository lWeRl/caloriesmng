package org.lwerl.caloriesmng.web.interceptor;

import org.lwerl.caloriesmng.LoggedUser;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lWeRl on 20.03.2017.
 */
public class ModelInterseptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView!=null && !modelAndView.isEmpty() && modelAndView.getModelMap().get("userTo")==null){
            if (LoggedUser.safeGet()!=null) modelAndView.getModelMap().addAttribute("userTo", LoggedUser.get().getUser());
        }
    }
}
