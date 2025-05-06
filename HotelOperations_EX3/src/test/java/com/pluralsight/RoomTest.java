package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void testCheckInWhenAvailable() {
        Room room = new Room(2, 100.0, false, false);
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckInWhenOccupied() {
        Room room = new Room(2, 100.0, true, false);
        room.checkIn();
        assertTrue(room.isOccupied());
        assertFalse(room.isDirty());
    }

    @Test
    public void testCheckInWhenDirty() {
        Room room = new Room(2, 100.0, false, true);
        room.checkIn();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckOut() {
        Room room = new Room(2, 100.0, true, false);
        room.checkOut();
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }

    @Test
    public void testCleanRoom() {
        Room room = new Room(2, 100.0, false, true);
        room.cleanRoom();
        assertFalse(room.isDirty());
    }
}