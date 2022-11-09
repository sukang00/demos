package com.example.service;

import com.example.entity.User;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/10/28 13:51
 */
@ApplicationScoped
public class UserService {

    @Inject
    EntityManager entityManager;

    private static final Logger LOG = Logger.getLogger(UserService.class);
    @ConfigProperty(name = "greeting.message")
    String message;
    public List<User> get() {
        LOG.info("测试日志打印："+message);
        return entityManager.createNamedQuery("User.findAll", User.class)
                .getResultList();
    }
    public User getSingle(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void create(User user) {
        entityManager.persist(user);
    }
    @Transactional(rollbackOn = Exception.class)
    public void create2(@Valid User user) {
        entityManager.persist(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void update(Integer id, User user) {
        User entity = entityManager.find(User.class, id);

        if (null!=entity) {
            entity.setUserName(user.getUserName());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public void delete(Integer id) {
        User entity = entityManager.getReference(User.class, id);

        if (null!=entity) {
            entityManager.remove(entity);
        }
    }
}
