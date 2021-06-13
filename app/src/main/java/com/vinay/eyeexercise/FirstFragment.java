package com.vinay.eyeexercise;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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


        getActivity().setTitle("Exercise");

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

        Button mStartAllButton = view.findViewById(R.id.start_exercise_all);
        startAllExercises(mStartAllButton);
        ListView mListView = view.findViewById(R.id.exercise_list);
        mListView.setAdapter(exercisesAdapter);
        Log.d(TAG, "list item is in on create view " + String.valueOf(list));


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // String selectedItem = (String) mListView.getItemAtPosition(position);
                Log.d(TAG, "clicked on list item");
                Intent intent = new Intent(view.getContext(), TimerActivity.class);

                FirstDataModel itemValue = (FirstDataModel) mListView.getItemAtPosition(position);
                // We directly send data model  and in Timer Activity we Serialize it first then
                // get the name by calling method on it
                // u can use either serilizable or paraseable interface because only primitive data type can b sent through intent
                intent.putExtra("COURSE_SELECTED", itemValue);
                startActivity(intent);
            }
        });

//        callFirebase(mListView);
        return view;
    }

    private  void startAllExercises(Button mStartAllButton){
        Log.d(TAG,"startAllExercises");
        mStartAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"startAllExercises  onclick" );

                // start and play all exercises serially
                // step 1 : get position Id
            }
        });
    }


    void callFirebase(ListView mListView) {

    }
}