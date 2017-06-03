package com.example.andras.moviedbdemo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.databinding.ActivityMainBinding;
import com.example.andras.moviedbdemo.di.MainComponent;
import com.example.andras.moviedbdemo.searcher.SearcherImpl;
import com.example.andras.moviedbdemo.ui.common.Navigator;
import com.example.andras.moviedbdemo.ui.common.SearchViewWrapper;
import com.example.andras.moviedbdemo.ui.main.content.MainContentViewImpl;
import com.example.andras.moviedbdemo.ui.main.content.MainContentViewModel;

import java.util.List;

import javax.inject.Inject;

//28 pomodoros
public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainViewModel model;
    @Inject
    Navigator navigator;

    private ActivityMainBinding binding;
    private MainContentViewModel moviesViewModel;
    private MainContentViewModel tvShowsViewModel;
    private MainContentViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainComponent.Get.component(this).inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        MainContentViewImpl moviesView = new MainContentViewImpl(this);
        moviesViewModel = new MainContentViewModel(moviesView, new SearcherImpl<>(), navigator);
        MainContentViewImpl tvShowView = new MainContentViewImpl(this);
        tvShowsViewModel = new MainContentViewModel(tvShowView, new SearcherImpl<>(), navigator);
        MainContentViewImpl peopleView = new MainContentViewImpl(this);
        peopleViewModel = new MainContentViewModel(peopleView, new SearcherImpl<>(), navigator);

        binding.viewPager.setAdapter(new PagerAdapter(new MainContentViewImpl[]{moviesView, peopleView, tvShowView} ));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        model.setView(this);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error loading data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setMovieItems(List<MainListItemDto> movies) {
        moviesViewModel.setItems(movies);
    }

    @Override
    public void setTvItems(List<MainListItemDto> tvShows) {
        tvShowsViewModel.setItems(tvShows);
    }

    @Override
    public void setPersonItems(List<MainListItemDto> people) {
        peopleViewModel.setItems(people);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchViewWrapper searchView = new SearchViewWrapper(this, menu);
        searchView.setCallback(this::onSearchViewTextChanged);
        return true;
    }

    private void onSearchViewTextChanged(String expression) {
        moviesViewModel.search(expression);
        tvShowsViewModel.search(expression);
    }

    private class PagerAdapter extends android.support.v4.view.PagerAdapter {

        private final String[] titles;
        private final MainContentViewImpl[] pages;

        PagerAdapter(MainContentViewImpl[] pages) {
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
