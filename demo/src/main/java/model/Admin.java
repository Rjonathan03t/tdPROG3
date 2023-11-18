package model;

import lombok.*;


@Getter
@Setter
@ToString

public class Admin extends User{
    private String email;
    public Admin(int is_author, String name, String gender,String email) {
        super(is_author, name, gender);
        this.email = email;
    }
}
