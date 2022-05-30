package com.demomaster.demo_master.apiRecyleview;

import com.demomaster.demo_master.apiRecyleview.pojo.MultipleResource;
import com.demomaster.demo_master.apiRecyleview.pojo.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

interface APIInterface {

    @GET("/api/unknown")
    Call<MultipleResource> doMultipleResourceCall();

   @FormUrlEncoded
    @POST("/api/users")
//    Call<User> createUser(@Body User user);
//    Call<User> createUser(@FieldMap Map<String, String> fields);
    Call<User> createUser(@Field("name") String name,
                          @Field("job") String job);

}

