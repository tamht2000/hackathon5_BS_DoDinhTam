package ra.bussinessImp;

import ra.bussiness.IBook;

import static ra.run.BookManagement.sc;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean status;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, boolean status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.status = status;
        this.calculateInterest();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData() {
        System.out.println("Vui lòng nhập id sản phẩm: ");
        bookId = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập tên sản phẩm: ");
        bookName = sc.nextLine();
        System.out.println("Vui lòng nhập tiêu đề sản phẩm: ");
        title = sc.nextLine();
        System.out.println("Vui lòng nhập số trang sách: ");
        numberOfPages = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập giá nhập của sản phẩm: ");
        importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Vui lòng nhập giá bán của sản phẩm: ");
        exportPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Vui lòng nhập trạng thái hoạt động sản phẩm(true/false): ");
        String isActive = sc.nextLine();
        if (isActive.equals("true")) {
            status = true;
        } else if (isActive.equals("false")) {
            status = false;
        } else {
            status = false;
        }
        this.calculateInterest();
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d - Name: %s - Title: %s - NumberOfPages: %d - ImportPrice: %.2f - ExportPrice: %.2f - Interest: %.2f - Status: %s\n", bookId,bookName,title,numberOfPages,importPrice,exportPrice,interest,status ? "Đang bán" : "Không bán");
        System.out.println("---------------------------------------------------------");
    }

    // Tính lợi nhuận
    private void calculateInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    @Override
    public int compareTo(Book otherBook) {
        // So sánh lợi nhuận giữa hai sách
        int result = Float.compare(otherBook.getInterest(), this.getInterest());

        // Nếu lợi nhuận bằng nhau, sử dụng mã sách để so sánh
        if (result == 0) {
            result = Integer.compare(this.getBookId(), otherBook.getBookId());
        }

        return result;
    }
}
