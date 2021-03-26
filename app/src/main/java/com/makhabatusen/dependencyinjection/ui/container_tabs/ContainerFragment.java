package com.makhabatusen.dependencyinjection.ui.container_tabs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayoutMediator;
import com.makhabatusen.dependencyinjection.R;
import com.makhabatusen.dependencyinjection.databinding.FragmentContainerBinding;
import com.makhabatusen.dependencyinjection.ui.base.BaseFragment;
import com.makhabatusen.dependencyinjection.ui.favorites.FavoritesFragment;
import com.makhabatusen.dependencyinjection.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class ContainerFragment extends BaseFragment<FragmentContainerBinding> {
    private final List<Integer> titleList = new ArrayList<>();
    private final List<Integer> iconList = new ArrayList<>();


    @Override
    protected FragmentContainerBinding bind() {
        return FragmentContainerBinding.inflate(getLayoutInflater());

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleList.addAll(List.of(R.string.home, R.string.favorites));
        iconList.addAll(List.of(R.drawable.ic_home, R.drawable.ic_favorite));

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);


        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new FavoritesFragment());

        ui.viewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(ui.tabLayout, ui.viewPager, (tab, position) -> {
            tab.setText(titleList.get(position));
            tab.setIcon(iconList.get(position));
        }).attach();

    }

}
