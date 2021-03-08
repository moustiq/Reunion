package com.test.maru.reunion_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.maru.R;
import com.test.maru.api.ReunionApi;
import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;

import butterknife.BindView;
import butterknife.OnClick;

import static android.widget.Toast.LENGTH_SHORT;

public class AddReunionActivity extends AppCompatActivity {

    private EditText heureEdit;
    private  EditText lieuEdit;
    private EditText sujetEdit;
    private EditText mailEdit;

    private TextView nameToolbar;
    private ImageView searchIcon;
    private ImageView arrowBack;

    private Button creerReunion;

    private ReunionApiService mReunionApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        mReunionApiService = DI.getReunionApiService();

        nameToolbar = findViewById(R.id.toolbar_name);
        arrowBack = findViewById(R.id.toolbar_back);

        nameToolbar.setText("Add réunion");
        arrowBack.setVisibility(View.VISIBLE);

        heureEdit = (EditText) findViewById(R.id.heure);
        lieuEdit = (EditText) findViewById(R.id.lieu);
        sujetEdit = (EditText) findViewById(R.id.sujet);
        mailEdit = (EditText) findViewById(R.id.mail);

        searchIcon = findViewById(R.id.toolbar_recherche);

        searchIcon.setVisibility(View.GONE);

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

        setCreerReunion ();

        setArrowBack();

    }

    public void setCreerReunion () {
        creerReunion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addReunion();
                Toast.makeText(AddReunionActivity.this, "reunion ajouté", LENGTH_SHORT).show();

            }
        });
    }

    public void setArrowBack() {
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddReunionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addReunion() {
        Reunion reunion = new Reunion(
                heureEdit.getText().toString(),
                lieuEdit.getText().toString(),
                sujetEdit.getText().toString(),
                mailEdit.getText().toString()
        );
        mReunionApiService.createReunion(reunion);
        finish();
    }

}