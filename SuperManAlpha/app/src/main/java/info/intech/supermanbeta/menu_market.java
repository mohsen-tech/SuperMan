package info.intech.supermanbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class menu_market extends AppCompatActivity {
    TextView back_asli_page;
    RelativeLayout vorod_menu, boxes_menu, market_menu, suport_menu, share_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_market);

        vorod_menu = (RelativeLayout) findViewById(R.id.vorod_menu);
        boxes_menu = (RelativeLayout) findViewById(R.id.boxes_menu);
        market_menu = (RelativeLayout) findViewById(R.id.market_menu);
        suport_menu = (RelativeLayout) findViewById(R.id.suport_menu);
        share_menu = (RelativeLayout) findViewById(R.id.share_menu);

        back_asli_page = (TextView) findViewById(R.id.back_asli_page);

        back_asli_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
//                Intent boro_menu = new Intent(getApplicationContext(), asli_page.class);
//                startActivity(boro_menu);
            }
        });

        market_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boro_menu = new Intent(getApplicationContext(), moarefi_resturant.class);
                startActivity(boro_menu);
            }
        });

        vorod_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent boro_menu = new Intent(getApplicationContext(), vorod_or_sabt_name.class);
                startActivity(boro_menu);
            }
        });
    }
}
