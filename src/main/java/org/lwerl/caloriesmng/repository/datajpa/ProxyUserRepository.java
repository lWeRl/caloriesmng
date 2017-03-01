package org.lwerl.caloriesmng.repository.datajpa;

import org.lwerl.caloriesmng.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lWeRl on 01.03.2017.
 */
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll(Sort sort);

    User findByEmail(String email);

    @Override
    @Transactional
    User save(User user);
}
