package appone.bmp.com.applog.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import appone.bmp.com.applog.R;

public class FragmentList extends Fragment {
 //   String [] itm ={"Hotel","Travel","Resturant"};
    ArrayList<String> arr = new ArrayList<String>();
    ArrayList<String> arrid = new ArrayList<String>();
    myDB mydb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragmentlist,container,false);

        mydb = new myDB(getActivity());
        Cursor cur = mydb.SelectData();
        arr.clear();
        arrid.clear();

        if(cur !=null){
            if(cur.moveToFirst()){
                do{
                    arrid.add(cur.getString(cur.getColumnIndex("id")));
                    arr.add(cur.getString(cur.getColumnIndex("email")));

                }while (cur.moveToNext());
            }
        }
        cur.close();



        ArrayAdapter<String> adt = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr);
        final ListView lv = v.findViewById(R.id.tvitm);
        lv.setAdapter(adt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              // String str = lv.getItemAtPosition(position).toString();
               String strid = arrid.get(position);
             //String str = lv.getItemAtPosition(position).toString();

          //  Toast.makeText(FragmentList.this.getContext(),str,Toast.LENGTH_SHORT).show();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMain, new FragmentDetail(strid))
                        .addToBackStack(null)
                        .commit();
            }
        });



        return v;
    }
}
