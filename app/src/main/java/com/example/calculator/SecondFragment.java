package com.example.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.calculator.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private ViewViewModel viewViewModel;
    private FragmentSecondBinding binding;
    private String input="";
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        viewViewModel = new ViewModelProvider(requireActivity()).get(ViewViewModel.class);
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        TextView tv_output = binding.textviewSecond;
        TextView tv_result = binding.textviewResult;

        viewViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_output.setText(s);
                input = s;

                if(s.endsWith("=")){

                }
            }
        });
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}