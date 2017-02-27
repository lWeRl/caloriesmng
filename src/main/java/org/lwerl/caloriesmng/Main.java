package org.lwerl.caloriesmng;

import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.repository.UserRepository;
import org.lwerl.caloriesmng.repository.jpa.JpaUserRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        System.out.format("Hello Topjava Webinar!");
        ConfigurableApplicationContext cac = new ClassPathXmlApplicationContext("/spring/spring-app.xml" , "/spring/spring-db.xml");
        //System.out.println(Arrays.toString(cac.getBeanDefinitionNames()));
        UserRepository repository = cac.getBean(UserRepository.class);
        System.out.println(repository.get(100000).toString());
        User user = new User("name", "name", "name", Role.USER);
        System.out.println(user.toString());
        repository.save(user);
        //cac.close();
    }
}
