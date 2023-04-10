package com.mdev.transactiondetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mdev.transactiondetails.DatabaseHelper;


public class Activity2 extends AppCompatActivity {

    private EditText editTextTransactionName;
    private EditText editTextTransactionAmount;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        editTextTransactionName = findViewById(R.id.editTextTransactionName);
        editTextTransactionAmount = findViewById(R.id.editTextTransactionAmount);
        EditText transactionDateEditText = findViewById(R.id.transaction_date);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        DatabaseHelper dbHelper = new DatabaseHelper(Activity2.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        buttonSubmit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String transactionName = editTextTransactionName.getText().toString();
                String transactionAmount = editTextTransactionAmount.getText().toString();
                String transactionDate = transactionDateEditText.getText().toString();
                // Do something with the transaction details here


                ContentValues values = new ContentValues();
                values.put("transaction_name", transactionName);
                values.put("transaction_date", transactionDate);
                values.put("amount", transactionAmount);
                long newRowId = db.insert("transactions", null, values);
                boolean result=true;




                if (result) {
                    Toast.makeText(Activity2.this, "Transaction added successfully", Toast.LENGTH_SHORT).show();
                    transactionDateEditText.setText("");
                    editTextTransactionAmount.setText("");
                    editTextTransactionName.setText("");
                } else {
                    Toast.makeText(Activity2.this, "Failed to add transaction", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
