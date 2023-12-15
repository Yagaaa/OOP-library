package ru.vsu.cs.dpu.fileUtils;

import ru.vsu.cs.dpu.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static ArrayList<Book> readListOfBooks(String filePath) throws FileNotFoundException {
        FileReader fr = new FileReader(filePath);
        Scanner scanner = new Scanner(fr);

        String[] tempBookArr = new String[4];
        ArrayList<Book> books = new ArrayList<Book>();

        String primaryString;

        //Проходит все строки в файле и добавляет книжки
        while (scanner.hasNextLine()) {
            primaryString = scanner.nextLine();
            int i = 0;
            for (String elem : primaryString.split(";")) {
                try {
                    tempBookArr[i] = elem;
                    i++;
                } catch (Exception ignored) {
                }
            }
            books.add(new Book(tempBookArr[0], tempBookArr[1],
                    Integer.valueOf(tempBookArr[2]), Integer.valueOf(tempBookArr[3])));
        }
        return books;
    }

    public static void writeBooksIntoFile(ArrayList<Book> books, String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);

        String finalString;
        for (Book elem : books) {
            finalString = elem.getTitle() + ";" + elem.getAuthor() + ";" +
                    elem.getPages() + ";" + elem.getYearPublishedIn() + System.getProperty("line.separator");
            fw.write(finalString);
        }
        fw.close();
    }

    public static Library readLibrary(String filePath) throws FileNotFoundException {
        FileReader fr = new FileReader(filePath);
        Scanner scanner = new Scanner(fr);

        int numOfRooms = 0;
        ArrayList<Integer> numOfBookCases = new ArrayList<>();
        ArrayList<Integer> numOfShelves = new ArrayList<>();
        ArrayList<Integer> shelvesCapacity = new ArrayList<>();

        String primaryString;

        //Проходит все строки в файле и добавляет значения
        while (scanner.hasNextLine()) {
            numOfRooms = Integer.valueOf(scanner.nextLine());
            System.out.println(numOfRooms);
            primaryString = scanner.nextLine();
            for (String elem : primaryString.split(";")) {
                try {
                    numOfBookCases.add(Integer.valueOf(elem));
                } catch (Exception ignored) {
                }
            }
            primaryString = scanner.nextLine();
            for (String elem : primaryString.split(";")) {
                try {
                    numOfShelves.add(Integer.valueOf(elem));
                } catch (Exception ignored) {
                }
            }
            primaryString = scanner.nextLine();
            for (String elem : primaryString.split(";")) {
                try {
                    shelvesCapacity.add(Integer.valueOf(elem));
                } catch (Exception ignored) {
                }
            }
        }
        Library library = new Library();
        for (int i = 0; i < numOfRooms; i++) {
            library.addRoom();
            for (int j = 0; j < numOfBookCases.get(i); j++) {
                library.library.get(i).addBookCase(numOfShelves.get(i + j), shelvesCapacity.get(i + j));
            }
        }
        return library;
    }
}
