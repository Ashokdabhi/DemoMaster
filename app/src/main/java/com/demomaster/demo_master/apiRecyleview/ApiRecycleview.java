package com.demomaster.demo_master.apiRecyleview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.demomaster.R;
import com.demomaster.demo_master.apiRecyleview.pojo.Datum;
import com.demomaster.demo_master.apiRecyleview.pojo.MultipleResource;
import com.demomaster.demo_master.apiRecyleview.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRecycleview extends AppCompatActivity {
    APIInterface apiInterface;
    private TextView responseText;
    private TextView add;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_recycleview);
        dialog = new ProgressDialog(ApiRecycleview.this);
        responseText = (TextView) findViewById(R.id.responseText);
        add = (TextView) findViewById(R.id.add);
        dialog.setMessage("Doing something, please wait.");
        dialog.setCancelable(false);
        dialog.show();
        apiInterface = APIClient.getRetrofit().create(APIInterface.class);
        Call<MultipleResource> call = apiInterface.doMultipleResourceCall();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                Log.e("RESPONSE::::", String.valueOf(response.code()));

                MultipleResource multipleResource = response.body();
                String responseData = multipleResource.page + "Page\n" + multipleResource.total + "Total\n"
                        + multipleResource.totalPages + " Total Pages\n";

                List<Datum> datumList = multipleResource.data;
                for (int i = 0; i < datumList.size(); i++) {
                    responseData += datumList.get(i).id +
                            datumList.get(i).name +
                            datumList.get(i).pantoneValue +
                            datumList.get(i).year + "\n";
                }
                responseText.setText(responseData);
            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                Toast.makeText(ApiRecycleview.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
/**
 Create new user
 **/
//        User user = new User("Ashok", "leader");
//        Call<User> call1 = apiInterface.createUser(user);

//        HashMap<String, String> param = new HashMap<>();
//        param.put("job", "ABC");
//        param.put("name", "Ashok");
//        Call<User> call1 = apiInterface.createUser(param);
        Call<User> call1 = apiInterface.createUser("Ashok", "XYZ");
        System.out.println("DATTATTA:::::" + call1);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                User user1 = response.body();

//                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
                add.setText(user1.name + "\n" + user1.job + "\n" + user1.id + "\n" + user1.createdAt);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                Toast.makeText(ApiRecycleview.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

    }
}
