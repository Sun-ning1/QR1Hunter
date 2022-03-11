package com.example.qrhunter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogInActivity extends AppCompatActivity {

    Button LogInButton;
    Button SignUpButton;
    ImageButton ScanButton;
    EditText UsernameLoginEditText;
    EditText PasswordLoginEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        //Find corresponding view in the layout files.
        UsernameLoginEditText = findViewById(R.id.username);
        PasswordLoginEditText = findViewById(R.id.password);

        SignUpButton = findViewById(R.id.signup_button);
        LogInButton = findViewById(R.id.login_button);
        ScanButton = findViewById(R.id.scan_button);


        SignUpButton.setOnClickListener(new View.OnClickListener() {
            //For user to sign up an account
            @Override
            public void onClick(View view) {
                Intent JumpToSignUpPage = new Intent();
                JumpToSignUpPage.setClass(LogInActivity.this, SignUpActivity.class);
                startActivity(JumpToSignUpPage);
            }
        });

        //open the firebase and connect
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        LogInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //get user input from EditText View
                final String Username = UsernameLoginEditText.getText().toString();
                final String Password = PasswordLoginEditText.getText().toString();

                if (Username.length() == 0){
                    Toast.makeText(LogInActivity.this, "Username can not be empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (Password.length() == 0){
                        Toast.makeText(LogInActivity.this,"Password cannot be empty!",Toast.LENGTH_SHORT).show();
                    }
                    if(){
                        DocumentReference noteRef = db.collection(Username).document("UserProfile");
                        noteRef.get()
                                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        //if get Snapshot in the userProfile successfully, compares the password with the user input

                                        if (documentSnapshot.exists()) {
                                            String password = documentSnapshot.getString("Password");
                                            // if passwords match, jump to menu page
                                            if (password.equals(Password)) {
                                                Intent JumpToMenu = new Intent();
                                                JumpToMenu.setClass(LogInActivity.this,PlayerMenuActivity.class);
                                                Bundle bundle = new Bundle();
                                                bundle.putString("UserName", Username);
                                                JumpToMenu.putExtras(bundle);
                                                startActivity(JumpToMenu);
                                            }
                                            // else turn the error message visible
                                            else {
                                                Toast.makeText(LogInActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                        // else turn the error message visible
                                        else {
                                            Toast.makeText(LogInActivity.this, "Username not found, please sign up first", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }

                    else {
                        DocumentReference noteRef = db.collection(Username).document("UserProfile");
                        noteRef.get()
                                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        //if get Snapshot in the userProfile successfully, compares the password with the user input

                                        if (documentSnapshot.exists()) {
                                            String password = documentSnapshot.getString("Password");
                                            // if passwords match, jump to menu page
                                            if (password.equals(Password)) {
                                                Intent JumpToMenu = new Intent();
                                                JumpToMenu.setClass(LogInActivity.this,PlayerMenuActivity.class);
                                                Bundle bundle = new Bundle();
                                                bundle.putString("UserName", Username);
                                                JumpToMenu.putExtras(bundle);
                                                startActivity(JumpToMenu);
                                            }
                                            // else turn the error message visible
                                            else {
                                                Toast.makeText(LogInActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                        // else turn the error message visible
                                        else {
                                            Toast.makeText(LogInActivity.this, "Username not found, please sign up first", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }

                }

            }
        });





    }
}
