package org.lwerl.caloriesmng.web.meal;

import org.lwerl.caloriesmng.LoggedUser;
import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.service.UserMealService;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.lwerl.caloriesmng.util.TimeUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lWeRl on 15.03.2017.
 */
@RestController
@RequestMapping(value = "/ajax/profile/meals/")
public class MealAjaxController {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MealAjaxController.class);
    @Resource
    private UserMealService service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserMeal get(@PathVariable("id") int id){
        LOG.info("get meal {} for User {}", id, LoggedUser.id());
        return service.get(id, LoggedUser.id());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserMeal> getAll(){
        LOG.info("get all meal for User {}", LoggedUser.id());
        return service.getAll(LoggedUser.id());
    }

    @RequestMapping(value = "/between", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserMeal> getBetween(
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate) {
        LOG.info("get meal between {} and {} for User {}", startDate, endDate, LoggedUser.id());
        return service.getBetween(TimeUtil.toDateTime(startDate.replaceAll("/","-")), TimeUtil.toDateTime(endDate.replaceAll("/","-")), LoggedUser.id());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        LOG.info("delete meal {} for User {}", id, LoggedUser.id());
        service.delete(id, LoggedUser.id());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public void create(@PathVariable("id") int id, @RequestParam("description") String description, @RequestParam String date, @RequestParam int calories){
        UserMeal meal = new UserMeal(description, TimeUtil.toDateTime(date.replaceAll("/","-")), calories);
        meal.setId(id);
        if(meal.getId()==0){
            meal.setId(null);
            meal = service.save(meal,LoggedUser.id());
            LOG.info("save meal {} for User {}", meal, LoggedUser.id());
        } else {
            service.update(meal, LoggedUser.id());
            LOG.info("update meal {} for User {}", meal, LoggedUser.id());
        }
    }
}
