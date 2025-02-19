public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;


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
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        int [] imageArray = {R.drawable.android1,R.drawable.android2,R.drawable.android3,R.drawable.android5,R.drawable.android10};
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast(imageArray[0],"android version 1.0");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast(imageArray[1],"android version 2.0");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast(imageArray[2],"android version 3.0");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast(imageArray[3],"android version 5.0");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast(imageArray[4],"android version 10");
            }
        });

    }
    private void showCustomToast(int ImageResid, String msg)
    {
        Toast toast = new Toast(getApplicationContext());
        ImageView img = new ImageView(getApplicationContext());
        img.setImageResource(ImageResid);
        TextView text = new TextView(getApplicationContext());
        text.setText(msg);
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);  // Stack ImageView and TextView vertically
        layout.setGravity(Gravity.CENTER);  // Center the content
        layout.addView(img);  // Add ImageView to the layout
        layout.addView(text);  // Add TextView to the layout

        // Set the custom layout to the Toast
        toast.setView(layout);

        // Set the Toast duration
        toast.setDuration(Toast.LENGTH_SHORT);

        // Show the Toast
        toast.show();


    }
}
