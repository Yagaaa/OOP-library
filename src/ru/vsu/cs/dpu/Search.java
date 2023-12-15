package ru.vsu.cs.dpu;

import java.util.ArrayList;
import java.util.Objects;

public class Search {
    public ArrayList<int[]> FindBookPath(Library library, String author, String title, int pages, int year, int searchFilter,
                                         int[] path, int pathLength) {
        Book tempBook;
        ArrayList<int[]> paths = new ArrayList<>();
        ArrayList<Room> rooms = library.library;

        switch (pathLength) {
            case 0:
                for (int j = 0; j < rooms.size(); j++) {
                    for (int x = 0; x < rooms.get(j).room.size(); x++) {
                        for (int y = 0; y < rooms.get(j).room.get(x).numShelves; y++) {
                            for (int z = 0; z < rooms.get(j).room.get(x).numBooks[y]; z++) {
                                tempBook = rooms.get(j).room.get(x).getBook(y, z);
                                paths.add(CheckFilters(j, x, y, z, searchFilter, title, author, year, pages, tempBook));
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int x = 0; x < rooms.get(path[0]).room.size(); x++) {
                    for (int y = 0; y < rooms.get(path[0]).room.get(x).numShelves; y++) {
                        for (int z = 0; z < rooms.get(path[0]).room.get(x).numBooks[y]; z++) {
                            tempBook = rooms.get(path[0]).room.get(x).getBook(y, z);
                            paths.add(CheckFilters(path[0],x,y,z,searchFilter,title,author,year,pages,tempBook));
                        }
                    }
                }
                break;
            case 2:
                for (int y = 0; y < rooms.get(path[0]).room.get(path[1]).numShelves; y++) {
                    for (int z = 0; z < rooms.get(path[0]).room.get(path[1]).numBooks[y]; z++) {
                        tempBook = rooms.get(path[0]).room.get(path[1]).getBook(y, z);
                        paths.add(CheckFilters(path[0],path[1],y,z,searchFilter,title,author,year,pages,tempBook));
                    }
                }
                break;
            case 3:
                for (int z = 0; z < rooms.get(path[0]).room.get(path[1]).numBooks[path[2]]; z++) {
                    tempBook = rooms.get(path[0]).room.get(path[1]).getBook(path[2], z);
                    paths.add(CheckFilters(path[0],path[1],path[2],z,searchFilter,title,author,year,pages,tempBook));
                }
                break;
        }
        return paths;
    }

    public int[] CheckFilters(int j, int x, int y, int z, int searchFilter, String title, String author, int year,
                              int pages, Book tempBook) {
        int[] tempArr = {};
        switch (searchFilter) {
            case 1:
                if (Objects.equals(tempBook.getTitle(), title)) {
                    tempArr = new int[]{j, x, y, z};
                }
            case 2:
                if (Objects.equals(tempBook.getAuthor(), author)) {
                    tempArr = new int[]{j, x, y, z};
                }
            case 3:
                if (tempBook.getYearPublishedIn() == year) {
                    tempArr = new int[]{j, x, y, z};
                }
            case 4:
                if (tempBook.getPages() == pages) {
                    tempArr = new int[]{j, x, y, z};
                }
        }
        return tempArr;
    }
}
