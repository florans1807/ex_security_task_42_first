package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserServiceIn, UserDetailsService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User updatedUser) {
        userDao.update(updatedUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User loadUserByUsername(String login) {
        return userDao.loadUserByUsername(login);
    }

    @Override
    public List<Role> getAllRoles() {
        return userDao.getAllRoles();
    }

    @Override
    public Role findRoleByName(String role) {
        return userDao.findRoleByName(role);
    }

    @Override
    public Set<Role> getSetRole(String[] roles) {
        return userDao.getSetRole(roles);
    }


}