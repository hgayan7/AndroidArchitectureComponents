package com.aidev.him.employee_architecturecomponents.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "firstname")
    @SerializedName("firstname")
    @Expose
    private String firstname;

    @ColumnInfo(name = "lastname")
    @SerializedName("lastname")
    @Expose
    private String lastname;

    @ColumnInfo(name = "age")
    @SerializedName("age")
    @Expose
    private String age;

    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    @Expose
    private String gender;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private String id;

    @ColumnInfo(name = "nationality")
    @SerializedName("nationality")
    @Expose
    private String nationality;

    public Employee(String firstname, String lastname, String age, String gender, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender =gender;
        this.id = id;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}