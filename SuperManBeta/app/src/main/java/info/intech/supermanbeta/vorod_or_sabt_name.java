package info.intech.supermanbeta;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class vorod_or_sabt_name extends AppCompatActivity {

    final Context context = this;
    private Button vorod_dialog;

    Button back_btn_vorod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vorod_or_sabt_name);
        back_btn_vorod = (Button) findViewById(R.id.back_btn_vorod);
        back_btn_vorod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
//                Intent boro_menu = new Intent(getApplicationContext(), asli_page.class);
//                startActivity(boro_menu);
            }
        });


        vorod_dialog = (Button) findViewById(R.id.vorod_vorod);

        // add button listener
        vorod_dialog.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.alert_dialog_taeed_vorod_phone);

                // set the custom dialog components - text, image and button
                EditText code_number_alert_dialog_taeed_phone = (EditText) dialog.findViewById(R.id.code_number_alert_dialog_taeed_phone);


                Button no_deliver_alert_dialog_taeed_phone = (Button) dialog.findViewById(R.id.no_deliver_alert_dialog_taeed_phone);
                // if button is clicked, close the custom dialog
                no_deliver_alert_dialog_taeed_phone.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                Button sabt_alert_dialog_taeed_phone = (Button) dialog.findViewById(R.id.sabt_alert_dialog_taeed_phone);
                // if button is clicked, close the custom dialog
                sabt_alert_dialog_taeed_phone.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}