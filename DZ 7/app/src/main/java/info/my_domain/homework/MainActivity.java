package info.my_domain.homework;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import info.my_domain.homework.R;

public class MainActivity extends AppCompatActivity {


    private FragmentManager fm;
    public int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.fragment_vertical);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.addMenu:
                goToAddUserActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToAddUserActivity(){
        FragmentTransaction local = fm.beginTransaction();
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            local.replace(R.id.list_and_edit, new AddRecordFragment());
            local.commit();
        } else {
            local.replace(R.id.showingEditorPerson, new AddRecordFragment());
            local.commit();
        }

    }

}
