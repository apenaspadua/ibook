package com.padua.ibook.ui.listbook;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.padua.ibook.R;
import com.padua.ibook.database.Database;
import com.padua.ibook.database.dao.BookDao;
import com.padua.ibook.model.Book;
import com.padua.ibook.ui.listbook.adapter.ListAdapter;
import com.padua.ibook.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

public class ListActivity extends AppCompatActivity {

    private ImageView back;
    private List<Book> bookList;
    private ListAdapter adapter;
    private RecyclerView recyclerView;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = Database.getInstance(this);

        initializeComponents();
        loadList();

        Utils.setPushDownAnimation(back);
        back.setOnClickListener(backClick);
    }

    private View.OnClickListener backClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };

    private void initializeComponents(){
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recyclerbooks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadList(){
        bookList = new ArrayList<>();
        bookList.addAll(db.bookDao().getAllBooks());
        adapter = new ListAdapter(this, bookList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
}
