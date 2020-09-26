package com.dxc.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks {
	
	@Id
	int stid;
	int exid;
	String stud_name;
	String exam_name;
	int sub1;
	int sub2;
	int sub3;
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Marks(int stid, int exid, String stud_name, String exam_name, int sub1, int sub2, int sub3) {
		super();
		this.stid = stid;
		this.exid = exid;
		this.stud_name = stud_name;
		this.exam_name = exam_name;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public int getExid() {
		return exid;
	}
	public void setExid(int exid) {
		this.exid = exid;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	@Override
	public String toString() {
		return "Marks [stid=" + stid + ", exid=" + exid + ", stud_name=" + stud_name + ", exam_name=" + exam_name
				+ ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + "]";
	}
	
	

}
