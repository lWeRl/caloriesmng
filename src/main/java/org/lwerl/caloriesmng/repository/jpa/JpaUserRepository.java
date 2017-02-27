package org.lwerl.caloriesmng.repository.jpa;

import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.repository.UserRepository;
import org.lwerl.caloriesmng.util.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepository implements UserRepository {

    /*
    //Если работать без JPA напрямую с hibernate
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
    */

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User get(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User save(User user) throws NotFoundException {
        if (user.isNew()) entityManager.persist(user);
        else {
            entityManager.getReference(User.class, user.getId());
            entityManager.merge(user);
        }
        return user;
    }

    @Transactional
    @Override
    public boolean delete(int id) {
//        User ref = entityManager.getReference(User.class, id); //получаем проксированную сслыку
//        if (ref == null) return false;
//        entityManager.remove(ref);
//        return true;

//        TypedQuery<User> query = entityManager.createQuery("delete from User u where u.id=:id", User.class).setParameter("id", id);
//        return query.executeUpdate()!= 0;
        return entityManager.createNamedQuery(User.DELETE).setParameter("id", id).executeUpdate() != 0;
    }


    @Override
    public User getByEmail(String email) {
        return entityManager.createNamedQuery(User.BY_EMAIL, User.class).setParameter("email", email).getSingleResult();
    }


    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }
}
