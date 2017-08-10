package com.ambition.domain;

import java.util.List;

/**
 * Created by roc_peng on 2017/8/9.
 * Email 18817353729@163.com
 * Url https://github.com/RocPeng/
 * Description 这个世界每天都有太多遗憾,所以你好,再见!
 */

public class UserModel {
    private List<User> users;

    public UserModel(List<User> users) {
        this.users = users;
    }

    public UserModel() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "users=" + users +
                '}';
    }
}
