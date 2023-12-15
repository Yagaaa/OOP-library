package ru.vsu.cs.dpu;

import java.util.ArrayList;

public class Room {
    ArrayList<BookCase> room;

    public Room() {
        room = new ArrayList<>();
    }

    public Room(BookCase[] bookCases) {
        room = new ArrayList<>();
        for (int i = 0; i < bookCases.length; i++) {
            room.add(bookCases[i]);
        }
    }

    public void addBookCase(int numShelves, int shelfCapacity) {
            room.add(new BookCase(numShelves, shelfCapacity));
    }

    public void removeBookCase(int position) {
        room.remove(position);
    }

    public void clearRoom() {
        room.clear();
    }
}
