package com.aidev.him.employee_architecturecomponents.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.aidev.him.employee_architecturecomponents.model.Employee;

@Database(entities = {Employee.class},version = 1,exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

}

