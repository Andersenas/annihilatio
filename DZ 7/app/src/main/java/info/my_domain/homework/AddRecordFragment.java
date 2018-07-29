package info.my_domain.homework;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import info.my_domain.homework.R;
import info.my_domain.homework.Utils.PersonDBHelper;
import info.my_domain.homework.model.Person;

public class AddRecordFragment extends Fragment {

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mCountryEditText;
    private EditText mImageEditText;
    private Button mAddBtn;

    private PersonDBHelper dbHelper;
    private MainActivity context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  MainActivity) {
            this.context = (MainActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_add_record, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //init
        mNameEditText = view.findViewById(R.id.userName);
        mAgeEditText = view.findViewById(R.id.userAge);
        mCountryEditText = view.findViewById(R.id.userCountry);
        mImageEditText = view.findViewById(R.id.userProfileImageLink);
        mAddBtn = view.findViewById(R.id.addNewUserButton);

        //listen to add button click
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                savePerson();
            }
        });
    }

    private void savePerson(){
        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String country = mCountryEditText.getText().toString().trim();
        String image = mImageEditText.getText().toString().trim();
        dbHelper = new PersonDBHelper(context);

        //create new person
        Person person = new Person(name, age, country, image);
        dbHelper.saveNewPerson(person);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }

    private void goBackHome(){
        context.finish();

    }
}
