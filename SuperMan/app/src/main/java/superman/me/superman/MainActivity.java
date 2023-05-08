package superman.me.superman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DBHandler myhndle;
    EditText name;
    EditText phone;
    EditText email;
    EditText nameshop;
    EditText place;
    EditText telephone;
    EditText tavalod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myhndle = new DBHandler(this);

    }
}
