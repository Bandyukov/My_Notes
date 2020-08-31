package com.example.mynotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription;
    private Spinner spinnerDaysOfWeek;
    private RadioGroup radioGroupPriorities;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        editTextDescription = findViewById(R.id.editTextTextMultiLine);
        editTextTitle = findViewById(R.id.editTextTextTitle);
        spinnerDaysOfWeek = findViewById(R.id.spinnerDaysOfWeek);
        radioGroupPriorities = findViewById(R.id.radioGroupPriority);
    }

    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim(),
            description = editTextDescription.getText().toString();
        String dayOfWeek = spinnerDaysOfWeek.getSelectedItem().toString();
        int radioButtonId = radioGroupPriorities.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        int priority = Integer.parseInt(radioButton.getText().toString());

        if (isFilled(title, description)) {
            Note note = new Note(title, description, dayOfWeek, priority);
            viewModel.insetNote(note);
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Toast.makeText(this, R.string.warning1, Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isFilled(String title, String description) {
        return !title.isEmpty() && !description.isEmpty();
    }
}