package com.aidev.him.employee_architecturecomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.aidev.him.employee_architecturecomponents.model.Employee;
import com.aidev.him.employee_architecturecomponents.remote.EmployeeRepository;
import java.util.List;

public class EmployeeViewModel extends ViewModel {
    private Context context;
    private EmployeeRepository employeeRepository;
    private LiveData<List<Employee>> employeeListData= new MutableLiveData<>();

    public EmployeeViewModel(Context context){
        this.context = context;
        employeeRepository = new EmployeeRepository(context);
        employeeListData = employeeRepository.getListLiveData();
    }
    public LiveData<List<Employee>> getEmployeeListData() {
        employeeListData = employeeRepository.getListLiveData();
        return employeeListData;
    }

    public void getEmployees(){
        this.context = context;
        employeeRepository = new EmployeeRepository(context);
        employeeListData = employeeRepository.getListLiveData();
    }
    public void deleteUsers(){
        this.context =context;
        employeeRepository.deleteEmployeeData();

    }

}
