package com.zl.dto.domain;

import java.util.Objects;

public class Son {
    private String id;
    private String name;
    private Long age;
    private Farther fartherByParentId;

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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Son son = (Son) o;
        return Objects.equals(id, son.id) &&
                Objects.equals(name, son.name) &&
                Objects.equals(age, son.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public Farther getFartherByParentId() {
        return fartherByParentId;
    }

    public void setFartherByParentId(Farther fartherByParentId) {
        this.fartherByParentId = fartherByParentId;
    }
}
