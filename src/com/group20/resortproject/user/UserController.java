package com.group20.resortproject.user;

import java.time.LocalDate;

import com.group20.resortproject.lifts.LiftPassModel;
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
     * 
     * @param email
     * @param password
     * @return true if login successful, otherwise false
     */
    public static boolean login(String email, String password) {
        // Find a user's credentials
        Tuple<Integer, String> userData = UserModel.findLogin(email);

        if (userData == null) {
            return false;
        }

        int userID = userData.first.intValue();
        String dbPassword = userData.second;

        // Compare the password
        if (password.equals(dbPassword)) {
            loggedInUser = UserModel.findUser(userID);
            updateLiftPasses();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return {@code true} if a user is loggedin or {@code false} otherwise
     */
    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }

    /**
     * Logs out the current user
     */
    public static void logout() {
        loggedInUser = null;
    }

    /**
     * adds a user
     * 
     * @param firstName
     * @param lastName
     * @param dob
     * @param email
     * @param phone
     * @param password
     */
    public static void addUser(String firstName, String lastName, LocalDate dob, String email, String phone,
            String password) {
        UserModel.insertUser(firstName, lastName, dob, email, phone, password);
    }

    /**
     * updates the information on the programe and in the database
     * 
     * @param amount
     * @throws Exception
     */
    public static void addCredit(float amount) throws Exception {
        try {

            loggedInUser.addCredit(amount);
            UserModel.updateUser(loggedInUser);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 
     * @return amount of valid lift passes the current user has
     */
    public static int updateLiftPasses() {
        loggedInUser.setLiftPasses(LiftPassModel.getLiftPassesForUser(loggedInUser.getID()));
        return loggedInUser.getLiftPasses().size();
    }

}
