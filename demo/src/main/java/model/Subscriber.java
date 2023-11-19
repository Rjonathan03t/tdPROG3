package model;

import lombok.*;


@Getter
@Setter
@ToString

public class Subscriber extends User{
    private String password;
    public Subscriber(int id_user,String name, String password) {
        super(id_user,name);
        this.password = password;
    }
}
