package com.ms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lockerId;
	private String lockerType;
	private int rent;
	
	public int getLockerId() {
		return lockerId;
	}
	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}
	public String getLockerType() {
		return lockerType;
	}
	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
}
