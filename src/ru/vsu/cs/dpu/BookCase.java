package ru.vsu.cs.dpu;

public class BookCase {
    int numShelves;
    int shelfCapacity;
    int[] numBooks;
    Book[][] booksOnShelf;
    //booksOnShelf[0][] is the set of books on the lowest Shelf;

    public BookCase(int numShelves, int shelfCapacity) {
        this.shelfCapacity = shelfCapacity;
        this.numShelves = numShelves;
        booksOnShelf = new Book[numShelves][shelfCapacity];
        for (int i = 0; i < numShelves; i++) {
            booksOnShelf[i] = new Book[shelfCapacity];
        }
        numBooks = new int[numShelves];
        for (int j = 0; j < numBooks.length; j++) {
            numBooks[j] = 0;
        }
    }

    public void addBook(Book book, int shelfNum) {
        if (numBooks[shelfNum] == shelfCapacity) {
            System.out.println("Нет места");
        } else {
            int bookSpotNum = firstEmptySpot(booksOnShelf[shelfNum]);
            booksOnShelf[shelfNum][bookSpotNum] = book;
            numBooks[shelfNum]++;
        }
    }

    public void removeBook(int bookNum, int shelfNum) {
        booksOnShelf[shelfNum][shelfNum] = null;
        numBooks[shelfNum]--;
    }

    public void emptyShelf (int shelfNum) {
        for (int j = 0; j < shelfCapacity; j++) {
            booksOnShelf[shelfNum][j] = null;
        }
        numBooks[shelfNum] = 0;
    }

    public void emptyBookCase() {
        for (int i = 0; i < numShelves; i++) {
            for (int j = 0; j < shelfCapacity; j++) {
                booksOnShelf[i][j] = null;
            }
            numBooks[i] = 0;
        }
    }

    public Book getBook(int shelfNum, int bookNum) {
        return booksOnShelf[shelfNum][bookNum];
    }

    public Book[] getBooksOnShelf(int shelfNum) {
        return booksOnShelf[shelfNum];
    }

    public int firstEmptySpot(Book[] shelf) {
        int i = 0;
        while (shelf[i] != null) {
            i++;
        }
        return i;
    }
}
