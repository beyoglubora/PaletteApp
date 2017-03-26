package com.example.cameronurban.paletteapp;

        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.content.Intent;
        import android.widget.ImageButton;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.view.ViewGroup;
        import android.view.View.OnClickListener;

        import java.util.LinkedList;
        import android.widget.GridLayout.LayoutParams;
        import android.support.v7.widget.LinearLayoutCompat;
        import android.widget.TextView;


        import java.util.Arrays;


public class PaletteGallery extends AppCompatActivity {
    public static int count = 0;
    public static int x = 10;
    //public static int[] xPos = new int[5];
    public static int y = 180;
    private boolean stopper = true;
    protected static int spot = 0;
    //public static Button[] buttonArr = new Button[5];
    public static LinkedList<Button> buttonList = new LinkedList<Button>();
    public static LinkedList<TextView> textList = new LinkedList<>();
    public static LinkedList<Integer> intList = new LinkedList<>();
    public static LinkedList<Boolean> boolList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palette_gallery);
        int b = getIntent().getIntExtra("bob", 0);
        /**final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_add_btn);
         final Button button = (Button) findViewById(R.id.click);
         button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        LinearLayoutCompat.LayoutParams lparams = new LinearLayoutCompat.LayoutParams(
        LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        Button button1 = new Button(getApplicationContext());
        button1.setLayoutParams(lparams);
        button1.setText("added");
        linearLayout.addView(button1);
        }
        });*/

        ImageButton button = (ImageButton) findViewById(R.id.menuButton2);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(PaletteGallery.this,HomePage.class);
                startActivity(i);
            }
        });

        System.out.println(b);
       //if(b!=0){


            //System.out.println(buttonList.size());
            //for(int i = 0; i<buttonList.size(); i++) {
            //RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.main);
            //Button addButton = new Button(this);
            //if(stopper) {
            //buttonList.add(addButton);
            //stopper = false;
            //}
            //System.out.println(buttonList.size());
            RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.main);
            //mainLayout.removeView(mainLayout);
            if(b==0) {
                boolList.add(false);
            }
            else
                boolList.add(true);
            intList.add(b);
            Button addButton = new Button(this);
            TextView addText = new TextView(this);
            addText.setText("#" + Integer.toHexString(b));
            addButton.setId(spot);
            buttonList.add(addButton);
            textList.add(addText);
            System.out.println(buttonList.size());
            //buttonList.get(spot).setText(Integer.toHexString(b));
            buttonList.get(spot).setBackgroundColor(b);

            //int drawableId=getResources().getIdentifier("foo"+spot, "drawable", getPackageName());
            //RelativeLayout layout = (RelativeLayout)findViewById(spot);
            //layout.setBackgroundResource(R.drawable.circle);
            //layout.setImageDrawable(getResources().getDrawable(spot));

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
            RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(100, 100);
            layoutParams.setMargins(90 + x, 400 + y, 200, 100); // left, top, right, bottom
            layoutParams1.setMargins(100 + x, 500 + y, 200, 100);
            buttonList.get(spot).setLayoutParams(layoutParams);
            textList.get(spot).setLayoutParams(layoutParams1);

            //RelativeLayout layout = (RelativeLayout) findViewById(R.id.main);


            System.out.println(x);
            for(int i =0 ; i < buttonList.size(); i++) {
                if(buttonList.get(i).getParent()!=null) {
                    ((ViewGroup) buttonList.get(i).getParent()).removeView(buttonList.get(i));
                    ((ViewGroup) textList.get(i).getParent()).removeView(textList.get(i));
                }// <- fix
                System.out.println(intList.get(i));
                if(intList.get(i)!=0) {
                    mainLayout.addView(buttonList.get(i));
                    mainLayout.addView(textList.get(i));
                    if(boolList.get(i)) {
                        x += 200;
                        if (x > 1000) {
                            x = 10;
                            y += 200;
                        }
                        boolList.set(i,false);
                    }
                }
                //mainLayout.addView(layout);
            }



            spot = spot + 1;
            //}
            //final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_add_btn);
            //LinearLayoutCompat.LayoutParams lparams = new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
            //Button button1 = new Button(getApplicationContext());
            //button1.setLayoutParams(lparams);
            //button1.setText("added");
            //linearLayout.addView(button1);

            /**for(int i = 0; i<count; i++) {
             button.callOnClick();
             }*/

            /** ImageButton button10 = (ImageButton) findViewById(R.id.menuButton1);
             button10.setOnClickListener(new OnClickListener() {
             public void onClick(View v) {
             Intent i = new Intent(PaletteGallery.this,HomePage.class);
             startActivity(i);
             }
             });*/
        //}

    }
}
