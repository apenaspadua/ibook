package com.padua.ibook.ui.register;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.padua.ibook.R;
import com.padua.ibook.application.MyApplication;
import com.padua.ibook.model.Book;
import com.padua.ibook.ui.BaseCreate;
import com.padua.ibook.utils.Utils;

public class RegisterActivity extends AppCompatActivity implements BaseCreate {

    private EditText name, author, description;
    private TextInputLayout tilName, tilAuthor;
    private ImageView back;
    private FloatingActionButton register;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Chamando a inicializao ao carregar tela
        initInstance();
        initComponents();

        register.setOnClickListener(buttonClickRegister);
        back.setOnClickListener(backClick);
    }

    private View.OnClickListener backClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           onBackPressed();
        }
    };

    private View.OnClickListener buttonClickRegister = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            insertBook();
        }
    };

    private void insertBook(){
        if (validateForm()){
            book.setName(name.getText().toString());
            book.setAuthor(author.getText().toString());
            book.setDescription(description.getText().toString());

            resetForm();
        }
    }

    private boolean validateForm(){
        if(name.getText().toString().isEmpty()){
            tilName.setError(getString(R.string.text_form_empty));
            return false;
        }
        else if(author.getText().toString().isEmpty()){
            tilAuthor.setError(getString(R.string.text_form_empty));
            return false;
        }

        return true;
    }

    private void resetForm(){
        if(((MyApplication) getApplication()).insertBook(book)){
            name.setText("");
            author.setText("");
            description.setText("");
            showMessage(getString(R.string.text_form_save));
        }
        else {
            showMessage(getString(R.string.text_form_failed));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    private void showMessage(String message){
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void initInstance() {
        //Inicializando banco
        book = Book.getInstance();
    }

    @Override
    public void initComponents() {

        try{
            //Mapeando componentes
            name = findViewById(R.id.nameBook);
            author = findViewById(R.id.authorBook);
            description = findViewById(R.id.descriptionBook);
            tilName = findViewById(R.id.tilName);
            tilAuthor = findViewById(R.id.tilAuthor);
            register = findViewById(R.id.register);
            back = findViewById(R.id.back);

            //Atribuindo comportamento ao botao
            Utils.setPushDownAnimation(back);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
