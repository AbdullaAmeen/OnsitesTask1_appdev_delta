package com.example.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.calculator.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private Long int1, int2;
    private Character op;
    TextView tv_result;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        ViewViewModel viewViewModel = new ViewModelProvider(requireActivity()).get(ViewViewModel.class);
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        TextView tv_num1 = binding.textViewNum1;
        TextView tv_num2 = binding.textViewNum2;
        TextView tv_op = binding.textViewOp;
        tv_result = binding.tvResult;


        viewViewModel.getNum1().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String string) {
                tv_num1.setText(string.toString());
                if(!string.equals(""))
                int1 = Long.parseLong(string);
                else
                    tv_result.setText("");
            }

        });
        viewViewModel.getNum2().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String integer) {

                tv_num2.setText(integer.toString());
                if(!integer.equals(""))
                int2 = Long.parseLong(integer);
                else
                    tv_result.setText("");
            }
        });
        viewViewModel.getOperator().observe(getViewLifecycleOwner(),new Observer<Character>(){
            @Override
            public void onChanged(Character character) {
                if (tv_op != null)


                    if (character == '=' && op != null && int1 != null && int2 != null) {
                        compute();
                        tv_num1.setBackgroundColor(Color.parseColor("#8b0000"));
                        tv_num2.setBackgroundColor(Color.parseColor("#006400"));

                    }
                    else if( character =='0'){
                        tv_num1.setBackgroundColor(Color.parseColor("#8b0000"));
                        tv_num2.setBackgroundColor(Color.parseColor("#006400"));
                    }
                    else if( character =='1'){
                        tv_num2.setBackgroundColor(Color.parseColor("#8b0000"));
                        tv_num1.setBackgroundColor(Color.parseColor("#006400"));
                    }
                    else if(character != '=' ){
                        op = character;

                        tv_op.setText(character.toString());
                        if(character != '\0') {
                            tv_num2.setBackgroundColor(Color.parseColor("#8b0000"));
                            tv_num1.setBackgroundColor(Color.parseColor("#006400"));
                        }
                    }
            }
        });
        return binding.getRoot();

    }

    private void compute() {
        switch (op){
            case '+':
                tv_result.setText(""+(int1 + int2));
            break;
            case '-':
                tv_result.setText(""+(int1 - int2));
                break;
            case 'x':
                tv_result.setText(""+(int1 * int2));
                break;
            case '/':
                if(int2 != 0)
                    tv_result.setText(""+(int1 / int2));
                else Toast.makeText(getContext(),"DIVISION BY 0 ERROR", Toast.LENGTH_SHORT).show();
                break;
        }
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