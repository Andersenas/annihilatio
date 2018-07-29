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

public class UpdateRecordFragment extends Fragment {

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mCountryEditText;
    private EditText mImageEditText;
    private Button mUpdateBtn;

    private PersonDBHelper dbHelper;
    private long receivedPersonId;
    private MainActivity context;
    public int orientation;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  MainActivity) {
            this.context = (MainActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_update_record, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orientation = this.getResources().getConfiguration().orientation;


        Bundle bundle = new Bundle();
        //init
        mNameEditText = view.findViewById(R.id.userNameUpdate);
        mAgeEditText = view.findViewById(R.id.userAgeUpdate);
        mCountryEditText = view.findViewById(R.id.userCountryUpdate);
        mImageEditText = view.findViewById(R.id.userProfileImageLinkUpdate);
        mUpdateBtn = view.findViewById(R.id.updateUserButton);

        dbHelper = new PersonDBHelper(context);

        try {

            //get intent to get person id
                bundle = getArguments();
                receivedPersonId = bundle.getLong("USER_ID");

        } catch (Exception e) {
            e.printStackTrace();
        }

        /***populate user data before update***/
        Person queriedPerson = dbHelper.getPerson(receivedPersonId);
        //set field to this user data
        mNameEditText.setText(queriedPerson.getName());
        mAgeEditText.setText(queriedPerson.getAge());
        mCountryEditText.setText(queriedPerson.getCountry());
        mImageEditText.setText(queriedPerson.getImage());



        //listen to add button click to update
        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                updatePerson();
            }
        });

    }

    private void updatePerson(){
        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String country = mCountryEditText.getText().toString().trim();
        String image = mImageEditText.getText().toString().trim();

        //create updated person
        Person updatedPerson = new Person(name, age, country, image);

        //call dbhelper update
        dbHelper.updatePersonRecord(receivedPersonId, context, updatedPerson);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }

    private void goBackHome(){
        context.finish();
    }
}
