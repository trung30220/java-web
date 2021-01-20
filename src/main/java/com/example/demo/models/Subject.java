package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@Data
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) &&
                Objects.equals(name, subject.name) &&
                Objects.equals(oldUserSet, subject.oldUserSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, oldUserSet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OldUser> getUserSet() {
        return oldUserSet;
    }

    public void setUserSet(Set<OldUser> oldUserSet) {
        this.oldUserSet = oldUserSet;
    }

    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_subject",
            joinColumns = { @JoinColumn(name = "subject_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    Set<OldUser> oldUserSet = new HashSet<>();
}
