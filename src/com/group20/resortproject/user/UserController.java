package com.group20.resortproject.user;

import com.group20.resortproject.utility.Tuple;

public class UserController {
    
    private static User loggedInUser = null;

    /**
     * @return the currently logged in User
     * @see User
     */
    public static User getLoggedIn() {
        return loggedInUser;
    }

    /**
     * Given the email and password of a user, attempt to log them in
     * @param email
     * @param password
     * @return true if login successful, otherwise false
     */
    public static boolean login(String email, String password) {
        // Find a user's credentials
        Tuple<Integer, String> userData = UserModel.findLogin(email);

        int userID = userData.first.intValue();
        String dbPassword = userData.second;

        // Compare the password
        if(password.equals(dbPassword)) {
            loggedInUser = UserModel.findUser(userID);
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public static void logout() {
        loggedInUser = null;
    }

}
