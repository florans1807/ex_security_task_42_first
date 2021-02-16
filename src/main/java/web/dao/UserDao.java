package web.dao;

import web.model.Role;
import web.model.User;
import java.util.List;
import java.util.Set;

public interface UserDao {
    List<User> getAll();
    User get(int id);
    void add(User user);
    void update(User updatedUser);
    void delete(int id);
    User loadUserByUsername(String login);
    List<Role> getAllRoles();
    Role findRoleByName(String role);
    Set<Role> getSetRole(String[] roles);
}
