package info.intech.supermanbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first_page extends AppCompatActivity {

    Button edame_first_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        edame_first_page = (Button) findViewById(R.id.edame_first_page);
        edame_first_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), asli_page.class);
                startActivity(i);

            }
        });
    }
}
