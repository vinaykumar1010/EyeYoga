package Exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vinay.eyeexercise.R;

import java.util.ArrayList;


public class ExercisesAdapter extends ArrayAdapter<FirstDataModel> {

    String TAG = "Exerxcise";
    private Context mContext;
    private int mResource;

    public ExercisesAdapter(@NonNull Context context, int resource, ArrayList<FirstDataModel> data) {
        super(context, resource, data);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
//        FirstDataModel linkObj = new FirstDataModel(name);

        // Get table cell View
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView named = convertView.findViewById(R.id.name_tv);

        // Set data to view
        named.setText(name);
        return convertView;
    }
}
