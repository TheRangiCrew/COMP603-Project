package com.group20.resortproject;

import com.group20.resortproject.cafe.CafeCategories;
import com.group20.resortproject.cafe.CafeModel;
import com.group20.resortproject.cafe.Item;
import com.group20.resortproject.equipment.EquipmentType;
import com.group20.resortproject.equipment.RentalEquipmentController;
import com.group20.resortproject.equipment.RentalItem;
import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.DBManager;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Test;

public class UserTest {
    
    public UserTest() {
        DBManager.establishConnection();
    }
    
    @Test
    public void testDBConnection() {
        try {
        Assert.assertEquals(false, DBManager.getConnection().isClosed());
        } catch (SQLException e) {
            fail();
        }
    }
    
    @Test
    public void testRegister() {
        String email = "test@test.com";
        Assert.assertEquals(true, UserController.addUser("Test", "Testing", LocalDate.EPOCH, email, "0201234567", "testing"));
    }
    
    /**
     * Tests the login functions but using different combinations of correct and incorrect login credentials
     */
    @Test
    public void testLogin() {
        String email = "test@test.com";
        String incorrectEmail = "wrong@email.com";
        String password = "testing";
        String incorrectPassword = "test";
        
        System.out.println("Test Login - Incorrect Email");
        Assert.assertEquals(false, UserController.login(incorrectEmail, password));
        System.out.println("Test Login - Incorrect Password");
        Assert.assertEquals(false, UserController.login(email, incorrectPassword));
        System.out.println("Test Login - Incorrect All");
        Assert.assertEquals(false, UserController.login(incorrectEmail, incorrectPassword));
        System.out.println("Test Login - All Correct");
        Assert.assertEquals(true, UserController.login(email, password));
    }
    
    @Test
    public void testCafeItems() {
        Assert.assertNotSame(new HashMap<CafeCategories, ArrayList<Item>>(), CafeModel.getItems());
    }
    
    @Test
    public void testRentalEquipment() {
        Assert.assertNotSame(new HashMap<EquipmentType, ArrayList<RentalItem>>(), RentalEquipmentController.getItems());
    }
}
