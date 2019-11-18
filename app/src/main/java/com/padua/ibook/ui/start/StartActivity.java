package com.padua.ibook.ui.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.padua.ibook.ui.BaseCreate;
import com.padua.ibook.ui.listbook.ListActivity;
import com.padua.ibook.R;
import com.padua.ibook.ui.register.RegisterActivity;
import com.padua.ibook.utils.Utils;

public class StartActivity extends AppCompatActivity implements BaseCreate {

    private RelativeLayout buttonRegister, buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Chamando a inicializao ao carregar tela
        initComponents();

        buttonRegister.setOnClickListener(buttonClickRegister);
        buttonList.setOnClickListener(buttonClickList);
    }

    private View.OnClickListener buttonClickRegister = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(StartActivity.this, RegisterActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    };

    private View.OnClickListener buttonClickList = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(StartActivity.this, ListActivity.class));
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    };


    @Override
    public void initInstance() {
        return;
    }

    @Override
    public void initComponents() {
        try {
            //Mapeando componentes
            buttonRegister = findViewById(R.id.register);
            buttonList = findViewById(R.id.listBook);

            //Atribuindo comportamento ao botao
            Utils.setPushDownAnimation(buttonRegister);
            Utils.setPushDownAnimation(buttonList);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
