package com.example.qrhunter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyProfileActivity extends AppCompatActivity {

    TextView UserName;
    TextView ContactInfo;
    TextView UserDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile_page);

        UserName = findViewById(R.id.profile_username);
        ContactInfo = findViewById(R.id.profile_contact_info);
        UserDevice = findViewById(R.id.user_device_profile);

        //get username from bundle
        Bundle bundle = getIntent().getExtras();
        String Username = bundle.getString("UserName");





    }
}
