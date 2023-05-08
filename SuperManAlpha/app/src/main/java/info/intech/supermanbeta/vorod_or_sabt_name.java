package info.intech.supermanbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vorod_or_sabt_name extends AppCompatActivity {

    Button back_btn_vorod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vorod_or_sabt_name);
        back_btn_vorod=(Button)findViewById(R.id.back_btn_vorod);
        back_btn_vorod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
//                Intent boro_menu = new Intent(getApplicationContext(), asli_page.class);
//                startActivity(boro_menu);
            }
        });
    }
}
