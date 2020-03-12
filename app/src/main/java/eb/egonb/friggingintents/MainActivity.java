package eb.egonb.friggingintents;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //UI
    private Button callButton;
    private EditText etName;
    //Listeners
    private View.OnClickListener callListener = new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            Uri callUri = Uri.parse("tel:0492827218");
            Intent callIntent = new Intent(Intent.ACTION_CALL, callUri);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    askPermission();
                    return;
                }
            }
            startActivity(callIntent);
        }
    };

    private void askPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
    }

    //Methode om in layout naar te verwijzen
    public void openWebsite(View v){
        Uri webUri = Uri.parse("https://www.google.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
        startActivity(webIntent);
    }

    public void navToSecond(View v){
        Intent navIntent = new Intent(this, SecondActivity.class);

        navIntent.putExtra("key_name", etName.getText().toString());

        startActivity(navIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Verwijzing naar views in UI!
        callButton = findViewById(R.id.btn_call);
        etName = findViewById(R.id.et_name);

        //Koppelen van listeners aan views
        callButton.setOnClickListener(callListener);

    }
}
