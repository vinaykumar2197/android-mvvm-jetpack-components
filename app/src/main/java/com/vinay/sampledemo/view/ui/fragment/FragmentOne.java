package com.vinay.sampledemo.view.ui.fragment;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vinay.sampledemo.R;
import com.vinay.sampledemo.databinding.FragmentOneBinding;
import com.vinay.sampledemo.viewmodel.FragmentOneViewModel;

public class FragmentOne extends Fragment {

    private FragmentOneViewModel mViewModel;
    private FragmentOneBinding binding;

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_one, container, false);
        binding = FragmentOneBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentOneViewModel.class);
        // TODO: Use the ViewModel
    }

}