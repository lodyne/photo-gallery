package com.example.photogallery;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    PhotoAdapter photoAdapter;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Photo Gallery");

        tabLayout = findViewById(R.id.tabLayout1);

        photoAdapter = new PhotoAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        photoAdapter.addFragment(new PhotoFragment());
        photoAdapter.addFragment(new FavouriteFragment());
        photoAdapter.addFragment(new ArchivedFragment());

        viewPager2 = findViewById(R.id.viewPager);


        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        viewPager2.setAdapter(photoAdapter);

        new TabLayoutMediator(
                tabLayout,
                viewPager2,
                (tab, i) -> {
//                    if (i == 0){
//                        tab.setText("All");
//                    } else if (i==1) {
//                        tab.setText("Favourites");
//                    } else if (i==2) {
//                        tab.setText("Archived");
//                    }

                    switch (i) {
                        case 0:
                            tab.setText("All");
                            break;
                        case 1:
                            tab.setText("Favourites");
                            break;
                        case 2:
                            tab.setText("Archived");
                            break;
                        // Add more cases as needed
                        default:
                            // Handle default case if needed
                            break;
                    }

                }

        ).attach();



//        Fragment fragment = new PhotoFragment();
//        loadFragment(fragment);
    }

//    public void loadFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_layout,fragment);
//        fragmentTransaction.commit();
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_camera){
            Toast.makeText(this, "Camera is clicked", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.nav_camera) {
            Toast.makeText(this, "Enter to search", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}