package model;

import lombok.*;

@Setter
@Getter
@ToString
public class Visitor extends User{
    public Visitor(int id_user,String name, String gender) {
        super( id_user,name, gender);
    }
}
