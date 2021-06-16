package com.vinay.eyeexercise;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.io.Serializable;

import Health.FragmentToActivity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment implements Serializable {
    private String TAG = "secondFragmenttag";
    private WebView web;
    boolean click = true;

    private FragmentToActivity mCallback;

    public SecondFragment() {
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
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        public void onResume(){
//            super.onResume();
//
//            // Set title bar
//            ((MainActivity) getActivity())
//                    .setActionBarTitle("Your title");
//
//        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
// Change Action Bar name
        //((MainActivity) getActivity()).getSupportActionBar().setTitle("Health");

        LinearLayout layout1 = view.findViewById(R.id.layout1);
        LinearLayout layout2 = view.findViewById(R.id.layout2);
        LinearLayout layout3 = view.findViewById(R.id.layout3);
        LinearLayout layout4 = view.findViewById(R.id.layout4);

        clickLayout1(layout1);
        clickLayout2(layout2);
        clickLayout3(layout3);
        clickLayout4(layout4);

        return view;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            mCallback = (FragmentToActivity) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " must implement FragmentToActivity");
//        }
//    }


//    @Override
//    public void onDetach() {
//        mCallback = null;
//        super.onDetach();
//    }

    private void clickLayout1(LinearLayout layout1) {
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Second_One_Activity.class);
//                intent.putExtra("")
//                sendData("Andrews");
                getActivity().startActivity(intent);
                // show progress bar
            }
        });
    }

    private void sendData(String comm)
    {
        Log.i(Constants.TAG, "senData called");
        mCallback.communicate(comm);
    }

    private void clickLayout2(LinearLayout layout2) {
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Second_One_Activity.class);
              //  intent.putExtra("layout" , )
                getActivity().startActivity(intent);
            }
        });
    }

    private void clickLayout3(LinearLayout layout3) {
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Second_One_Activity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void clickLayout4(LinearLayout layout4) {
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Second_One_Activity.class);
                getActivity().startActivity(intent);
            }
        });
    }


}