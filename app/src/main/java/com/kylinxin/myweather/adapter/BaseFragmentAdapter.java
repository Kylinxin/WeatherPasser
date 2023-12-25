package com.kylinxin.myweather.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class BaseFragmentAdapter extends PagerAdapter {
    private List<View> views;
    private List<String> titles;

   public BaseFragmentAdapter(List<View> views,List<String> titles){
       this.views = views;
       this.titles = titles;
   }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView( views.get( position ) );
        return views.get( position );
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( views.get( position ) );
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get( position );
    }

}
