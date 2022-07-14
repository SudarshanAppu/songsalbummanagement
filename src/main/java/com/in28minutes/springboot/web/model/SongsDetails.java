package com.in28minutes.springboot.web.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SongsDetails {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String songsTitle;
	private String childfav;
	private String artist;
	private Date dateTime;
	private Float duration;
	
	public SongsDetails() {
		super();
	}

	public SongsDetails(int id, String songsTitle, String childfav, String artist, Date dateTime, Float duration) {
		super();
		this.id = id;
		this.songsTitle = songsTitle;
		this.childfav = childfav;
		this.artist = artist;
		this.dateTime = dateTime;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongsTitle() {
		return songsTitle;
	}

	public void setSongsTitle(String songsTitle) {
		this.songsTitle = songsTitle;
	}

	public String getChildfav() {
		return childfav;
	}

	public void setChildfav(String childfav) {
		this.childfav = childfav;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "SongsDetails [id=" + id + ", songsTitle=" + songsTitle + ", childfav=" + childfav + ", artist=" + artist
				+ ", dateTime=" + dateTime + ", duration=" + duration + "]"+"\n";
	}

	
	
}
