package model;

import lombok.*;


@Getter
@Setter
@ToString

public class Admin extends User{
    private String email;
    public Admin(int id_user, String name,String email) {
        super(id_user, name);
        this.email = email;
    }
}
