package appmoviles.com.appsmoviles20191;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText et_login_correo;
    private EditText et_login_pass;
    private Button btn_login_login;
    private TextView txt_singup;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        et_login_correo = findViewById(R.id.et_login_correo);
        et_login_pass = findViewById(R.id.et_login_pass);
        btn_login_login = findViewById(R.id.btn_login_login);
        txt_singup = findViewById(R.id.txt_singup);

        btn_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = et_login_correo.getText().toString();
                String pass = et_login_pass.getText().toString();
                auth.signInWithEmailAndPassword(correo, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "No se pudo ingresar", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        
        txt_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SingupActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
