package com.padua.ibook.ui.listbook.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.padua.ibook.R;
import com.padua.ibook.model.Book;
import com.padua.ibook.utils.Utils;

import java.util.List;

@SuppressLint("NewApi")
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private Context context;
    private List<Book> bookList;
    private static ListAdapter adapter;

    public static synchronized ListAdapter getInstance(){
        if (adapter == null) adapter = new ListAdapter();

        return adapter;
    }

    public ListAdapter() { }

    public ListAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Book book = bookList.get(position);

        holder.name.setText(book.getName());
        holder.author.setText(book.getAuthor());
        holder.description.setText(book.getDescription());

        Utils.setPushDownAnimation(holder.readitButton);

        if(book.isReadIt())
            holder.readitButton.setBackground(context.getDrawable(R.drawable.button_readit_enable));
        else
            holder.readitButton.setBackground(context.getDrawable(R.drawable.button_readit_disable));

        holder.readitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(book.isReadIt()){
                    book.setReadIt(false);
                    holder.readitButton.setBackground(context.getDrawable(R.drawable.button_readit_disable));
                }
                else{
                    book.setReadIt(true);
                    holder.readitButton.setBackground(context.getDrawable(R.drawable.button_readit_enable));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, author, description;
        RelativeLayout readitButton;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameBook);
            author = itemView.findViewById(R.id.authorBook);
            description = itemView.findViewById(R.id.descriptionBook);
            readitButton = itemView.findViewById(R.id.read_it);
        }
    }

}
