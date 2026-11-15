package Controllers.model;

import java.time.LocalDate;

public class ReturnBookDTO {

    private String membername;
    private String memberID;
    private String bookname;
    private String bookID;
    private String issueBookID;
    private LocalDate issuedate;
    private LocalDate duedate;
    private LocalDate returndate;

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getIssueBookID() {
        return issueBookID;
    }

    public void setIssueBookID(String issueBookID) {
        this.issueBookID = issueBookID;
    }

    public LocalDate getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }

    public ReturnBookDTO() {
    }

    @Override
    public String toString() {
        return "ReturnBookDTO{" +
                "membername='" + membername + '\'' +
                ", memberID='" + memberID + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookID='" + bookID + '\'' +
                ", issueBookID='" + issueBookID + '\'' +
                ", issuedate=" + issuedate +
                ", duedate=" + duedate +
                ", returndate=" + returndate +
                '}';
    }
}
