package org.example;

import java.util.List;

public class Group {

    private final String id;
    private String name;
    private List<User> users;
    private List<Expense> expenses;

    public Group(String id, String name, List<User> users, List<Expense> expenses) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.expenses = expenses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
