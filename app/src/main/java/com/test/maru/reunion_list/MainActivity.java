package com.test.maru.reunion_list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.test.maru.R;
import com.test.maru.fragment.ReuFragment;
import com.test.maru.model.Reunion;
import com.test.maru.utils.Utils;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ReuFragment fragmentReunion;

    private TextView nameToolbar;
    private ImageView searchIcon;
    private TextInputEditText mTextInputEditText;
    private TextInputLayout mTextInputLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameToolbar = findViewById(R.id.toolbar_name);
        searchIcon = findViewById(R.id.toolbar_recherche);
        mTextInputEditText = findViewById(R.id.search_edit);
        mTextInputLayout = findViewById(R.id.search_layout);


        nameToolbar.setText("Réunion");

        fragmentManager = getSupportFragmentManager();

        fragmentReunion = new ReuFragment();

        changeFragment(fragmentReunion, fragmentReunion.TAG);

        setListner();

    }

    private void setListner() {

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTextInputLayout.getVisibility() == View.INVISIBLE) {
                    mTextInputLayout.setVisibility(View.VISIBLE);
                    //return;

                } else if (mTextInputLayout.getVisibility() == View.VISIBLE) {
                    mTextInputLayout.setVisibility(View.INVISIBLE);
                }

                Utils.search(mTextInputEditText.getText().toString());
                fragmentReunion.filter();
            }
        });

    }


    private void changeFragment(Fragment fragment, String tag) {
        // commencer a definir une 'changement', une 'transaction'
        FragmentTransaction trans = fragmentManager.beginTransaction();
        // quoi remplacer et ou
        trans.replace(R.id.mainFrame, fragment, tag);
        //trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // commencer la transaction
        trans.commit();

        updateToolbar(tag);
    }

    private void updateToolbar(String tag) {

        searchIcon.setVisibility(View.INVISIBLE);
        mTextInputLayout.setVisibility(View.INVISIBLE);

        switch (tag) {
            case ReuFragment.TAG:
                searchIcon.setVisibility(View.VISIBLE);
                return;
        }

    }

}