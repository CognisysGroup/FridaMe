package group.cognisys.fridame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import group.cognisys.fridame.R;

public class MainActivity extends AppCompatActivity {

    public boolean isAdmin = false;
    private boolean isAdmin() {
        return isAdmin;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button adminButton = findViewById(R.id.adminButton);
        Button userLogin = findViewById(R.id.loginButton);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdmin()) {
                    Intent intent = new Intent(MainActivity.this, AdminArea.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Only admin can access this area", Toast.LENGTH_SHORT).show();
                }
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = Utils.isDeviceRooted(getApplicationContext());
                if (status.equals("Device is safe.")) {
                    Intent intent = new Intent(MainActivity.this, UserLogin.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Device is rooted, can't proceed further!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}