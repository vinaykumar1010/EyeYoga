package Setting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vinay.eyeexercise.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FourFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FourFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourFragment newInstance(String param1, String param2) {
        FourFragment fragment = new FourFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.four_fragment, container, false);

        TextView privacyPolicy = (TextView) rootView.findViewById(R.id.privacy_policy_tv);
        TextView feedback = (TextView) rootView.findViewById(R.id.feedback_tv);
        TextView rateNow = (TextView) rootView.findViewById(R.id.rate_us_tv);
        TextView about = (TextView) rootView.findViewById(R.id.about_us_tv);
        TextView share = (TextView) rootView.findViewById(R.id.share_with_friends_tv);
        TextView remainder = (TextView) rootView.findViewById(R.id.remainder_tv);

        clickRemainder(remainder);
        clickShareWithFriends(share);
        clickRateUs(rateNow);
        clickAboutUs(about);
        clickPrivacyPolicy(privacyPolicy);
        clickFeedback(feedback);
        return rootView;
    }

    private void clickPrivacyPolicy(TextView privacyPolicy) {
        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), PrivacyPolicy.class);

                intent.putExtra("KEY", "variable");
                getActivity().startActivity(intent);

//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.frame_container, Second_One_Activity.class);
//                transaction.addToBackStack(null);
//                transaction.commit();

            }
        });
    }

    private void clickFeedback(TextView feedback) {
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = {"feedback.vinappstudio@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject text here...");
                intent.putExtra(Intent.EXTRA_TEXT, "Body of the content here...");
                intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });

    }

    private void clickAboutUs(TextView about) {
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), AboutUs.class);

                // intent.putExtra("KEY" , "variable");
                getActivity().startActivity(intent);
            }
        });
    }

    private void clickRateUs(TextView rateNow) {
        rateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Coming Soon",
                        Toast.LENGTH_LONG).show();
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + EYE_EXERCISES)));


//                try{
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
//                }
//                catch (ActivityNotFoundException e){
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
//                }

            }
        });
    }

    private void clickShareWithFriends(TextView share) {
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "YOUR_LINK");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

    private  void clickRemainder(TextView remainder){
        remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Coming Soon",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}