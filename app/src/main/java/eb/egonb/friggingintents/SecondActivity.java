package eb.egonb.friggingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.tv_name);

        Bundle receivedData = getIntent().getExtras();
        String username = receivedData.getString("key_name", "Default");
        tvName.setText(username);
    }
}
