package model;

import lombok.*;

@Setter
@Getter
@ToString
public class Visitor extends User{
    public Visitor(int is_author, String name, String gender) {
        super(is_author, name, gender);
    }
}
