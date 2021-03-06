package com.example.qrhunter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerMenuActivity extends AppCompatActivity {

    Button ScanQRButton;
    Button ViewQRButton;
    Button SearchButton;
    Button RankingButton;
    ImageButton Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_menu_page);

        ScanQRButton = findViewById(R.id.scan_QRcodes_button);
        ViewQRButton = findViewById(R.id.view_QRcodes_button);
        SearchButton = findViewById(R.id.search_button);
        RankingButton = findViewById(R.id.ranking_button);
        Profile = findViewById(R.id.user_profile_button);


        ScanQRButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent JumpToScanQRPage = new Intent();
                JumpToScanQRPage.setClass(PlayerMenuActivity.this, ScanQRcodeActivity.class);
                startActivity(JumpToScanQRPage);
            }
        });

        //get username from bundle
        Bundle bundle = getIntent().getExtras();
        String Username = bundle.getString("UserName");

        Profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent JumpToMyProfilePage = new Intent();
                JumpToMyProfilePage.setClass(PlayerMenuActivity.this,LogInActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("UserName", Username);
                JumpToMyProfilePage.putExtras(bundle);
                startActivity(JumpToMyProfilePage);
            }
        });

        // continue to add


        }
}
