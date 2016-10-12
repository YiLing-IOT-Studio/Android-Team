package top.wuhaojie.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/10/12 21:33
 * Version: 1.0
 */
@Entity
@Setter
@Getter
public class User {

    @GeneratedValue
    @Id
    private int id;

    private String name;

    private String password;

    private int age;

    private String text;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof User) {
            User u = (User) obj;
            if (this.id == u.id
                    && this.name.equals(u.name)
                    && this.password.equals(u.password))
                return true;

        }
        return false;
    }
}
