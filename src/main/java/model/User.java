package model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;

    @Column(name = "birth_date")
    private Date birthdayDate;

    public User() {
    }

    public User(String name, Date birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

}

