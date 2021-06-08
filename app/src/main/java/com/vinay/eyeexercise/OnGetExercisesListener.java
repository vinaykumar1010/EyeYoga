package com.vinay.eyeexercise;

import java.util.ArrayList;

public interface OnGetExercisesListener {
//    void onStart();
    void onFailure();
    void onSuccess(ArrayList<FirstDataModel> exercisesArray);
}