package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    TextView textView;
    ImageView imageView_location;
    DrawerLayout drawer;
    private static final int RC_SIGN_IN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoginUi();
        setContentView(R.layout.side_navigation);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.view_pager1);
        textView = findViewById(R.id.title_main_page);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_Home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_navigation:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_Favorite:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_profile:
                        viewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        textView.setText(R.string.Home);
                        bottomNavigationView.setSelectedItemId(R.id.action_Home);
                        break;
                    case 1:
                        textView.setText(R.string.Notifications);
                        bottomNavigationView.setSelectedItemId(R.id.action_navigation);
                        break;
                    case 2:
                        textView.setText(R.string.Favorite);
                        bottomNavigationView.setSelectedItemId(R.id.action_Favorite);
                        break;
                    case 3:
                        textView.setText(R.string.profile);
                        bottomNavigationView.setSelectedItemId(R.id.action_profile);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.requests:
                startActivity(new Intent(MainActivity.this, RequestsActivity.class));
                break;
            case R.id.restaurant:
                startActivity(new Intent(MainActivity.this, ResturantActivity.class));
                break;
            case R.id.about_us:
                startActivity(new Intent(MainActivity.this, AboutUs.class));
                break;
            case R.id.call_us:
                startActivity(new Intent(MainActivity.this, CallUsActivity.class));
                break;
            case R.id.setting:
                break;
            case R.id.exit:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                recreate();
                            }
                        });
                break;
        }

        return true;
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new homeFragment();
                case 1:
                    return new notifacationFragment();
                case 2:
                    return new forvretFragment();
                case 3:
                    return new profielFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    private void showLoginUi() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build(),
                    new AuthUI.IdpConfig.FacebookBuilder().build(),
                    new AuthUI.IdpConfig.AnonymousBuilder().build()
            );
            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder().setIsSmartLockEnabled(false).setAvailableProviders(providers).build(),
                    RC_SIGN_IN
            );
        }
    }


}
