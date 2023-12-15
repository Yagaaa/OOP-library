package ru.vsu.cs.dpu;

import java.util.ArrayList;

public class Library {
    public ArrayList<Room> library;

    public Library() {
        library = new ArrayList<>();
    }

    public Library(Room[] rooms) {
        library = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            library.add(rooms[i]);
        }
    }

    public void addRoom() {
            library.add(new Room());
    }

    public void removeRoom(int position) {
        library.remove(position);
    }
}
