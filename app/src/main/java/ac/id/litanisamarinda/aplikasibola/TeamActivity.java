package ac.id.litanisamarinda.aplikasibola;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class TeamActivity extends AppCompatActivity {

    private static final String SELECTED_MENU = "selected menu";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment =null;

            if(item.getItemId()==R.id.navigation_last) {
                fragment = FragmentLastMatch.newIntance();
            }else if(item.getItemId()==R.id.navigation_next){
                fragment = FragmentNextMatch.newIntance();
            }else if(item.getItemId()==R.id.navigation_favorite){
                fragment = FragmentFavoriteMatch.newIntance();
            }

            if(fragment!=null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else{
            navView.setSelectedItemId(R.id.navigation_last);
        }
            
    }

}
