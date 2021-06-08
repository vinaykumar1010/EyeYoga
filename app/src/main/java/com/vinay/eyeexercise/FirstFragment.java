package com.vinay.eyeexercise;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    private View view;
    private String TAG = "exerciseabc";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ExercisesAdapter exercisesAdapter;
    private ArrayList<FirstDataModel> list = new ArrayList<FirstDataModel>();

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "on create is called");
        super.onCreate(savedInstanceState);
        exercisesAdapter = new ExercisesAdapter(getActivity(), R.layout.exercise_adapter_link_layout, list);

        FirebaseManager firebaseManagerObj = new FirebaseManager();
        firebaseManagerObj.getFirstDataModel(new OnGetExercisesListener() {
            @Override
            public void onFailure() {
                Log.e(TAG, "firebase request to fetch exercises failed.");
            }

            @Override
            public void onSuccess(ArrayList<FirstDataModel> exercisesArray) {
                list = exercisesArray;
                Log.d(TAG, "Exercises: " + String.valueOf(exercisesArray.size()));
                // Refresh list view.
                exercisesAdapter.clear();
                exercisesAdapter.addAll(exercisesArray);
                exercisesAdapter.notifyDataSetChanged();
            }
        });

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "on create view is called ");
        if (view == null) {
            view = inflater.inflate(R.layout.first_fragment, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        Log.d(TAG, "list is here" + String.valueOf(list));
        ListView mListView = view.findViewById(R.id.exercise_list);
        mListView.setAdapter(exercisesAdapter);
        Log.d(TAG, "list item is in on create view " + String.valueOf(list));

//        callFirebase(mListView);
        return view;
    }

    void callFirebase(ListView mListView) {

    }
}