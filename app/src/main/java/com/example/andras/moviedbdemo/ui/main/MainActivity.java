package com.example.andras.moviedbdemo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.databinding.ActivityMovieListBinding;
import com.example.andras.moviedbdemo.di.MoviesComponent;
import com.example.andras.moviedbdemo.ui.common.SearchViewWrapper;

import java.util.List;

import javax.inject.Inject;

//9 pomodoros
public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainViewModel model;

    private MainAdapter adapter;
    private SearchViewWrapper searchView;
    private MainContentView moviesContent;
    private MainContentView tvShowContent;
    private ActivityMovieListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MoviesComponent.Get.component(this).inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list);
        adapter = new MainAdapter();
        setSupportActionBar(binding.toolbar);
        moviesContent = new MainContentView(this, adapter);
        tvShowContent = new MainContentView(this, adapter);

        binding.viewPager.setAdapter(new PagerAdapter(new MainContentView[]{moviesContent, moviesContent, tvShowContent} ));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        model.setView(this);
    }

    @Override
    public void addItems(List<MainListItemViewModel> movies) {
        adapter.addItems(movies);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        searchView = new SearchViewWrapper(this, menu);
        searchView.setCallback(this::onSearchViewTextChanged);
        return true;
    }

    private void onSearchViewTextChanged(String expression) {
    }

    private class PagerAdapter extends android.support.v4.view.PagerAdapter {

        private final String[] titles;
        private final MainContentView[] pages;

        PagerAdapter(MainContentView[] pages) {
            titles = getResources().getStringArray(R.array.main_tab_titles);
            this.pages = pages;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            binding.viewPager.addView(pages[position]);
            return pages[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object view) {
            container.removeView((View) view);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
