package com.example.user.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    EditText editName, editStatus;
    FloatingActionButton fab;
    Toolbar toolbar;

    String name, status, key;
    Book book;

    DatabaseReference reference;

    Intent openMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initialize();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBook();
            }
        });
    }

    void initialize(){
        editName = (EditText)findViewById(R.id.editName);
        editStatus = (EditText)findViewById(R.id.editStatus);
        reference = FirebaseDatabase.getInstance().getReference("data");
        fab = (FloatingActionButton) findViewById(R.id.fab);
        openMainActivity = new Intent(this, MainActivity.class);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    void pushBook(){
        name = editName.getText().toString();
        status = editStatus.getText().toString();
        key = reference.push().getKey();

        book = new Book(name, status, key);

        reference.child(key).setValue(book).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(AddActivity.this, "New book added", Toast.LENGTH_LONG).show();
                startActivity(openMainActivity);
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddActivity.this, "Book could not be added", Toast.LENGTH_LONG).show();
            }
        });
    }
}
