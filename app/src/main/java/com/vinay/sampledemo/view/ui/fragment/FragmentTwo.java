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
import com.vinay.sampledemo.databinding.FragmentTwoBinding;
import com.vinay.sampledemo.viewmodel.FragmentTwoViewModel;

public class FragmentTwo extends Fragment {

    private FragmentTwoViewModel mViewModel;
    private FragmentTwoBinding binding;

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_two, container, false);
        binding = FragmentTwoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentTwoViewModel.class);
        // TODO: Use the ViewModel
    }

}