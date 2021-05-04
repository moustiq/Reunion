package com.test.maru.reunion_list;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
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

import androidx.appcompat.app.AppCompatActivity;

import com.test.maru.R;
import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class AddReunionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final Reunion mReunion = new Reunion();
    private final ArrayList<EditText> arrayEmails = new ArrayList<>();
    private EditText heureEdit;
    private String lieuEdit;
    private EditText sujetEdit;
    private EditText mailEdit;
    private ImageView arrowBack;
    private Button addEmail;
    private EditText editTextEmail;
    private Button creerReunion;
    private int nbMail = 0;
    private LinearLayout addLayout;
    private ReunionApiService mReunionApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        mReunionApiService = DI.getReunionApiService();

        addLayout = findViewById(R.id.layout_mail);

        TextView nameToolbar = findViewById(R.id.toolbar_name);
        arrowBack = findViewById(R.id.toolbar_back);

        nameToolbar.setText(R.string.Add_reunion);
        arrowBack.setVisibility(View.VISIBLE);

        heureEdit = (EditText) findViewById(R.id.heure);
        Spinner salle = (Spinner) findViewById(R.id.spinner_lieu);
        sujetEdit = (EditText) findViewById(R.id.sujet);
        mailEdit = (EditText) findViewById(R.id.mail);

        ImageView searchIcon = findViewById(R.id.toolbar_recherche);

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


        ArrayAdapter<CharSequence> adapter2;
        adapter2 = ArrayAdapter.createFromResource(AddReunionActivity.this,
                R.array.numero_salle,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        salle.setAdapter(adapter2);
        salle.setOnItemSelectedListener(this);

        setCreerReunion();

        setArrowBack();

        addMail();

    }

    private void setCreerReunion() {

        creerReunion.setOnClickListener(v -> {

            if (nbMail == 0) {
                addReunion();

            } else {
                addReunionMail();
            }
            Toast.makeText(AddReunionActivity.this, "reunion ajouté", LENGTH_SHORT).show();
        });
    }

    private void setArrowBack() {

        arrowBack.setOnClickListener(v -> {
            Intent intent = new Intent(AddReunionActivity.this, MainActivity.class);
            startActivity(intent);
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

        addEmail.setOnClickListener(v -> {
            editTextEmail = new EditText(AddReunionActivity.this);
            editTextEmail.setHint("mail");
            editTextEmail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            addLayout.addView(editTextEmail);
            arrayEmails.add(editTextEmail);
            nbMail++;
        });
    }


    private void addReunionMail() {

        for (int i = 0; i < arrayEmails.size(); i++) {

            mReunion.getMails().add(String.format("%s - %s", mailEdit.getText().toString(), arrayEmails.get(i).getText().toString()));
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