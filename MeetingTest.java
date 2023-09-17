package edu.sc.cse4495.MeetingPlanner;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MeetingTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    // Check for valid toString Function
    @Test
    public void testToString_valid(){
       Room room=new Room("2A01");
       Person person=new Person("Greg Gay");
       ArrayList<Person> people=new ArrayList<>();
       people.add(person);

       Meeting meeting=new Meeting(10,1,10,11, people ,room, "test meeting");

       String expectedMeetingString="10/1, 10 - 11,2A01: test meeting\nAttending: Greg Gay";
       Assert.assertTrue(expectedMeetingString.equals(meeting.toString()));
    }

    // bug found : attendees should not be null
    @Test
    public void testAddAttendee_valid(){
        Person person=new Person("Greg Gay");
        Meeting meeting=new Meeting(10,1,10,11);

        try {
            meeting.addAttendee(person);
        }
        catch (Exception e){
            Assert.fail("Exception thrown : "+e.getMessage());
        }
    }

    // check for valid Remove Attendee
    @Test
    public void testRemoveAttendee_valid(){
        Room room=new Room("2A01");
        Person person=new Person("Greg Gay");
        ArrayList<Person> people=new ArrayList<>();
        people.add(person);

        Meeting meeting=new Meeting(10,1,10,11, people ,room, "test meeting");

        try {
            meeting.removeAttendee(person);
        }
        catch (Exception e){
            Assert.fail("Exception thrown : "+e.getMessage());
        }

        Assert.assertFalse(meeting.getAttendees().contains(person));
    }

}
