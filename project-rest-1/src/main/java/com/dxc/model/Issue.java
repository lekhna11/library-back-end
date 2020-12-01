package com.dxc.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Issue {
	private int bookId;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issueId;
//	private String title;
//	private String author;
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
//	@Column(name = "publishDob")
//	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
//	private Date publishDob;
//	private int pages;
	private String status;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
	private Date date;

	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Issue(int bookId, int issueId, String status, String dob)
			throws ParseException {
		super();
		this.bookId = bookId;
		this.issueId = issueId;
//		this.title = title;
//		this.author = author;
//		SimpleDateFormat dates = new SimpleDateFormat("dd-MM-yyyy");
//		publishDob = dates.parse(dobth);
//		this.pages = pages;
		this.status = status;
		SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
		date = dat.parse(dob);
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public Date getPublishDob() {
//		return publishDob;
//	}
//
//	public void setPublishDob(Date publishDob) {
//		this.publishDob = publishDob;
//	}
//
//	public int getPages() {
//		return pages;
//	}
//
//	public void setPages(int pages) {
//		this.pages = pages;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
//		String dobth = new SimpleDateFormat("dd-MM-YYYY").format(publishDob);
		String dob = new SimpleDateFormat("dd-MM-YYYY").format(date);
//		return "Issue [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publishDob=" + dobth
//				+ ", pages=" + pages + ", status=" + status + ", date=" + dob + "]";
		return "Issue [bookId=" + bookId + ", issueId=" + issueId + ", status=" + status + ", date=" + dob + "]";
	}

}