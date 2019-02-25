package com.example.gyc.libdemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Description:
 *
 * @author: gaoyucong
 * Date: 2019-02-22 上午 10:46
 */
@Entity
public class Student {
    @Id(autoincrement = true)
    private long id;
    private String name;
    private int age;
    private String gender;

    @Generated(hash = 881070470)
    public Student(long id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
