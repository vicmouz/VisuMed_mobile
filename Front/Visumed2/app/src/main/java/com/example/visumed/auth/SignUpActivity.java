package com.example.visumed.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.visumed.R;
import com.example.visumed.entidades.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseAuthListener authListener;
    EditText edEmail;
    EditText edPassword;
    EditText edNome;
    EditText edCPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.mAuth = FirebaseAuth.getInstance();
        this.authListener = new FirebaseAuthListener(this);
    }

    public void buttonSignUpClick(View view) {
        edEmail = (EditText) findViewById(R.id.edit_email);
        edPassword = (EditText) findViewById(R.id.edit_password);
        edNome = (EditText) findViewById(R.id.edit_name);
        edCPF = (EditText) findViewById(R.id.edit_Cpf);

        final String email = edEmail.getText().toString();
        final String password = edPassword.getText().toString();
        final String name = edNome.getText().toString();
        final String CPF = edCPF.getText().toString();

        if (email.isEmpty() || password.isEmpty() || name.isEmpty() || CPF.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Dados inválidos", Toast.LENGTH_SHORT).show();
        } else {


            final FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    String msg = task.isSuccessful() ? "Cadastro Realizado com Sucesso!" : "Erro ao realizar cadastro";

                    Toast.makeText(SignUpActivity.this, msg, Toast.LENGTH_SHORT).show();

                    if (task.isSuccessful()) {
                        User user = new User();
                        user.setNome(name);
                        user.setCpf(CPF);
                        user.setEmail(email);

                        DatabaseReference drUsers = FirebaseDatabase.
                                getInstance().getReference("users");
                        drUsers.child(mAuth.getCurrentUser().getUid()).
                                setValue(user);
                    }
                }
            });
        }
    }

    public void redirect_login(View view) {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}
