package org.example.test;

public class BookStatus {
    private boolean isTaken;
    private final Book book;
    private final Employees employer;

    public BookStatus(boolean status, Book book, Employees employer) {
        this.isTaken = status;
        this.book = book;
        this.employer = employer;
    }

    public boolean getTaken() {
        return isTaken;
    }

    public void checkOutBook(String employeeId) {
        if (this.isTaken) {
            System.out.printf("Книга %s ужe взята сотрудником %s", book.getName(), employer.getName());
        } else {
            this.isTaken = true;
        }
    }
    public void returnBook() {
        this.isTaken = false;
    }
}
