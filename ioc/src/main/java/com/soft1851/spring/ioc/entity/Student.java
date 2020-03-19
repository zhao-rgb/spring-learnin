package com.soft1851.spring.ioc.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Student
 * @Description TODO
 * @Author
 * @Date 2020/3/12
 **/
public class Student {
  private  Integer id;
  private  String  name;
  private List<String> hobbies;
  private Set<Phone> phones;
  private Map<Phone,String> phoneHeight;

    public Student() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Map<Phone, String> getPhoneHeight() {
        return phoneHeight;
    }

    public void setPhoneHeight(Map<Phone, String> phoneHeight) {
        this.phoneHeight = phoneHeight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", phones=" + phones +
                ", phoneHeight=" + phoneHeight +
                '}';
    }
}