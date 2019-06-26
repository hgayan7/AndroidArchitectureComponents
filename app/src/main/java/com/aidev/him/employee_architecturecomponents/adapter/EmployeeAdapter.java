package com.aidev.him.employee_architecturecomponents.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aidev.him.employee_architecturecomponents.R;
import com.aidev.him.employee_architecturecomponents.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>{

    Context context;
    List<Employee> employeeList;

    public EmployeeAdapter(Context context, List<Employee> employeeList){
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_row,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {
        Employee employee = employeeList.get(i);
        employeeViewHolder.name.setText(employee.getFirstname() + " " + employee.getLastname());
        employeeViewHolder.age.setText(employee.getAge());
       employeeViewHolder.gender.setText(employee.getGender());
        employeeViewHolder.id.setText(employee.getId());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{

        private TextView name,age,gender,id;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameText);
           age = itemView.findViewById(R.id.ageText);
           gender = itemView.findViewById(R.id.genderText);
           id = itemView.findViewById(R.id.empId);
        }


    }
}