package com.wx.iadmin.entity;

import java.io.Serializable;
import java.util.Objects;

public class AccountDto implements Serializable {
    private final Long id;
    private final String code;
    private final String name;
    private final String password;
    private final Character root;

    public AccountDto(Long id, String code, String name, String password, Character root) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.password = password;
        this.root = root;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Character getRoot() {
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto entity = (AccountDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.code, entity.code) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.root, entity.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, password, root);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "code = " + code + ", " +
                "name = " + name + ", " +
                "password = " + password + ", " +
                "root = " + root + ")";
    }
}
