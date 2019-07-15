package com.aidev.him.employee_architecturecomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.aidev.him.employee_architecturecomponents.adapter.EmployeeAdapter;
import com.aidev.him.employee_architecturecomponents.remote.EmployeeRepository;
import com.aidev.him.employee_architecturecomponents.viewmodel.EmployeeViewModel;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    EmployeeRepository employeeRepository;
    private EmployeeViewModel employeeViewModel;
    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeRepository = new EmployeeRepository(this);
        recyclerView = findViewById(R.id.recycler_view);
        employeeViewModel = new EmployeeViewModel(this);
    }

    //Fetch API data and save to Room database and display the data saved in Room database in RecyclerView
    public void fetchAPI(View view){
        employeeViewModel.getEmployees(MainActivity.this);
        employeeViewModel.getEmployeeListData().observe(this,(employees)->{
            employeeRepository.getEmployeeData();
            employeeAdapter = new EmployeeAdapter(MainActivity.this,employees);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(employeeAdapter);
        });

    }

    //Delete all saved records from Room database
    public void deleteAll(View view){

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                employeeViewModel.deleteUsers(MainActivity.this);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "Employees deleted from database", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
