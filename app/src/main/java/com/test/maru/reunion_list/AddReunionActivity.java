package com.test.maru.reunion_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.test.maru.R;

import butterknife.BindView;

public class AddReunionActivity extends AppCompatActivity {

    @BindView(R.id.heure)
    EditText heure;
    @BindView(R.id.lieu)
    EditText lieu;
    @BindView(R.id.sujet)
    EditText sujet;
    @BindView(R.id.mail)
    EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
    }

}