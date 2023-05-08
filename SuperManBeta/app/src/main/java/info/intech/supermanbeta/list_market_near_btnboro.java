package info.intech.supermanbeta;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class list_market_near_btnboro extends AppCompatActivity implements View.OnClickListener {

    private String TAG = list_market_near_btnboro.class.getSimpleName();
    private ListView lv;

    //-----------------------------------------------------------//
    Button btn_filter;

    ArrayList<String> myList;

    int city;

    ArrayList<HashMap<String, String>> contactList;

    //-----------------------------------------------------------//

    // ExpandableListView expandableListView;
    // ExpandableListAdapter expandableListAdapter;
    // List<String> expandableListTitle;
    // HashMap<String, List<String>> expandableListDetail;

    //-----------------------------------------------------------//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_market_near_btnboro);

        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView2);

        // new GetContacts().execute();

//-----------------------------------------------------------//


//        myList = new ArrayList<String>();
//        myList.add("مشهد");
//        myList.add("شیراز");
//        myList.add("اصفهان");
//        myList.add("تهران");
//        myList.add("سمنان");
//        myList.add("بیرجند");
//        myList.add("زاهدان");
//        myList.add("تبریز");
//        myList.add("گرگان");
//        myList.add("کرج");
//        myList.add("قم");
//        myList.add("خوزستان");
//        myList.add("کیش");

        btn_filter = (Button) findViewById(R.id.btn_filter);
        btn_filter.setOnClickListener(this);


//-----------------------------------------------------------//

    }


    //-------------------------------------------------------------------------------------//
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_filter:
                ShowCustomDialogwithList();///////////////////////////////////////////////////////
                break;
        }
    }


    private void ShowCustomDialogwithList() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(list_market_near_btnboro.this);
        LayoutInflater inflater = list_market_near_btnboro.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_custom_dialog_filter, null);
        dialogBuilder.setView(dialogView);

        final ListView listView = (ListView) dialogView.findViewById(R.id.listView);
        MyAdapter myadapter = new MyAdapter(list_market_near_btnboro.this,
                R.layout.activity_listview_select_city, myList);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(list_market_near_btnboro.this,
                        "You have selected : " + myList.get(position),
                        Toast.LENGTH_SHORT).show();
                city = position;
            }
        });

        final ExpandableListView expandableListView = (ExpandableListView) dialogView.findViewById(R.id.expandableListView);
        //--->
        //expandableListDetail = ExpandableListDataPump.getData();
        //<---
        //expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        //--->
        // expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        //<---
        expandableListView.setAdapter(expandableListAdapter);////////////////////////////////
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });


        //---------------------------------------------------------------//

        final AlertDialog alertDialog = dialogBuilder.create();
        Window window = alertDialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        // Buttons


        Button btn_delet_filter = (Button) dialogView.findViewById(R.id.btn_delet_filter);
        btn_delet_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//_______________?

                alertDialog.hide();
            }
        });


        Button btn_accept_filter = (Button) dialogView.findViewById(R.id.btn_accept_filter);
        btn_accept_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//_______________?

                alertDialog.hide();
            }
        });


        Button close_dialog_filter = (Button) dialogView.findViewById(R.id.close_dialog_filter);
        close_dialog_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//_______________?

                alertDialog.hide();
            }
        });

        alertDialog.show();
    }

    //--------------------------------------------------------------//
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
        //---------------------------------------------------------------------
        HashMap<String, List<String>> expandableListDetail = ExpandableListDataPump.getData();
        List<String> expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        ExpandableListAdapter expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);


        //---------------------------------------------------------------------

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
                view = inflater.inflate(R.layout.layout_custom_dialog_filter, null);
                holder.tvSname = (TextView) view.findViewById(R.id.tvtext_item);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.tvSname.setText(newList.get(position).toString());


            return view;
        }


        class Adapters extends ArrayAdapter<String> {
            //LayoutInflater inflater;
            //Context myContext;
            //List<String> newList;
            //---------------------------------------------------------------------
            HashMap<String, List<String>> expandableListDetail = ExpandableListDataPump.getData();
            List<String> expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
            ExpandableListAdapter expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);


            //---------------------------------------------------------------------

            public Adapters(Context context, int resource, List<String> list) {
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
                    view = inflater.inflate(R.layout.layout_custom_dialog_filter, null);
                    holder.tvSname = (TextView) view.findViewById(R.id.tvtext_item);
                    view.setTag(holder);
                } else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.tvSname.setText(newList.get(position).toString());


                return view;
            }

        }

        //-------------------------------------------------------------------------------------------//
//    private class GetContacts extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Toast.makeText(list_market_near_btnboro.this, "Json Data is downloading", Toast.LENGTH_LONG).show();
//
//        }

//        @Override
//        protected Void doInBackground(Void... arg0) {
//            HttpHandler sh = new HttpHandler();
//            // Making a request to url and getting response
//            String url = "http://razavi-agri-eng.ir/wservice";
//            String jsonStr = sh.makeServiceCall(url);
//
//            Log.e(TAG, "Response from url: " + jsonStr);
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//
//                    // Getting JSON Array node
//                    JSONArray contacts = jsonObj.getJSONArray("contacts");
//
//                    // looping through All Contacts
//                    for (int i = 0; i < contacts.length(); i++) {
//                        JSONObject c = contacts.getJSONObject(i);
//                        String id = c.getString("id");
//
//                        // image_list_market , name_market , noe_mahsol , adreas_super_market , score_super_market //
//
//                        // Phone node is JSON Object
//                        JSONObject id = c.getJSONObject("id");
//
//                        // tmp hash map for single contact
//                        HashMap<String, String> contact = new HashMap<>();
//
//                        // adding each child node to HashMap key => value
//                        contact.put("id", id);
//
//
//                        // adding contact to contact list
//                        contactList.add(contact);
//                    }
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    });
//
//                }
//
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            ListAdapter adapter = new SimpleAdapter(list_market_near_btnboro.this, contactList,
//                    R.layout.layout_list_market, new String[]{"email", "mobile"},
//                    new int[]{R.id.email, R.id.mobile});
//            lv.setAdapter(adapter);
//        }
        //}
    }
