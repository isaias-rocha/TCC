package com.equipe1.aurora.ui.auth;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.equipe1.aurora.R;

public class RegisterActivity extends AppCompatActivity {

    // 1. Declaração das variáveis
    private TextInputEditText etNome;
    private TextInputEditText etTelefone;
    private TextInputEditText etEmailCadastro;
    private TextInputEditText etSenhaCadastro;
    private TextInputEditText etConfirmarSenha;
    private MaterialButton btnCadastrar;
    private TextView tvVoltarLogin;
    private TextView tvVoltarLoginDesc;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 2. Inicialização dos componentes
        etNome = findViewById(R.id.et_nome);
        etTelefone = findViewById(R.id.et_telefone);
        etEmailCadastro = findViewById(R.id.et_email_cadastro);
        etSenhaCadastro = findViewById(R.id.et_senha_cadastro);

        etConfirmarSenha = findViewById(R.id.et_confirmar_senha_cadastro);

        btnCadastrar = findViewById(R.id.btn_cadastrar);

        tvVoltarLogin = findViewById(R.id.tv_ir_para_login);
        tvVoltarLoginDesc = findViewById(R.id.tv_ir_para_login_desc);



        // 3. Configuração de clique para realizar o cadastro
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarCadastro();
            }
        });


        // 4. Configuração de clique para voltar ao Login
        tvVoltarLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Configuração de clique para voltar ao login (desc)
        tvVoltarLoginDesc.setOnClickListener(v -> {
                // codigo para ir ao login
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }


    // Méttodo que valida as entradas de texto e processa a criação da conta
    private void executarCadastro() {
        String nome     =       etNome.getText().toString().trim();
        String telefone =       etTelefone.getText().toString().trim();
        String email    =       etEmailCadastro.getText().toString().trim();
        String senha    =       etSenhaCadastro.getText().toString().trim();


        // Validação: Nome
        if (TextUtils.isEmpty(nome)) {
            etNome.setError("O nome é obrigatório");
            etNome.requestFocus();
            return;
        }

        // Validação: Telefone
        if (TextUtils.isEmpty(telefone)) {
            etTelefone.setError("O telefone é obrigatório");
            etTelefone.requestFocus();
            return;
        }

        // validação de tamanho para o telefone (ex: mínimo de 11 dígitos com o DDD)
        if (telefone.length() < 11) {
            etTelefone.setError("Insira um telefone válido com o indicativo (DDD)");
            etTelefone.requestFocus();
            return;
        }

        // Validação: E-mail
        if (TextUtils.isEmpty(email)) {
            etEmailCadastro.setError("O e-mail é obrigatório");
            etEmailCadastro.requestFocus();
            return;
        }

        // Validação: Senha
        if (TextUtils.isEmpty(senha)) {
            etSenhaCadastro.setError("A senha é obrigatória");
            etSenhaCadastro.requestFocus();
            return;
        }

        if (senha.length() < 8) {
            etSenhaCadastro.setError("A senha deve ter pelo menos 8 caracteres");
            etSenhaCadastro.requestFocus();
            return;
        }

        if (senha != senha) {
            etConfirmarSenha.setError("A senha deve não pode ser diferente");
        }


        // TTODO: Enviar nome, TELEFONE, email e senha para o Banco de Dados
        Toast.makeText(this, "Conta criada com sucesso!", Toast.LENGTH_LONG).show();
        finish();
    }
}