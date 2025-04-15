package com.example.application28.Activity;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.application28.R;

import java.util.Calendar;

public class LoansActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editTextDateFrom;
    private ImageView imageViewCalendarFrom;
    private EditText editTextDateTo;
    private ImageView imageViewCalendarTo;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loans);

        // Initialize all views using findViewById
        toolbar = findViewById(R.id.toolbar);
        editTextDateFrom = findViewById(R.id.editTextDateFrom);
        //imageViewCalendarFrom = findViewById(R.id.imageViewCalendarFrom);
        editTextDateTo = findViewById(R.id.editTextDateTo);
        //imageViewCalendarTo = findViewById(R.id.imageViewCalendarTo);
        //listView = findViewById(R.id.listView);

        // Set up the toolbar as the action bar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button
            getSupportActionBar().setTitle("Loans"); // Set title
        }

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        // Example: Set click listeners for the calendar icons
//        imageViewCalendarFrom.setOnClickListener(v -> {
//            // Handle "From Date" calendar icon click
//        });
//
//        imageViewCalendarTo.setOnClickListener(v -> {
//            // Handle "To Date" calendar icon click
//        });

        imageViewCalendarFrom.setOnClickListener(v -> {
            // Open a date picker dialog for "From Date"
            showDatePickerDialog(editTextDateFrom);
        });

        imageViewCalendarTo.setOnClickListener(v -> {
            // Open a date picker dialog for "To Date"
            showDatePickerDialog(editTextDateTo);
        });


    }
    private void showDatePickerDialog(EditText editText) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    editText.setText(selectedDate);
                },
                year, month, day
        );
        datePickerDialog.show();
    }
}