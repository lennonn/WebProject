package com.zl.dto.domain;

import java.util.Objects;

public class Farther {
    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farther farther = (Farther) o;
        return Objects.equals(id, farther.id) &&
                Objects.equals(name, farther.name) &&
                Objects.equals(age, farther.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
