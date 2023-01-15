package com.baristalayoglu.projectlibrary.entity;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="reciept")
public class Reciept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="order_date")
    private Date date;
    @Column(name="member_name")
    private String memberName;
    @Column(name="book_name")
    private String bookName;
    @Column(name="return_date")
    private Date returnDate;

    public Reciept(Date date, String memberName, String bookName, Date returnDate) {
        loadDates();
        this.date = date;
        this.memberName = memberName;
        this.bookName = bookName;
        this.returnDate = returnDate;
    }


    public Reciept() {
        loadDates();
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getBookName() {
        return bookName;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void loadDates(){
        date = new Date();
        returnDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(returnDate);
        c.add(Calendar.DATE, 14);
        returnDate = c.getTime();
    }
}
