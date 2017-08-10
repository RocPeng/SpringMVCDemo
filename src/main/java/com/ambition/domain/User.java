package com.ambition.domain;

import java.util.Arrays;

/**
 * Created by roc_peng on 2017/8/9.
 * Email 18817353729@163.com
 * Url https://github.com/RocPeng/
 * Description 这个世界每天都有太多遗憾,所以你好,再见!
 */

public class User{
    private String name;
    private Integer age;
    private boolean isMarry;
    private Double income;
    private String[] interests;

    public User(String name, Integer age, boolean isMarry, Double income, String[] interests) {
        this.name = name;
        this.age = age;
        this.isMarry = isMarry;
        this.income = income;
        this.interests = interests;
    }

    public User() {
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

    public boolean isMarry() {
        return isMarry;
    }

    public void setMarry(boolean marry) {
        isMarry = marry;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarry=" + isMarry +
                ", income=" + income +
                ", interests=" + Arrays.toString(interests) +
                '}';
    }
}
