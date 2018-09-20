package appone.bmp.com.applog.Fragment;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import appone.bmp.com.applog.R;

@SuppressLint("ValidFragment")
public class FragmentDetail extends Fragment {
    String id,email,pwd;
    myDB mydb;
    @SuppressLint("ValidFragment")
    public FragmentDetail(String stremail){
        Bundle bundle = new Bundle();
        bundle.putString("stremail",stremail);
        setArguments(bundle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentdetail,container,false);
     mydb = new myDB(getActivity());
        TextView tvid = v.findViewById(R.id.txtshowid);
        TextView tvemail = v.findViewById(R.id.txtshowemail);
        TextView tvpwd = v.findViewById(R.id.txtshowpwd);
        String itmemail = getArguments().getString("stremail");
       // Log.d("20SepV1","Data ==> "+itmemail);
       // Toast.makeText(FragmentDetail.this.getContext(), itmemail, Toast.LENGTH_SHORT).show();
        String [] itmdata = mydb.SelectDataByVal(itmemail);
        Log.d("20SepV1","Data ==> "+itmdata);
                id = itmdata[0];
                email =itmdata[1];
                pwd = itmdata[2];
                tvid.setText(id);
                tvemail.setText(email);
                tvpwd.setText(pwd);







        return v;
    }
}
