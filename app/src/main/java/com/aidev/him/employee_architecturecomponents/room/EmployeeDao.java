package com.aidev.him.employee_architecturecomponents.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aidev.him.employee_architecturecomponents.model.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("select * from employee")
    LiveData<List<Employee>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Employee ... employees);

    @Query("delete from employee")
    void deleteAll();
}
