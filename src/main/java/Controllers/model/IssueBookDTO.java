package Controllers.model;

import java.time.LocalDate;

public class IssueBookDTO {
    private String membername;
    private String memberID;
    private String bookID;
    private String bookname;
    private String issueID;
    private LocalDate issuedate;
    private LocalDate duedate;

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

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIssueID() {
        return issueID;
    }

    public void setIssueID(String issueID) {
        this.issueID = issueID;
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

    public IssueBookDTO() {
    }

    @Override
    public String toString() {
        return "IssueBookDTO{" +
                "membername='" + membername + '\'' +
                ", memberID='" + memberID + '\'' +
                ", bookID='" + bookID + '\'' +
                ", bookname='" + bookname + '\'' +
                ", issueID='" + issueID + '\'' +
                ", issuedate=" + issuedate +
                ", duedate=" + duedate +
                '}';
    }
}
