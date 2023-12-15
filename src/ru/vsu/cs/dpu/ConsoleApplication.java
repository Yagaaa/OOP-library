package ru.vsu.cs.dpu;

import ru.vsu.cs.dpu.fileUtils.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class ConsoleApplication {
    Scanner scanner = new Scanner(System.in);
    Phrases phrases = new Phrases();
    Search search = new Search();
    int option = 1;
    int[] path = new int[4];
    Library library = new Library();
    Book[] books;

    public ConsoleApplication() throws FileNotFoundException {
        Book book = new Book("a", "b", 1934, 2);

        while (option != 7) {
            PrintMenuList(phrases.MENU);
            option = scanner.nextInt();
            try {
                switch (option) {
                    case 1 -> option1();
                    //Add book
                    case 2 -> option2();
                    //Take book
                    case 3 -> option3();
                    //Remove book
                    case 4 -> option4();
                    //Load books
                    case 5 -> option5();
                    //Edit library
                    //Save library
                    case 6 -> exit(0);
                }
            } catch (Error err1) {
                System.out.println(phrases.ERR_OUT_OF_RANGE + 6);
                option = scanner.nextInt();
            }
        }
    }

    // Options
    // Add Book
    private void option1() {
        boolean addLoadedBook = false;
        Book book;
        //Checks if loaded books array is not null and prompts user if they want to load a book from there
        if (books != null) {
            System.out.println(phrases.ADD_LOADED_BOOK);
            System.out.println("1." + phrases.YES);
            System.out.println("2." + phrases.NO);
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    addLoadedBook = true;
                    break;
                case 2:
                    break;
            }
        } else {
            return;
        }
        //If the user chose to load a book prints the list and prompts the user to select a book
        // Else user creates a new book
        if (addLoadedBook) {
            System.out.println(phrases.CHOOSE_BOOK);
            for (int i = 0; i < books.length; i++) {
                System.out.println((i + 1) + ". " + books[i].getTitle() + ", " + books[i].getYearPublishedIn());
            }
            book = books[scanner.nextInt()];
        } else {
            String title;
            String author;
            int year;
            int pages;
            try {
                System.out.println(phrases.INPUT_TITLE);
                title = scanner.next();
                System.out.println(phrases.INPUT_AUTHOR);
                author = scanner.next();
                System.out.println(phrases.INPUT_YEAR);
                year = scanner.nextInt();
                System.out.println(phrases.INPUT_PAGES);
                pages = scanner.nextInt();
            } catch (Exception ex2) {
                System.out.println(phrases.ERR_INCORRECT_VALUE);
                return;
            }
            book = new Book(title, author, pages, year);
        }
        //Creating the path where to place the book
        System.out.println(phrases.PLACE_BOOK_OPTIONS[0]);
        System.out.println(phrases.PLACE_BOOK_OPTIONS[1]);
        path[0] = scanner.nextInt();
        System.out.println(phrases.PLACE_BOOK_OPTIONS[2]);
        path[1] = scanner.nextInt();
        System.out.println(phrases.PLACE_BOOK_OPTIONS[3]);
        path[2] = scanner.nextInt();

        //Adding the book
        try {
            library.library.get(path[0] - 1).room.get(path[1] - 1).addBook(book, path[2] - 1);
        } catch (Exception ex2) {
            System.out.println(phrases.ERR_INCORRECT_VALUE);
            return;
        }
        System.out.println(phrases.ADD_BOOK_SUCCESS);
    }

    //Take book
    private void option2() {
        boolean takeBook = false;
        Book book;
        ArrayList<Book> foundBooks = new ArrayList<>();

        System.out.println(phrases.FIND_OR_TAKE_BOOK);
        System.out.println("1. " + phrases.YES);
        System.out.println("2. " + phrases.NO);
        option = scanner.nextInt();
        try {
            switch (option) {
                case 1:
                    takeBook = true;
                    break;
                case 2:
                    break;
            }
        } catch (Error err5) {
            System.out.println(phrases.ERR_OUT_OF_RANGE + 2);
            return;
        }

        if (takeBook) {
            //Creating the path where to take the book from
            System.out.println(phrases.TAKE_BOOK_OPTIONS[0]);
            System.out.println(phrases.TAKE_BOOK_OPTIONS[1] + ":");
            path[0] = scanner.nextInt();
            System.out.println(phrases.TAKE_BOOK_OPTIONS[2] + ":");
            path[1] = scanner.nextInt();
            System.out.println(phrases.TAKE_BOOK_OPTIONS[3] + ":");
            path[2] = scanner.nextInt();
            System.out.println(phrases.TAKE_BOOK_OPTIONS[4] + ":");
            path[3] = scanner.nextInt();

            //Taking the book
            try {
                book = library.library.get(path[0] - 1).room.get(path[1] - 1).getBook(path[2] - 1, path[3] - 1);
            } catch (Exception ex3) {
                System.out.println(phrases.ERR_BOOK_IS_NULL);
                return;
            }
            PrintBookInfo(book);
        } else {
            PrintMenuList(phrases.FIND_BOOK_OPTIONS);
            int tempOption = scanner.nextInt();
            if (tempOption > 4 || tempOption < 1) {
                System.out.println(phrases.ERR_OUT_OF_RANGE + 4);
                return;
            }
            for (int i = 1; i < tempOption; i++) {
                System.out.println(phrases.PLACE_BOOK_OPTIONS[i]);
                path[i - 1] = scanner.nextInt();
            }
            tempOption--;

            System.out.println(phrases.TAKE_BOOK_FILTERS);
            System.out.println("1. " + phrases.BOOK_TRAITS[0]);
            System.out.println("2. " + phrases.BOOK_TRAITS[1]);
            System.out.println("3. " + phrases.BOOK_TRAITS[2]);
            System.out.println("4. " + phrases.BOOK_TRAITS[3]);
            option = scanner.nextInt();
            if (option > 4 || option < 1) {
                System.out.println(phrases.ERR_OUT_OF_RANGE + 4);
                return;
            }
            ArrayList<int[]> foundPaths = new ArrayList<>();
            try {
                switch (option) {
                    case 1 -> {
                        System.out.println(phrases.INPUT_TITLE);
                        foundPaths = search.FindBookPath(library, "", scanner.next(), 0, 0, 1, path,
                                tempOption);
                    }
                    case 2 -> {
                        System.out.println(phrases.INPUT_AUTHOR);
                        foundPaths = search.FindBookPath(library, scanner.next(), "", 0, 0, 2, path,
                                tempOption);
                    }
                    case 3 -> {
                        System.out.println(phrases.INPUT_YEAR);
                        foundPaths = search.FindBookPath(library, "", "", 0, scanner.nextInt(), 3, path,
                                tempOption);
                    }
                    case 4 -> {
                        System.out.println(phrases.INPUT_PAGES);
                        foundPaths = search.FindBookPath(library, "", "", scanner.nextInt(), 0, 4, path,
                                tempOption);
                    }
                }
            } catch (Error err4) {
                System.out.println(phrases.ERR_BOOK_NOT_FOUND);
            }
            for (int[] foundPath : foundPaths) {
                path = foundPath;
                foundBooks.add(library.library.get(path[0]).room.get(path[1]).getBook(path[2], path[3]));
            }
            if (foundBooks.size() > 0) {
                for (int i = 0; i < foundBooks.size(); i++) {
                    System.out.println(phrases.BOOK_FOUND[0] +
                            (foundPaths.get(i)[0] + 1) + phrases.BOOK_FOUND[1] +
                            (foundPaths.get(i)[1] + 1) + phrases.BOOK_FOUND[2] +
                            (foundPaths.get(i)[2] + 1) + phrases.BOOK_FOUND[3] +
                            (foundPaths.get(i)[3] + 1));
                    PrintBookInfo(foundBooks.get(i));
                    System.out.println();
                }
            } else {
                System.out.println(phrases.ERR_BOOK_NOT_FOUND);
            }
        }

    }

    //Remove book
    private void option3() {
        //Creating the path where to delete the book from
        System.out.println(phrases.TAKE_BOOK_OPTIONS[0]);
        System.out.println(phrases.TAKE_BOOK_OPTIONS[1] + ":");
        path[0] = scanner.nextInt();
        System.out.println(phrases.TAKE_BOOK_OPTIONS[2] + ":");
        path[1] = scanner.nextInt();
        System.out.println(phrases.TAKE_BOOK_OPTIONS[3] + ":");
        path[2] = scanner.nextInt();
        System.out.println(phrases.TAKE_BOOK_OPTIONS[4] + ":");
        path[3] = scanner.nextInt();

        //Delete the book
        try {
            library.library.get(path[0] - 1).room.get(path[1] - 1).booksOnShelf[path[2] - 1][path[3] - 1] = null;
        } catch (Exception ex3) {
            System.out.println(phrases.ERR_BOOK_IS_NULL);
        }
    }

    //Load books
    private void option4() throws FileNotFoundException {
        System.out.println(phrases.INPUT_FILE_PATH);
        ArrayList<Book> tempList = FileUtils.readListOfBooks(scanner.next());
        books = new Book[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            books[i] = tempList.get(i);
        }
        System.out.println(phrases.BOOKS_LOADED);
    }

    //Edit library
    private void option5() throws FileNotFoundException {
        PrintMenuList(phrases.LIBRARY_EDIT_OPTIONS);
        option = scanner.nextInt();
        switch (option) {
            case 1 -> AddRoom();
            case 2 -> AddBookCase();
            case 3 -> RemoveRoom();
            case 4 -> RemoveBookCase();
            case 5 -> ClearLibrary();
            case 6 -> LoadLibraryLayout();
        }
    }

    public void AddRoom() {
        library.addRoom();
        System.out.println(phrases.ROOM_ADD_SUCCESS + library.library.size());
    }

    public void RemoveRoom() {
        int roomNum;
        System.out.println(phrases.ROOM_REMOVE);
        roomNum = scanner.nextInt();
        try {
            library.removeRoom(roomNum - 1);
        } catch (Error noRooms) {
            System.out.println(phrases.ERR_NO_ROOMS);
        }
        System.out.println(phrases.ROOM_REMOVE_SUCCESS + library.library.get(roomNum).room.size());
    }

    public void AddBookCase() {
        //User inputs bookshelf location and params then adds the bookshelf
        int roomNum;
        int shelvesNum;
        int booksNum;
        System.out.println(phrases.BOOKCASE_ADD);
        roomNum = scanner.nextInt();
        System.out.println(phrases.BOOKCASE_ADD_SHELVES);
        shelvesNum = scanner.nextInt();
        System.out.println(phrases.BOOKCASE_ADD_CAPACITY);
        booksNum = scanner.nextInt();
        try {
            library.library.get(roomNum).addBookCase(shelvesNum, booksNum);
        } catch (Error roomNotFound) {
            System.out.println(phrases.ERR_ROOM_NOT_FOUND);
        }
        System.out.println(phrases.BOOKCASE_ADD_SUCCESS);
    }

    public void RemoveBookCase() {
        int roomNum;
        int bookCaseNum;
        System.out.println(phrases.BOOKCASE_REMOVE);
        roomNum = scanner.nextInt();
        System.out.println(phrases.BOOKCASE_REMOVE_ROOM);
        bookCaseNum = scanner.nextInt();
        try {
        library.library.get(roomNum).removeBookCase(bookCaseNum - 1);
        System.out.println(phrases.BOOKCASE_REMOVE_SUCCESS + library.library.get(roomNum).room.size());
        } catch (Error roomNotFound) {
            System.out.println(phrases.ERR_ROOM_NOT_FOUND);
        }
        System.out.println(phrases.BOOKCASE_ADD_SUCCESS);
    }

    public void ClearLibrary() {
        library.library.clear();
        System.out.println(phrases.LIBRARY_CLEARED);
    }

    public void LoadLibraryLayout() throws FileNotFoundException {
        System.out.println(phrases.INPUT_FILE_PATH);
        library.library.clear();
        library = FileUtils.readLibrary(scanner.next());
        System.out.println(phrases.BOOKS_LOADED);
    }

    public void PrintMenuList(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(i + ". ");
            }
            System.out.println(arr[i]);
        }
    }

    public void PrintBookInfo(Book book) {
        System.out.println(phrases.BOOK_TRAITS[0] + ": " + book.getTitle());
        System.out.println(phrases.BOOK_TRAITS[1] + ": " + book.getAuthor());
        System.out.println(phrases.BOOK_TRAITS[2] + ": " + book.getYearPublishedIn());
        System.out.println(phrases.BOOK_TRAITS[3] + ": " + book.getPages());
    }
}
