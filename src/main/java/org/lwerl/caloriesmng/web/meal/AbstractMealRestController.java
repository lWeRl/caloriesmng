package org.lwerl.caloriesmng.web.meal;

import org.lwerl.caloriesmng.LoggedUser;
import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.service.UserMealService;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.lwerl.caloriesmng.web.ExceptionInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

public class AbstractMealRestController  extends ExceptionInfoHandler implements MealRest {
    private static final LoggerWrapper LOG = LoggerWrapper.get(AbstractMealRestController.class);
    //не имеет перменных, то есть не имеет состояния - ThreadSafe

    @Autowired
    protected UserMealService service;

//    @Autowired
//    private AbstractMealRestController(UserMealService service) {
//        this.service = service;
//    }
//
//    //@Required
//    public void setService(UserMealService service) {
//        this.service = service;
//    }

    protected LoggedUser user;
    @Override
    public UserMeal get(int id) {

        LOG.info("get meal {} for User {}", id, LoggedUser.id());
        return service.get(id, LoggedUser.id());
    }

    @Override
    public void delete(int id) {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("delete meal {} for User {}", id, LoggedUser.id());
        service.delete(id, LoggedUser.id());
    }

    @Override
    public List<UserMeal> getAll() {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("get all meal for User {}", LoggedUser.id());
        return service.getAll(LoggedUser.id());
    }

    @Override
    public void deleteAll() {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("delete all meal for User {}", LoggedUser.id());
        service.deleteAll(LoggedUser.id());
    }

    @Override
    public void update(UserMeal meal, int id) {
        LOG.info("update meal {} for User {}", meal, LoggedUser.id());
        meal.setId(id);
        service.update(meal, LoggedUser.id());
    }

    @Override
    public UserMeal create(UserMeal meal) {
        int userId = LoggedUser.LOGGED_USER.getId();
        meal.setId(null);
        LOG.info("create meal {} for User {}", meal, LoggedUser.id());
        service.save(meal, LoggedUser.id());
        return meal;
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("get meal between {} and {} for User {}", startDate, endDate, LoggedUser.id());
        return service.getBetween(startDate, endDate, LoggedUser.id());
    }
}