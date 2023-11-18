package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class User {
    private int is_author;
    private String name;
    private String gender;
}
