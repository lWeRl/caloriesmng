package org.lwerl.caloriesmng.web.user;

import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.service.UserService;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.lwerl.caloriesmng.web.ExceptionInfoHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin/users")
public class AdminRestController extends ExceptionInfoHandler implements AdminRest {

    private static final LoggerWrapper LOG = LoggerWrapper.get(AdminRestController.class);

    @Resource
    private UserService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public User get(@PathVariable("id") int id) {
        LOG.info("get" + id);
        return service.get(id);
    }

    @Override
    @RequestMapping(value = "/by", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByEmail(@RequestParam("email") String email) {
        LOG.info("getByEmail: " + email);
        return service.getByEmail(email);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<User> create(@RequestBody User user) {
        LOG.info("create " + user);
        User created = service.save(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/admin/user/{id}")
                .buildAndExpand(created.getId()).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);
        return new ResponseEntity<>(created, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        LOG.info("update" + user);
        service.update(user);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        LOG.info("delete" + id);
        service.delete(id);
    }
}
