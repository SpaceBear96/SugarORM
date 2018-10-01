package com.tecsup.spacebear.sugarorm.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tecsup.spacebear.sugarorm.R;
import com.tecsup.spacebear.sugarorm.models.User;
import com.tecsup.spacebear.sugarorm.repositories.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG= MainActivity.class.getSimpleName();
    private EditText fullbnameInput;
    private EditText emailInput;
    private EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullbnameInput=findViewById(R.id.fullname_input);
        emailInput=findViewById(R.id.email_input);
        passwordInput=findViewById(R.id.password_input);
    }

    public void callRegistrar(View view){
        String fullname= fullbnameInput.getText().toString();
        String email=emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Completar los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        UserRepository.create(fullname,email,password);

        fullbnameInput.setText("");
        emailInput.setText("");
        passwordInput.setText("");

        Toast.makeText(this,"Registro Completo",Toast.LENGTH_SHORT).show();
        callListar();
    }

    private void callListar(){
        List<User> users=UserRepository.list();
        for (User user : users){
            Log.d(TAG,"User" + user);
        }
    }
}
