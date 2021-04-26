package com.test.maru.reunion_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.test.maru.R;
import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class AddReunionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Reunion mReunion = new Reunion();
    private ImageView avatar;
    private EditText heureEdit;
    private String lieuEdit;

    private Spinner salle;

    private EditText sujetEdit;
    private EditText mailEdit;

    private TextView nameToolbar;
    private ImageView searchIcon;
    private ImageView arrowBack;

    private Button addEmail;
    private EditText editTextEmail;
    private Button creerReunion;

    private int nbMail = 0;

    private LinearLayout addLayout;

    private ReunionApiService mReunionApiService;

    private ArrayList<EditText> m = new ArrayList<EditText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        mReunionApiService = DI.getReunionApiService();

        addLayout = findViewById(R.id.layout_mail);

        nameToolbar = findViewById(R.id.toolbar_name);
        arrowBack = findViewById(R.id.toolbar_back);

        nameToolbar.setText(R.string.Add_reunion);
        arrowBack.setVisibility(View.VISIBLE);

        avatar = findViewById(R.id.reunion_avatar);
        heureEdit = (EditText) findViewById(R.id.heure);
        salle = (Spinner) findViewById(R.id.spinner_lieu);
        sujetEdit = (EditText) findViewById(R.id.sujet);
        mailEdit = (EditText) findViewById(R.id.mail);

        searchIcon = findViewById(R.id.toolbar_recherche);

        searchIcon.setVisibility(View.GONE);

        addEmail = findViewById(R.id.btn_add_mail);

        creerReunion = findViewById(R.id.creer);
        creerReunion.setEnabled(false);

        mailEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                creerReunion.setEnabled(s.toString().length() != 0);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(AddReunionActivity.this, R.array.numero_salle, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        salle.setAdapter(adapter2);
        salle.setOnItemSelectedListener(this);

        setCreerReunion();

        setArrowBack();

        addMail();

    }

    private void setCreerReunion () {

        creerReunion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nbMail == 0) {
                    addReunion();

                } else {
                    addReunionMail();
                }
                Toast.makeText(AddReunionActivity.this, "reunion ajouté", LENGTH_SHORT).show();
            }
        });
    }

    private void setArrowBack() {

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddReunionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        lieuEdit = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void addMail() {

        addEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail = new EditText(AddReunionActivity.this);
                editTextEmail.setHint("mail");
                addLayout.addView(editTextEmail);
                m.add(editTextEmail);
                nbMail++;
            }
        });
    }


    private void addReunionMail() {

        for (int i = 0; i < m.size(); i++) {

            mReunion.getMails().add(String.format("%s - %s", mailEdit.getText().toString() , m.get(i).getText().toString()));
            mReunion.setHeure(heureEdit.getText().toString());
            mReunion.setLieu(lieuEdit);
            mReunion.setSujet(sujetEdit.getText().toString());
        }
        mReunionApiService.createReunion(mReunion);

    }

    private void addReunion() {

        mReunion.getMails().add(mailEdit.getText().toString());
        mReunion.setHeure(heureEdit.getText().toString());
        mReunion.setLieu(lieuEdit);
        mReunion.setSujet(sujetEdit.getText().toString());

        mReunionApiService.createReunion(mReunion);
    }
    

}