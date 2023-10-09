package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    public static Scanner sc = new Scanner(System.in);
    public static int choice;
    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU*************** ");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách ");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách ");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn (1-7): ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số sách (n): ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        Book book = new Book();
                        book.inputData();
                        bookList.add(book);
                    }
                    break;
                case 2:
                    for (Book book : bookList) {
                        book.displayData();
                    }
                    break;
                case 3:
//                    Collections.sort(bookList, Comparator.comparing(Book::getInterest).reversed());
//                    System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần.");
//                    for (Book book : bookList) {
//                        book.displayData();
//                    }
                    Collections.sort(bookList);
                    System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần.");
                    for (Book book : bookList) {
                        book.displayData();
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int deleteBookId = Integer.parseInt(sc.nextLine());
                    for (Book book : bookList) {
                        if (book.getBookId() == deleteBookId) {
                            bookList.remove(book);
                            System.out.println("Sách đã được xóa.");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.printf("Nhập tên sách cần tìm: ");
                    String name = sc.nextLine();
                    boolean found = false;
                    for (Book book : bookList) {
                        if (book.getBookName().equalsIgnoreCase(name)) {
                            book.displayData();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách với tên " + name);
                    }

                    break;
                case 6:
                    System.out.print("Nhập mã sách cần thay đổi trạng thái: ");
                    int changeStatusBookId = Integer.parseInt(sc.nextLine());
                    for (Book book : bookList) {
                        if (book.getBookId() == changeStatusBookId) {
                            book.setStatus(!book.isStatus());
                            System.out.println("Trạng thái của sách đã được thay đổi.");
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Đã thoát!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
