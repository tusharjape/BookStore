package com.example.user.bookstore;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class ListAdapter extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<Book> books;

    ListAdapter(@NonNull Activity context, ArrayList<Book> arr) {
        super(context, R.layout.row_view);
        this.context = context;
        this.books = arr;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = context.getLayoutInflater().inflate(R.layout.row_view, null);

        TextView txtName = (TextView)convertView.findViewById(R.id.txtName), txtStatus = (TextView)convertView.findViewById(R.id.txtStatus);

        txtName.setText(books.get(position).getName());
        txtStatus.setText(books.get(position).getStatus());

        return convertView;
    }
}
