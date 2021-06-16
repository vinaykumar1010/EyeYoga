package Exercise;

import Exercise.FirstDataModel;

import java.util.ArrayList;

public interface OnGetExercisesListener {
//    void onStart();
    void onFailure();
    void onSuccess(ArrayList<FirstDataModel> exercisesArray);
}