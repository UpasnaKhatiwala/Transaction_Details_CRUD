package com.mdev.transactiondetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    private EditText editTextTransactionName;
    private EditText editTextTransactionAmount;
    private EditText editTextTransactAmount;
    private Button buttonSearch;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        editTextTransactionName = findViewById(R.id.editTextTransactionName);
        editTextTransactionAmount = findViewById(R.id.editTextTransactionAmount);
        EditText transactionDateEditText = findViewById(R.id.transaction_date);
        buttonSearch = findViewById(R.id.buttonSearch);


        editTextTransactAmount = findViewById(R.id.editTextTransactAmount);
        EditText transactDateEditText = findViewById(R.id.transact_date);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String transactionName = editTextTransactionName.getText().toString();
                String transactionAmount = editTextTransactionAmount.getText().toString();
                String transactionDate = transactionDateEditText.getText().toString();
                // Do something with the transaction details here
            }
        });
    }
}
