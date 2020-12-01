package com.dxc.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "fiction")
public class Fiction {
	@Id
	private int bookId;
	private String title;
	private String author;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="publishDob")
	@JsonFormat(pattern="dd-MM-yyyy", timezone="Asia/Kolkata")
	private Date publishDob;
	private int pages;
	public Fiction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fiction(int bookId, String title, String author, String dobth, int pages) throws ParseException {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		publishDob = date.parse(dobth);
		//this.publishDob = publishDob;
		this.pages = pages;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDob() {
		return publishDob;
	}
	public void setPublishDob(Date publishDob) {
		this.publishDob = publishDob;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		String dobth = new SimpleDateFormat("dd-MM-YYYY").format(publishDob);
		return "Fiction [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publishDob=" + dobth
				+ ", pages=" + pages + "]";
	}
	
	

}