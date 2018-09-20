package appone.bmp.com.applog.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import appone.bmp.com.applog.R;

@SuppressLint("ValidFragment")
public class FragmentShowData extends Fragment {
    public FragmentShowData(String email){
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        setArguments(bundle);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragmentshowdata,container,false);
        EditText txtemail = v.findViewById(R.id.txtname);
        String email= getArguments().getString("email");
        txtemail.setText(email);

        return v;
    }
}
