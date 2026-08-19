package com.equipe1.aurora.ui.auth;

import static com.equipe1.aurora.R.id.btn_logar;
import static com.equipe1.aurora.R.id.tv_ir_para_cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.equipe1.aurora.R;
import com.equipe1.aurora.ui.home.HomeActivity;
import com.equipe1.aurora.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
// variaveis
    Button login, loginGoogle;
    TextView esqueceuSenha;
    TextView cadastrarUsuario;
    EditText email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        
        iniciarComponentes();
        

        // acoes de clique
        login.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            // Abrir a nova tela
            startActivity(intent);
        });

        cadastrarUsuario.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            // Abrir a nova tela cadastro
            startActivity(intent);
        });

        esqueceuSenha.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, EsqueceuSenhaActivity.class);
            // Abrir a nova tela esqueceuSenha
            startActivity(intent);
        });
    }

    private void iniciarComponentes() {

        email =  findViewById(R.id.et_email);
        senha =  findViewById(R.id.et_senha);
        login = findViewById(btn_logar);
        loginGoogle = findViewById(R.id.btn_logar_google);
        cadastrarUsuario = findViewById(tv_ir_para_cadastro);
        esqueceuSenha = findViewById(R.id.tv_ir_para_esqueceuSenha);

    }


}
