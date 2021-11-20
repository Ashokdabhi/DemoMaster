package com.demomaster.apiRecyleview;

import com.demomaster.apiRecyleview.pojo.MultipleResource;
import com.demomaster.apiRecyleview.pojo.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
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

