package ua.com.javarush.gnew.repository;

import ua.com.javarush.gnew.model.User;

import java.util.ArrayList;

public class UserRepository {
    private static UserRepository INSTANCE;

    private ArrayList<User> users = new ArrayList<>(){{
        add(new User(0, "User0", "user0@gmail.com"));
        add(new User(1, "User1", "user1@gmail.com"));
        add(new User(2, "User2", "user2@gmail.com"));
    }};


    private UserRepository(){
        
    }

    public static UserRepository getInstance() {
        if (INSTANCE == null){
            INSTANCE = new UserRepository();
        }

        return INSTANCE;

    }


    public ArrayList<User> getAll(){
        return users;
    }

    public void add(User user){
        users.add(user);
    }

}
