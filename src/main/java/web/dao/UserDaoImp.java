package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {
        TypedQuery<User> typedQuery = em.createQuery("from User", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void update(User updatedUser) {
        em.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        em.remove(get(id));
    }

    @Override
    public User loadUserByUsername(String username) {
        return em.createQuery("FROM User user WHERE user.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public List<Role> getAllRoles() {
        TypedQuery<Role> typedQuery = em.createQuery("from Role", Role.class);
        return typedQuery.getResultList();
    }

    @Override
    public Role findRoleByName(String role) {
        return em.createQuery("FROM Role role WHERE role.role = :role", Role.class)
                .setParameter("role", role).getSingleResult();
    }

    @Override
    public Set<Role> getSetRole(String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String r : roles) {
            roleSet.add(findRoleByName(r));
        }
        return roleSet;
    }
}