package com.test.server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "stu", schema = "test", catalog = "")
public class StuEntity {
    private String name;
    private int id;
    private String sex;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 255)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuEntity stuEntity = (StuEntity) o;

        if (id != stuEntity.id) return false;
        if (name != null ? !name.equals(stuEntity.name) : stuEntity.name != null) return false;
        if (sex != null ? !sex.equals(stuEntity.sex) : stuEntity.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
