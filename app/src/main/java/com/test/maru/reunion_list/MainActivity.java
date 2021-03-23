package com.test.maru.reunion_list;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.test.maru.R;
import com.test.maru.fragment.ReuFragment;
import com.test.maru.utils.Utils;


// TODO: attention night theme rend l'app non-lisible. Change les couleur dans res/values/themes (night one)
public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ReuFragment fragmentReunion;

    private Utils mUtils;

    private TextView nameToolbar;
    private ImageView searchIcon;
    private TextInputEditText mTextInputEditText;
    private TextInputLayout mTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: tu peux utiliser ButterKnife ou meiux encore viewBinding: https://developer.android.com/topic/libraries/view-binding#java
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

    // TODO Android peut gerer ca automatiquement: https://developer.android.com/training/search/setup#java https://www.javatpoint.com/android-searchview-on-toolbar
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

                fragmentReunion.search(mTextInputEditText.getText().toString());

            }
        });

    }


    // TODO: plus simple. dans le XML de ton activity tu peux remplacer ton FrameLayout par
    //  <fragment
    //            android:name="com.example.android.FooFragment"
    //           android:id="@+id/fooFragment"
    //           android:layout_width="match_parent"
    //           android:layout_height="match_parent" />
    // ou voir FragmentContainerView https://developer.android.com/guide/fragments/create
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