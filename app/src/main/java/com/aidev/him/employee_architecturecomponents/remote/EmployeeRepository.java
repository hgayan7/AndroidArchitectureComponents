package com.aidev.him.employee_architecturecomponents.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.aidev.him.employee_architecturecomponents.model.Employee;
import com.aidev.him.employee_architecturecomponents.room.EmployeeDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {
    private Context context;
    private EmployeeDatabase employeeDatabase;
    private LiveData<List<Employee>> listLiveData = new MutableLiveData<>();

    public EmployeeRepository(Context context){
        this.context = context;
        employeeDatabase = Room.databaseBuilder(context,EmployeeDatabase.class,"employeeDatabase").build();
    }

    public LiveData<List<Employee>> getListLiveData(){
        listLiveData = employeeDatabase.employeeDao().getAll();
        return listLiveData;
    }

    public void deleteEmployeeData(){
        employeeDatabase.employeeDao().deleteAll();
    }


    public void getEmployeeData(){
        APIService apiService = RetrofitClass.getAPIService();
        Call<EmployeeList> call = apiService.getEmployeeList();
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                Completable.fromAction(()->{

                    for(int i = 0 ;i<response.body().getEmployee().size();i++){
                        Employee employee = new Employee(
                                response.body().getEmployee().get(i).getFirstname(),
                                response.body().getEmployee().get(i).getLastname(),
                                response.body().getEmployee().get(i).getAge(),
                                response.body().getEmployee().get(i).getGender(),
                                response.body().getEmployee().get(i).getId()
                        );
                            employeeDatabase.employeeDao().insertAll(employee);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(context, "Data fetched and saved", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
                            }
                        });

            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {

            }
        });
    }
}
