package model;

import lombok.*;


@Getter
@Setter
@ToString

public class Subscriber extends User{
    private String password;
    public Subscriber(int is_author, String name, String gender,String password) {
        super(is_author, name, gender);
        this.password = password;
    }
}
