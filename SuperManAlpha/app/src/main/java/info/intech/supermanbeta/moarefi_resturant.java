package info.intech.supermanbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class moarefi_resturant extends AppCompatActivity {

    Button back_btn_moarefi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moarefi_market);
        back_btn_moarefi = (Button) findViewById(R.id.back_btn_moarefi);
        back_btn_moarefi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
//                Intent boro_menu = new Intent(getApplicationContext(), asli_page.class);
//                startActivity(boro_menu);
            }
        });
    }
}
