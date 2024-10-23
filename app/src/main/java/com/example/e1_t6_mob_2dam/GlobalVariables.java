package com.example.e1_t6_mob_2dam;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

import objects.User;

public class GlobalVariables {
    public static User logedUser = null;
    public static ArrayList<User> usersDB = new ArrayList<User>();
}
