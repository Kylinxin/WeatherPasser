// Generated by view binder compiler. Do not edit!
package com.kylinxin.myweather.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.kylinxin.myweather.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWeatherDetailBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout indicatorLayout;

  @NonNull
  public final ImageView moreLocation;

  @NonNull
  public final ViewPager weatherViewPager;

  private ActivityWeatherDetailBinding(@NonNull RelativeLayout rootView,
      @NonNull LinearLayout indicatorLayout, @NonNull ImageView moreLocation,
      @NonNull ViewPager weatherViewPager) {
    this.rootView = rootView;
    this.indicatorLayout = indicatorLayout;
    this.moreLocation = moreLocation;
    this.weatherViewPager = weatherViewPager;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWeatherDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWeatherDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_weather_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWeatherDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.indicatorLayout;
      LinearLayout indicatorLayout = ViewBindings.findChildViewById(rootView, id);
      if (indicatorLayout == null) {
        break missingId;
      }

      id = R.id.moreLocation;
      ImageView moreLocation = ViewBindings.findChildViewById(rootView, id);
      if (moreLocation == null) {
        break missingId;
      }

      id = R.id.weatherViewPager;
      ViewPager weatherViewPager = ViewBindings.findChildViewById(rootView, id);
      if (weatherViewPager == null) {
        break missingId;
      }

      return new ActivityWeatherDetailBinding((RelativeLayout) rootView, indicatorLayout,
          moreLocation, weatherViewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
