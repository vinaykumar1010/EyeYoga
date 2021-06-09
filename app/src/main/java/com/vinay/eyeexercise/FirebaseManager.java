package com.vinay.eyeexercise;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class FirebaseManager {

    private String TAG = "exerciseabc";

    public void getFirstDataModel(OnGetExercisesListener listener) {
//        listener.onStart();
        ArrayList<FirstDataModel> firstDataModelList = new ArrayList<FirstDataModel>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Log.d(TAG, "getFirstDataModel is called ");
        db.collection("exercise")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        Log.d(TAG, "onComplete");
                        if (task.isSuccessful()) {
                            Log.d(TAG, "is successful");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map data = document.getData();
//                                Log.d(TAG, String.valueOf(data));
                                String name = (String) data.get("name");
                                String description = (String)data.get("description");
                                // Creating FirstDataModel class object for one link coming from db.
                                FirstDataModel linkObj = new FirstDataModel(name , description);
                                // push this link in useful links array.
                                firstDataModelList.add(linkObj);
                            }
                            listener.onSuccess(firstDataModelList);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                            listener.onFailure();
                        }
                    }
                });
    }
}
