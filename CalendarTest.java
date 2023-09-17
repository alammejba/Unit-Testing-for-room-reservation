package edu.sc.cse4495.MeetingPlanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

	// Add meeting valid
	@Test
	public void test_addMeeting(){
		Meeting meeting = new Meeting(10, 24, "Important Meeting");
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			calendar.addMeeting(meeting);
			// Verify that it was added.
			assertTrue(calendar.getMeeting(10,24,0).equals(meeting));
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}

	// Add meeting invalid
	@Test
	public void test_addMeeting_holiday() {
		// Create Midsommar holiday
		Meeting christmas = new Meeting(6, 26, "Midsommar");
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			calendar.addMeeting(christmas);
			// Verify that it was added.
			Boolean added = calendar.isBusy(6, 26, 0, 23);
			assertTrue("Midsommar should be marked as busy on the calendar",added);
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}

	// Check isBusy
	@Test
	public void testIsBusy(){
		Meeting meeting = new Meeting(10, 1, "Important Meeting");
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			calendar.addMeeting(meeting);
			// Verify that it was added.
			assertTrue(calendar.isBusy(10,1,11,12));
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}

	// Check isBusy invalid
	@Test
	public void test_isBusy_false(){
		Meeting meeting = new Meeting(10, 1, "Important Meeting");
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			assertFalse(calendar.isBusy(10,1,11,12));
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}

}
