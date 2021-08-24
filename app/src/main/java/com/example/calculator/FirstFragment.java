package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calculator.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ViewViewModel viewViewModel;
    Button bt0;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        viewViewModel= new ViewModelProvider(requireActivity()).get(ViewViewModel.class);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View.OnClickListener normalBtCLickListener = v -> {

            Button normalButton = (Button) v;
            Log.v("button pressed", normalButton.getText().toString());
            viewViewModel.getLiveData().setValue(viewViewModel.getLiveData().getValue().concat(normalButton.getText().toString()));
        };
        Button bt0 = binding.bt0;
        binding.bt.setOnClickListener(normalBtCLickListener);
        bt0.setOnClickListener(normalBtCLickListener);
        binding.bt1.setOnClickListener(normalBtCLickListener);
        binding.bt2.setOnClickListener(normalBtCLickListener);
        binding.bt3.setOnClickListener(normalBtCLickListener);
        binding.bt4.setOnClickListener(normalBtCLickListener);
        binding.bt5.setOnClickListener(normalBtCLickListener);
        binding.bt6.setOnClickListener(normalBtCLickListener);
        binding.bt7.setOnClickListener(normalBtCLickListener);
        binding.bt8.setOnClickListener(normalBtCLickListener);
        binding.bt9.setOnClickListener(normalBtCLickListener);
        binding.btAdd.setOnClickListener(normalBtCLickListener);
        binding.btBracketclose.setOnClickListener(normalBtCLickListener);
        binding.btBracketopen.setOnClickListener(normalBtCLickListener);
        binding.btDivide.setOnClickListener(normalBtCLickListener);
        binding.btMultiply.setOnClickListener(normalBtCLickListener);
        binding.btSubtract.setOnClickListener(normalBtCLickListener);




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


    private void ButtonInitialize(){

    }


}