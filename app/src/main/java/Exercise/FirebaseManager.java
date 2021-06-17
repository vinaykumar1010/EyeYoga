package Exercise;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Map;

import Health.OnGetHealthTipListner;

public class FirebaseManager {

    private String TAG = "exerciseabc";

//  FOR EXERCISE   or First Fragnment

    /**
     * @param listener
     */
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
                                String description = (String) data.get("description");
                                // Creating FirstDataModel class object for one link coming from db.
                                FirstDataModel linkObj = new FirstDataModel(name, description);
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


    public void storageData1(OnGetHealthTipListner getHealthTipListener) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        //  firebaseFetchHtml1(webView,storageRef);
        storageRef.child("images/bestFruit.html").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                getHealthTipListener.onSuccess(url);

                // if success then without directly send data
                // we call function here (of that activity where we are sending data)
                // so that activity knows when data is recieved
                // we need interface
                // because   standred process of making obj of class and call its function but that doesnt work here
                // bcause new keyword will create new object and we need the obj that is already on View
                // so we need interface
                // interface contain only function declaration
                // jo b class interface ka obj banayegi vo uske function b implement karegi
                //
                //
                // static html string dataa
                //Log.d(TAG, "url value is :" + bestFruit);
                // load static html data on a web view
                //  webView.loadUrl(bestFruit);

                //return uri;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d(TAG, "fetching html from firebase Failed");
                // Handle any errors
            }
        });
    }
    public void storageData2(OnGetHealthTipListner getHealthTipListener) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        //  firebaseFetchHtml1(webView,storageRef);
        storageRef.child("images/bestFruit.html").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                getHealthTipListener.onSuccess(url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d(TAG, "fetching html from firebase Failed");
                // Handle any errors
            }
        });
    }
    public void storageData3(OnGetHealthTipListner getHealthTipListener) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        //  firebaseFetchHtml1(webView,storageRef);
        storageRef.child("images/bestFruit.html").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                getHealthTipListener.onSuccess(url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d(TAG, "fetching html from firebase Failed");
                // Handle any errors
            }
        });
    }
    public void storageData4(OnGetHealthTipListner getHealthTipListener) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        //  firebaseFetchHtml1(webView,storageRef);
        storageRef.child("images/bestFruit.html").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                getHealthTipListener.onSuccess(url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d(TAG, "fetching html from firebase Failed");
                // Handle any errors
            }
        });
    }

}
