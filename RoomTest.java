package edu.sc.cse4495.MeetingPlanner;
import org.junit.Assert;
import org.junit.Test;

public class RoomTest {
    // Add test methods here.
    // You are not required to write tests for all classes.

    // check ID of room
    @Test
    public void test_getID(){
        String id = "2A01";
        Room room = new Room(id);
        Assert.assertEquals(room.getID(), id);
    }

    // check if no ID provided
    @Test
    public void test_getID_invalid(){
        Room room = new Room();
        Assert.assertEquals(room.getID(), "");
    }

    // check valid addMeeting function
    @Test
    public void test_addMeeting(){
        Room room = new Room("2A01");
        try {
            room.addMeeting(new Meeting(10,24,11,13));
        } catch (TimeConflictException e) {
            Assert.fail("Meeting not Throwing Exception "+e.getMessage());
        }
    }

    // check addMeeting for invalid case
    @Test
    public void test_addMeeting_invalid(){
        Room room = new Room("2A01");
        try {
            room.addMeeting(new Meeting(12,24,11,13));
            //Assert.assertThrows(TimeConflictException.class, ()->room.addMeeting(new Meeting(10,24,11,13)));
        } catch (Exception e) {
            Assert.fail("Meeting will Throwing Exception "+e.getMessage());
        }
    }

    // check isBusy for valid case
    @Test
    public void test_isBusy(){
        Room room = new Room("2A01");
        try {
            room.addMeeting(new Meeting(10,24,11,13));
            Assert.assertTrue(room.isBusy(10,24,11,13));
        } catch (TimeConflictException e) {
            Assert.fail("isBusy not Throwing Exception "+e.getMessage());
        }
    }
}
