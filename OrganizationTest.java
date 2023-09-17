package edu.sc.cse4495.MeetingPlanner;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class OrganizationTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    // valid getRoom Function
    @Test
    public void test_getRoom(){
        String room_no = "2A01";
        Organization o = new Organization();
        try {
            Assert.assertTrue(o.getRoom(room_no).getID().equals(room_no));
        } catch (Exception e) {
            Assert.fail("Function will not throw exception");
        }
    }

    // invalid getRoom Function
    @Test
    public void test_getRoom_invalid(){
        String room_no = "3A01";
        Organization o = new Organization();
        try {
            Assert.assertThrows(Exception.class, ()-> o.getRoom(room_no).getID().equals(room_no));
        } catch (Exception e) {
            Assert.fail("Function will throw exception "+e.getMessage());
        }
    }

    // valid getEmployee Function
    @Test
    public void test_getEmployee(){
        String name = "Greg Gay";
        Organization o = new Organization();
        ArrayList<Person> eee = new ArrayList<>();
        try {
            Assert.assertTrue(o.getEmployee(name).getName().equals(name));
        } catch (Exception e) {
            Assert.fail("Function will not throw exception");
        }
    }

    // invalid getEmployee Function
    @Test
    public void test_getEmployee_invalid(){
        String name = "Ishtiak";
        Organization o = new Organization();
        ArrayList<Person> eee = new ArrayList<>();
        try {
            Assert.assertThrows(Exception.class, ()-> o.getEmployee(name).getName().equals(name));
        } catch (Exception e) {
            Assert.fail("Function will throw exception "+e.getMessage());
        }
    }
}
