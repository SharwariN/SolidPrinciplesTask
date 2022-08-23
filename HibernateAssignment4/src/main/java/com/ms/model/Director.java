package com.ms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Director {

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", bornId=" + bornId + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int directorId;
	private String directorName;
	private int bornId;
	
	public int getDirectorId() {
		return directorId;
	}
	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public int getBornId() {
		return bornId;
	}
	public void setBornId(int bornId) {
		this.bornId = bornId;
	}
}
