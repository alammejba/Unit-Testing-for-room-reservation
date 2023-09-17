package edu.sc.cse4495.MeetingPlanner;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    // Add test methods here.
    // You are not required to write tests for all classes.

    // check getName function providing a name
    @Test
    public void test_getName(){
        String name = "ishtiak";
        Person person = new Person(name);
        Assert.assertEquals(person.getName(), name);
    }

    // check getName function while name empty
    @Test
    public void testGetName_empty(){
        Person person = new Person();
        Assert.assertEquals(person.getName(), "");
    }

    // check addMeeting valid
    @Test
    public void test_addMeeting(){
        Person person = new Person();
        try {
            person.addMeeting(new Meeting(10, 24, 11, 13));
        } catch (TimeConflictException e) {
            Assert.fail("Function will not throw exception "+e.getMessage());
        }
    }

    // check addMeeting throws exception
    @Test
    public void test_addMeeting_invalid(){

        Person person = new Person("Greg Gay");
       // Person person = new Person();
        try {
            person.addMeeting(new Meeting(10, 24, 11, 13));
            Assert.assertThrows(TimeConflictException.class,
                    ()->person.addMeeting(new Meeting(10, 24, 11, 13)));
        } catch (Exception e) {
            Assert.fail("Throws exception "+e.getMessage());
        }
    }

    // check isBusy function
    @Test
    public void test_IsBusy(){
        Person person = new Person();
        try {
            Assert.assertThrows(TimeConflictException.class, ()->person.addMeeting(new Meeting(12, 24, 11, 13)));

        } catch (Exception e) {
            Assert.fail("Throw exception "+ e.getMessage());
        }
    }

    // check removeMeeting function
    @Test
    public void test_removeMeeting(){
        Person person = new Person();
        try {
            person.addMeeting(new Meeting(10, 24, 11, 13));
            person.removeMeeting(10, 24, 0);
            Assert.assertFalse(person.isBusy(10,24,11,13));
        } catch (TimeConflictException e) {
            Assert.fail("Throwing exception"+e.getMessage());
        }
    }

    // check removeMeeting function if no meeting exists
    @Test
    public void test_removeMeeting_noMeeting_exists(){
        Person person = new Person();
        try {
            Assert.assertThrows(IndexOutOfBoundsException.class,()->person.removeMeeting(10, 24, 0));
        } catch (Exception e) {
            Assert.fail("Not failing gracefully "+e.getMessage());
        }
    }
}
