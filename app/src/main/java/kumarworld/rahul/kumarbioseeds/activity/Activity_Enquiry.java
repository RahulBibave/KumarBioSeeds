package kumarworld.rahul.kumarbioseeds.activity;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import kumarworld.rahul.kumarbioseeds.R;
import kumarworld.rahul.kumarbioseeds.fragment.fragment_Ask_Quation;
import kumarworld.rahul.kumarbioseeds.fragment.fragment_Enquiry;

public class Activity_Enquiry extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioEnquiry,radioAsk;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup1);
        radioEnquiry=(RadioButton)findViewById(R.id.radioMap);
        radioAsk=(RadioButton)findViewById(R.id.radioList);
        replaceFragment(new fragment_Enquiry());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                switch (checkedId){
                    case R.id.radioMap:
                        replaceFragment(new fragment_Enquiry());
                        break;

                    case R.id.radioList:
                        replaceFragment(new fragment_Ask_Quation());
                        break;

                }

            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.Container, fragment, fragment.getTag());
        transaction.commit();
    }

}
