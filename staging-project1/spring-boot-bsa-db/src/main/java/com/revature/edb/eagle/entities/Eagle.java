package com.revature.edb.eagle.entities;

import javax.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Eagle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }


    public Eagle() { super();
    }

    public Eagle(String firstName) {
        this.firstName = firstName;
    }

    public Eagle(String firstName, String lastName, String email, Rank rank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rank = rank;
    }

    public Eagle(int id, String firstName, String lastName, String email, Rank rank) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eagle eagle = (Eagle) o;
        return id == eagle.id &&
                Objects.equals(firstName, eagle.firstName) &&
                Objects.equals(lastName, eagle.lastName) &&
                Objects.equals(email, eagle.email) &&
                rank == eagle.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, rank);
    }

    @Override
    public String toString() {
        return "Eagle{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", rank=" + rank +
                '}';
    }
}
