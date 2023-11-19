package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    private int id_book;
    private String title;
    private Topic topic;
    private int id_author;


}
