package com.example.calculator;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class ViewViewModel extends ViewModel {
    private MutableLiveData<Integer> num1;
    private MutableLiveData<Integer> num2;
    private MutableLiveData<Character> operator;
    public ViewViewModel() {
        num1 = new MutableLiveData<>();
        num1.setValue(0);
        num2 = new MutableLiveData<>();
        num2.setValue(0);
        operator = new MutableLiveData<>();
        operator.setValue('\0');

    }

    public MutableLiveData<Integer> getNum1() {
        return num1;
    }

    public MutableLiveData<Integer> getNum2() {
        return num2;
    }

    public MutableLiveData<Character> getOperator(LifecycleOwner viewLifecycleOwner, Observer<Character> observer) {
        return operator;
    }
}
