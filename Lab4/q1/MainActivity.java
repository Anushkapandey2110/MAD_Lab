public class MainActivity extends AppCompatActivity {

    // Array of images to cycle through when ToggleButton is ON
    private int[] imageArray = {R.drawable.cat, R.drawable.meow, R.drawable.tiger};
    private int imageIndex = 0; // Keeps track of which image to show next

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // ToggleButton is ON: show a new image each time
                    showCustomToast(imageArray[0]);

                }
                    else {
                        // If the imageIndex is 0, just show the first image
                        showCustomToast(imageArray[1]);
                    }
                }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the last image in the array
                showCustomToast(imageArray[2]);
            }
        });
    }

    private void showCustomToast(int imageResId) {
        // Create a Toast with a custom layout
        Toast toast = new Toast(getApplicationContext());

        // Create an ImageView for the image
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(imageResId);
        TextView textview = new TextView(getApplicationContext());
        textview.setText("Image shown");

        // Add the ImageView to the Toast layout
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setGravity(Gravity.CENTER);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(imageView);
        layout.addView(textview);


        // Set Toast properties
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
