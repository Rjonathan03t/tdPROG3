package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Author {
    private int id_author;
    private String name;
    private String gender;

    public Author() {

    }
}
