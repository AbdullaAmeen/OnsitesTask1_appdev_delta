package com.example.calculator;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ViewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public MutableLiveData<String> getLiveData() {
        return mText;
    }

}
