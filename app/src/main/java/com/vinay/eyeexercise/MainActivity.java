package com.vinay.eyeexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private String TAG ="mainActivitye";
    final Fragment fragment1 = new FirstFragment();
    final Fragment fragment2 = new SecondFragment();
    final Fragment fragment3 = new ThirdFragment();
    final Fragment fragment4 = new FourFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.exercise);
        navigation.setOnNavigationItemSelectedListener(navListener);

        fm.beginTransaction().add(R.id.main_container, fragment4, "2").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();
    }
   private void startAllExercises(){
        Log.d(TAG , "startAllExercises ");
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.exercise:
                            fm.beginTransaction().hide(active).show(fragment1).commit();
                            Log.d("click", "person is clicked");
                            // Toast.makeText(new MainActivity(), "This is my Toast message!", Toast.LENGTH_LONG).show();
                            active = fragment1;
                            return true;

                        case R.id.health_tips:
                            fm.beginTransaction().hide(active).show(fragment2).commit();
                            active = fragment2;
                            return true;

                        case R.id.progress:
                            fm.beginTransaction().hide(active).show(fragment3).commit();
                            active = fragment3;
                            return true;

                        case R.id.setting:
                            fm.beginTransaction().hide(active).show(fragment4).commit();
                            active = fragment4;
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //  getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

//        if (id == R.id.action_settings) {
//            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


}