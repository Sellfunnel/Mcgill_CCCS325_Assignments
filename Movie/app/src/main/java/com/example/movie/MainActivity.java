package com.example.movie;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private MoviePagerAdapter moviePagerAdapter;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        moviePagerAdapter = new MoviePagerAdapter(this);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);

        setupViewPager();

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(moviePagerAdapter.getFragmentTitle(position))
        ).attach();
    }

    private void setupViewPager() {
        // Initialize with default genre
        moviePagerAdapter.addFragment(PosterFragment.newInstance("Comedy"), "Poster");
        moviePagerAdapter.addFragment(DescriptionFragment.newInstance("Comedy"), "Description");
        viewPager.setAdapter(moviePagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.genre_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String genre = item.getTitle().toString();
        updateGenre(genre);
        return true;
    }

    private void updateGenre(String genre) {
        moviePagerAdapter.updateFragments(genre);
        viewPager.getAdapter().notifyDataSetChanged();
    }
}
