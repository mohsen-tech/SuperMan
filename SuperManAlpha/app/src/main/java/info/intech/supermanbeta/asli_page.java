package info.intech.supermanbeta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AlertDialog;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class asli_page extends AppCompatActivity implements View.OnClickListener {

    Button btn_city_asli_page;
    TextView menu_asli_page, boro_place_asli_page;

    ArrayList<String> myList;

    int city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asli_page);

        myList = new ArrayList<String>();
        myList.add("مشهد");
        myList.add("شیراز");
        myList.add("اصفهان");
        myList.add("تهران");
        myList.add("سمنان");
        myList.add("بیرجند");
        myList.add("زاهدان");
        myList.add("تبریز");
        myList.add("گرگان");
        myList.add("کرج");
        myList.add("قم");
        myList.add("خوزستان");
        myList.add("کیش");

        btn_city_asli_page = (Button) findViewById(R.id.btn_city_asli_page);
        btn_city_asli_page.setOnClickListener(this);

        boro_place_asli_page = (TextView) findViewById(R.id.boro_place_asli_page);
        boro_place_asli_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boro_near_market = new Intent(getApplicationContext(), list_market_near_btnboro.class);
                startActivity(boro_near_market);
            }
        });


        menu_asli_page = (TextView) findViewById(R.id.menu_asli_page);
        menu_asli_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boro_menu = new Intent(getApplicationContext(), menu_market.class);
                startActivity(boro_menu);
            }
        });

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_city_asli_page:
                ShowCustomDialogwithList();
                break;
        }
    }

    private void ShowCustomDialogwithList() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(asli_page.this);
        LayoutInflater inflater = asli_page.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_custom_dialog_select_city, null);
        dialogBuilder.setView(dialogView);

        final ListView listView = (ListView) dialogView.findViewById(R.id.listView);


        MyAdapter myadapter = new MyAdapter(asli_page.this,
                R.layout.activity_listview_select_city, myList);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(asli_page.this,
                        "You have selected : " + myList.get(position),
                        Toast.LENGTH_SHORT).show();
                city = position;
            }
        });

        final AlertDialog alertDialog = dialogBuilder.create();
        Window window = alertDialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        // Cancel Button
        Button btn_selected_taeed_city = (Button) dialogView.findViewById(R.id.btn_selected_taeed_city);
        btn_selected_taeed_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_city_asli_page.setText(myList.get(city).toString());
                alertDialog.hide();
            }
        });

        alertDialog.show();
    }

    class MainListHolder {
        private TextView tvText;
    }

    private class ViewHolder {
        TextView tvSname;
    }

    class MyAdapter extends ArrayAdapter<String> {
        LayoutInflater inflater;
        Context myContext;
        List<String> newList;

        public MyAdapter(Context context, int resource, List<String> list) {
            super(context, resource, list);
            // TODO Auto-generated constructor stub
            myContext = context;
            newList = list;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                holder = new ViewHolder();
                view = inflater.inflate(R.layout.activity_listview_select_city, null);
                holder.tvSname = (TextView) view.findViewById(R.id.tvtext_item);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.tvSname.setText(newList.get(position).toString());


            return view;
        }
    }

}
