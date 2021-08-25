package com.example.calculator;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class ViewViewModel extends ViewModel {
    private MutableLiveData<String> num1;
    private MutableLiveData<String> num2;
    private MutableLiveData<Character> operator;
    public ViewViewModel() {
        num1 = new MutableLiveData<>();
        num1.setValue("");
        num2 = new MutableLiveData<>();
        num2.setValue("");
        operator = new MutableLiveData<>();
        operator.setValue('\0');

    }

    public MutableLiveData<String> getNum1() {
        return num1;
    }

    public MutableLiveData<String> getNum2() {
        return num2;
    }

    public MutableLiveData<Character> getOperator() {
        return operator;
    }
}
