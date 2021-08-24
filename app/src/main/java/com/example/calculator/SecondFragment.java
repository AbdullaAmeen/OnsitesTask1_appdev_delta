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
    private Integer int1, int2;
    private Character op;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        viewViewModel = new ViewModelProvider(requireActivity()).get(ViewViewModel.class);
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        TextView tv_num1 = binding.textViewNum1;
        TextView tv_num2 = binding.textViewNum2;
        TextView tv_op = binding.textViewOp;


        viewViewModel.getNum1().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tv_num1.setText(integer.toString());
                int1 = integer;

            }
        });
        viewViewModel.getNum2().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tv_num2.setText(integer.toString());
                int2 = integer;
            }
        });
        viewViewModel.getOperator(getViewLifecycleOwner(),new Observer<Character>(){
            @Override
            public void onChanged(Character character) {
                tv_op.setText(character);

                if(character == '=' && op!= null && int1 !=null && int2 != null )
                    compute();
                else
                    op = character;
            }
        });
        return binding.getRoot();

    }

    private void compute() {

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