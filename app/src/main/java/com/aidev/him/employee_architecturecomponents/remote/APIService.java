package com.aidev.him.employee_architecturecomponents.remote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("v2/5d1313a00e0000fd3fb4a1c4")
    Call<EmployeeList> getEmployeeList();
}
