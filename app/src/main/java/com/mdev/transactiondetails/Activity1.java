package com.mdev.transactiondetails;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {
    private ListView listViewTransactions;
    private ArrayList<String> transactionList;
    private ArrayAdapter<String> transactionAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        listViewTransactions = findViewById(R.id.listViewTransactions);
        transactionList = new ArrayList<>();

        databaseHelper = new DatabaseHelper(this);

        // Fetch data from database and add it to the transactionList
        Cursor cursor = databaseHelper.getAllTransactions();
        if (cursor.moveToFirst()) {
            do {
                String transaction = cursor.getString(1) + " " + cursor.getDouble(2) + " " + cursor.getString(3);
                transactionList.add(transaction);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Set the transactionAdapter to display the data in the listViewTransactions
        transactionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, transactionList);
        listViewTransactions.setAdapter(transactionAdapter);
    }
}
