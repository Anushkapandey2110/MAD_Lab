import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ToggleButton tbtn;
    private Button btn;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tbtn = findViewById(R.id.tbtn);
        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);
        tbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateToggle();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToggle();
            }
        });


    }
    void updateToggle()
    {
        if(tbtn.isChecked()) {
            img.setImageResource(R.drawable.mobiledata);
            showtoast("Mobile Data mode is selected");
        }
        else {
            img.setImageResource(R.drawable.wifi);
            showtoast(" WIFI mode is selected");
        }


    }
    void changeToggle()
    {
        if (tbtn.isChecked())
        {
            tbtn.setChecked(false);
        }
        else
            tbtn.setChecked(true);
    }
    void showtoast(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
