package appone.bmp.com.applog.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import appone.bmp.com.applog.R;

public class FragmentInsertData extends Fragment {
    myDB mydb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragmentinsertdata,container,false);
        mydb = new myDB(getActivity());
        final EditText txtid = v.findViewById(R.id.txtsaveid);
        final EditText txtemail = v.findViewById(R.id.txtsaveemail);
        final EditText txtpwd = v.findViewById(R.id.txtsavepwd);
        Button btnsave = v.findViewById(R.id.btnSaveData);
        Button btnshow =v.findViewById(R.id.btnCancel);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMain,new FragmentList())
                        .commit();
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long r = mydb.InsertData(txtid.getText().toString(),
                        txtemail.getText().toString(),
                        txtpwd.getText().toString());
                if(r >0){
                    Toast.makeText(FragmentInsertData.this.getContext(), "Save data complete", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FragmentInsertData.this.getContext(), "Can not Save data ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return v;
    }
}
