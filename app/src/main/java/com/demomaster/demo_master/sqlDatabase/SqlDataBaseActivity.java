package com.demomaster.demo_master.sqlDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.demomaster.R;

public class SqlDataBaseActivity extends AppCompatActivity {
    DataBaseHelper mydb;
    private EditText edt_name, edt_surname, edt_marks, edt_id;
    private Button btn_addData, btn_viewAll, btn_update, btn_delete;
    private Toolbar toolbar;
    private CardView img_card;
    public static final int PICK_IMAGE_REQUEST = 100;
    private Uri uri;
    private Bitmap bitmap;
    private ImageView image_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_data_base);

        toolbar = (Toolbar) findViewById(R.id.toolbare);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mydb = new DataBaseHelper(this);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_surname = (EditText) findViewById(R.id.edt_surname);
        edt_marks = (EditText) findViewById(R.id.edt_marks);
        edt_id = (EditText) findViewById(R.id.edt_id);
        img_card = (CardView) findViewById(R.id.img_card);
        image_view = (ImageView) findViewById(R.id.image_view);
        btn_addData = (Button) findViewById(R.id.btn_addData);
        btn_viewAll = (Button) findViewById(R.id.btn_viewAll);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        addData();
        viewAllData();
        update();
        deleteData();
        selectImage();
    }


    private void addData() {
        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (image_view.getDrawable() != null && bitmap != null) {
                    boolean isInsert = mydb.insertData(new ModelClass(
                            edt_name.getText().toString().trim(),
                            edt_surname.getText().toString().trim(),
                            edt_marks.getText().toString().trim(),
                            bitmap));
                    if (isInsert == true) {
                        Toast.makeText(SqlDataBaseActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SqlDataBaseActivity.this, "Data Note Inseted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SqlDataBaseActivity.this, "Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewAllData() {
        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :-" + res.getString(0) + "\n");
                    buffer.append("NAME :-" + res.getString(1) + "\n");
                    buffer.append("SURNAME :-" + res.getString(2) + "\n");
                    buffer.append("MARKS :-" + res.getString(3) + "\n");
                    buffer.append("IMAGE:-" + res.getBlob(4) + "\n\n");
                    byte[] imageByte = res.getBlob(4);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
                    image_view.setImageBitmap(bitmap);
                }
                showMessage("Data", String.valueOf(buffer));
            }
        });
    }

    private void update() {
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = mydb.updateData(new ModelClass(edt_id.getText().toString(),
                        edt_name.getText().toString(),
                        edt_surname.getText().toString(),
                        edt_marks.getText().toString(),
                        bitmap));

                if (isUpdate == true) {
                    Toast.makeText(SqlDataBaseActivity.this, "Data Update", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SqlDataBaseActivity.this, "Data Note Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void deleteData() {
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleterow = mydb.deleteData(edt_id.getText().toString().trim());

                if (deleterow > 0) {
                    Toast.makeText(SqlDataBaseActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SqlDataBaseActivity.this, "Data Note Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void selectImage() {
        img_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
                } catch (Exception e) {
                    Toast.makeText(SqlDataBaseActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                uri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                image_view.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
