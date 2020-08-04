package com.codeup.springblog.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "dogs", uniqueConstraints = {@UniqueConstraint(columnNames = { "name", "resideState"})})
public class Dog {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false, unique = true, columnDefinition = "TINYINT(3) UNSIGNED")
    private int age;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(columnDefinition = "CHAR(2)")
    @ColumnDefault("'XX'")
    private String resideState;

    public Dog() {}

    public Dog(int age, String name, String resideState) {
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public Dog(long id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }

}
