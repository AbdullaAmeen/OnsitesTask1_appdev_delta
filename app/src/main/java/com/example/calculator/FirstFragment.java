package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calculator.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    final static  int SELECTED_FIRST = 0, SELECTED_SECOND = 1;

    private int selected = SELECTED_FIRST;
    private FragmentFirstBinding binding;
    private ViewViewModel viewViewModel;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        viewViewModel= new ViewModelProvider(requireActivity()).get(ViewViewModel.class);
        binding = FragmentFirstBinding.inflate(inflater, container, false);


        ButtonInitialize();


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
    private void switchSelection(){
        Log.v("switch", "switch");
        selected = selected==SELECTED_FIRST?SELECTED_SECOND:SELECTED_FIRST;
    }

    private void ButtonInitialize(){

        View.OnClickListener normalBtCLickListener = v -> {

            Button normalButton = (Button) v;
            Log.v("button pressed", normalButton.getText().toString());

            if(selected == SELECTED_FIRST){
                String s = viewViewModel.getNum1().getValue();
                if(s.length() < 16)
                    viewViewModel.getNum1().setValue(s+normalButton.getText().toString());
                else
                    Toast.makeText(getActivity(), "Max Length",Toast.LENGTH_SHORT).show();
            }
            else {
                String s = viewViewModel.getNum2().getValue();
                if(s.length() < 16)
                    viewViewModel.getNum2().setValue(s + normalButton.getText().toString());
                else
                    Toast.makeText(getActivity(), "Max Length",Toast.LENGTH_SHORT).show();

            }
        };
        View.OnClickListener specialClickListener = v -> {
            Button normalButton = (Button) v;
            String s1 = viewViewModel.getNum1().getValue();
            String s2 = viewViewModel.getNum2().getValue();
            Log.v("button pressed", normalButton.getText().toString());
            if(normalButton.getText().toString().equals("Next Number")) {
                switchSelection();
                if(selected == SELECTED_FIRST)
                    viewViewModel.getOperator().setValue('0');
                else
                    viewViewModel.getOperator().setValue('1');
            }

            else if(normalButton.getText().toString().equals("Back Space") ) {

                if (selected == SELECTED_FIRST && !s1.equals(""))
                    viewViewModel.getNum1().setValue(s1.substring(0, s1.length() - 1));
                else if (!s2.equals(""))
                    viewViewModel.getNum2().setValue(s2.substring(0, s2.length() - 1));}

            else if (normalButton.getText().toString().equals("CLEAR")) {
                    viewViewModel.getNum1().setValue("");
                     viewViewModel.getNum2().setValue("");
                }
            else if(normalButton.getText().toString().equals("Back Space") ) {

                if (selected == SELECTED_FIRST && !s1.equals(""))
                    viewViewModel.getNum1().setValue(s1.substring(0, s1.length() - 1));
                else if (!s2.equals(""))
                    viewViewModel.getNum2().setValue(s2.substring(0, s2.length() - 1));}

            else if (normalButton.getText().toString().equals("CLEAR CELL")) {
                if (selected == SELECTED_FIRST && !s1.equals(""))
                    viewViewModel.getNum1().setValue("");
                else if (!s2.equals(""))
                    viewViewModel.getNum2().setValue("");
            }

        };
        View.OnClickListener operatorClickListener = v -> {
            Button normalButton = (Button) v;
            viewViewModel.getOperator().setValue(normalButton.getText().charAt(0));
            switchSelection();

        };

        this.binding.bt0.setOnClickListener(normalBtCLickListener);
        this.binding.bt1.setOnClickListener(normalBtCLickListener);
        this.binding.bt2.setOnClickListener(normalBtCLickListener);
        this.binding.bt3.setOnClickListener(normalBtCLickListener);
        this.binding.bt4.setOnClickListener(normalBtCLickListener);
        this.binding.bt5.setOnClickListener(normalBtCLickListener);
        this.binding.bt6.setOnClickListener(normalBtCLickListener);
        this.binding.bt7.setOnClickListener(normalBtCLickListener);
        this.binding.bt8.setOnClickListener(normalBtCLickListener);
        this.binding.bt9.setOnClickListener(normalBtCLickListener);
        this.binding.btAdd.setOnClickListener(operatorClickListener);
        this.binding.btDivide.setOnClickListener(operatorClickListener);
        this.binding.btMultiply.setOnClickListener(operatorClickListener);
        this.binding.btSubtract.setOnClickListener(operatorClickListener);
        this.binding.btCompute.setOnClickListener(operatorClickListener);
        this.binding.btBackSpace.setOnClickListener(specialClickListener);
        this.binding.btNextNum.setOnClickListener(specialClickListener);
        this.binding.btClearCell.setOnClickListener(specialClickListener);
        this.binding.btClearall.setOnClickListener(specialClickListener);

    }


}