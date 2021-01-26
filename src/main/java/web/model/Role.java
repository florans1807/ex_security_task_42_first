package web.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

// Этот класс реализует интерфейс GrantedAuthority, в котором необходимо переопределить только один метод getAuthority() (возвращает имя роли).
// Имя роли должно соответствовать шаблону: «ROLE_ИМЯ», например, ROLE_USER.

@Entity
@Table(name="authorities")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String name;

    @Column(name = "authority")
    private String role;

    public Role() { }

    public Role(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

}
