package kz.softeng.sdu.SmartHouse;

import Animation.AnimationFactory;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created by Sayazhan on 16.05.2015.
 */
public class Devices extends Activity {

    private TableLayout mLayout;
    private TableRow mLayoutT1,mLayoutT2,mLayoutT3;
    private LayoutTransition mLT;
    private Animator mAppearAnim;
    private ImageButton  mAppearBtn;
    private ImageView imageViewNew1, imageViewNew2, imageViewNew3, imageViewNew4, imageViewNew5, imageViewNew6, imageViewNew7,
            imageViewNew8, imageViewNew9, imageViewNew10, imageViewNew11, imageViewNew12, imageViewNew13, imageViewNew14 ;
    private ViewAnimator viewAnimatorNew, viewAnimatorNew1, viewAnimatorNew2, viewAnimatorNew3, viewAnimatorNew4,
            viewAnimatorNew5, viewAnimatorNew6;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;
    private boolean setva;
    private boolean[] myArray = new boolean[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_animator);


        viewAnimatorNew = (ViewAnimator) this.findViewById(R.id.viewFlipperNew);
        viewAnimatorNew1 = (ViewAnimator) this.findViewById(R.id.viewFlipperNew1);
        viewAnimatorNew2 = (ViewAnimator) this.findViewById(R.id.viewFlipperNew2);
        viewAnimatorNew3 = (ViewAnimator) this.findViewById(R.id.viewFlipperNew3);
        viewAnimatorNew4 = (ViewAnimator) this.findViewById(R.id.viewFlipperNew4);
        viewAnimatorNew5 = (ViewAnimator) this.findViewById(R.id.viewFlipperNew5);
        viewAnimatorNew6 = (ViewAnimator) this.findViewById(R.id.viewFlipperNew6);

        imageViewNew1 = (ImageView) this.findViewById(R.id.imageViewNew1);
        imageViewNew2 = (ImageView) this.findViewById(R.id.imageViewNew2);

        imageViewNew3 = (ImageView) this.findViewById(R.id.imageViewNew3);
        imageViewNew4 = (ImageView) this.findViewById(R.id.imageViewNew4);

        imageViewNew5 = (ImageView) this.findViewById(R.id.imageViewNew5);
        imageViewNew6 = (ImageView) this.findViewById(R.id.imageViewNew6);

        imageViewNew7 = (ImageView) this.findViewById(R.id.imageViewNew7);
        imageViewNew8 = (ImageView) this.findViewById(R.id.imageViewNew8);

        imageViewNew9 = (ImageView) this.findViewById(R.id.imageViewNew9);
        imageViewNew10 = (ImageView) this.findViewById(R.id.imageViewNew10);

        imageViewNew11 = (ImageView) this.findViewById(R.id.imageViewNew11);
        imageViewNew12 = (ImageView) this.findViewById(R.id.imageViewNew12);

        imageViewNew13 = (ImageView) this.findViewById(R.id.imageViewNew13);
        imageViewNew14 = (ImageView) this.findViewById(R.id.imageViewNew14);

        tv1 = (TextView) this.findViewById(R.id.textView1);
        tv2 = (TextView) this.findViewById(R.id.textView2);
        tv3 = (TextView) this.findViewById(R.id.textView3);
        tv4 = (TextView) this.findViewById(R.id.textView4);
        tv5 = (TextView) this.findViewById(R.id.textView5);
        tv6 = (TextView) this.findViewById(R.id.textView6);
        tv7 = (TextView) this.findViewById(R.id.textView7);

        //  Load the custom "appear" animation and create a LayoutTransition
        mAppearAnim = AnimatorInflater.loadAnimator(this, R.animator.custom_appear);
        mLayout = (TableLayout)findViewById(R.id.container1);
        mLayoutT1 = (TableRow)findViewById(R.id.container2);
        mLayoutT2 = (TableRow)findViewById(R.id.container3);
        mLayoutT3 = (TableRow)findViewById(R.id.container4);
        mLT = new LayoutTransition();
        mLT.setAnimator(LayoutTransition.APPEARING, mAppearAnim);

        //  Set the start delay of our custom animation to be the
        //  duration of the "change appearing" animation so it does
        //  not begin before the other views have "made room".
        Animator ca = mLT.getAnimator(LayoutTransition.CHANGE_APPEARING);
        mAppearAnim.setStartDelay(ca.getDuration());
        mLayout.setLayoutTransition(mLT);
        mLayoutT1.setLayoutTransition(mLT);
        mLayoutT2.setLayoutTransition(mLT);
        mLayoutT3.setLayoutTransition(mLT);

        //  Use a button to trigger the image to come or go
        mAppearBtn = (ImageButton)findViewById(R.id.btnimage);


        AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                Devices.this);
        builderSingle.setIcon(R.drawable.ic_launcher);
        builderSingle.setTitle("Select One Name:-");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                Devices.this,
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("TV");
        arrayAdapter.add("Computer");
        arrayAdapter.add("AirConditioner");
        arrayAdapter.add("Music");
        arrayAdapter.add("Refrigerator");
        arrayAdapter.add("Gas");
        arrayAdapter.add("WashingMachine");
        builderSingle.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        mAppearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builderSingle.create();
                builderSingle.show();
            }
        });
        builderSingle.setAdapter(arrayAdapter,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);

                            if (viewAnimatorNew.getVisibility() == View.GONE && !myArray[which]) {
                                imageViewNew1.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_on" ,
                                        "drawable", getPackageName()));
                                imageViewNew2.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_off" ,
                                        "drawable", getPackageName()));
                                viewAnimatorNew.setAlpha(0f);
                                viewAnimatorNew.setVisibility(View.VISIBLE);
                                //set text
                                tv1.setVisibility(View.VISIBLE);
                                tv1.setText(strName);
                                myArray[which]=true;

                            }else if (viewAnimatorNew1.getVisibility() == View.GONE && !myArray[which]) {
                                System.out.println("This is computer");
                                imageViewNew3.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_on" ,
                                        "drawable", getPackageName()));
                                imageViewNew4.setImageResource(getResources().getIdentifier(strName.toLowerCase() + "_off",
                                        "drawable", getPackageName()));
                                viewAnimatorNew1.setAlpha(0f);
                                viewAnimatorNew1.setVisibility(View.VISIBLE);
                                //set text
                                tv2.setVisibility(View.VISIBLE);
                                tv2.setText(strName);
                                myArray[which]=true;
                            }else if (viewAnimatorNew2.getVisibility() == View.GONE && !myArray[which]) {
                                System.out.println("This is computer");
                                imageViewNew5.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_on" ,
                                        "drawable", getPackageName()));
                                imageViewNew6.setImageResource(getResources().getIdentifier(strName.toLowerCase() + "_off",
                                        "drawable", getPackageName()));
                                viewAnimatorNew2.setAlpha(0f);
                                viewAnimatorNew2.setVisibility(View.VISIBLE);
                                //set text
                                tv3.setVisibility(View.VISIBLE);
                                tv3.setText(strName);
                                myArray[which]=true;
                            }else if (viewAnimatorNew3.getVisibility() == View.GONE && !myArray[which]) {
                                System.out.println("This is computer");
                                imageViewNew7.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_on" ,
                                        "drawable", getPackageName()));
                                imageViewNew8.setImageResource(getResources().getIdentifier(strName.toLowerCase() + "_off",
                                        "drawable", getPackageName()));
                                viewAnimatorNew3.setAlpha(0f);
                                viewAnimatorNew3.setVisibility(View.VISIBLE);
                                //set text
                                tv4.setVisibility(View.VISIBLE);
                                tv4.setText(strName);
                                myArray[which]=true;
                            }else if (viewAnimatorNew4.getVisibility() == View.GONE && !myArray[which]) {
                                System.out.println("This is computer");
                                imageViewNew9.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_on" ,
                                        "drawable", getPackageName()));
                                imageViewNew10.setImageResource(getResources().getIdentifier(strName.toLowerCase() + "_off",
                                        "drawable", getPackageName()));
                                viewAnimatorNew4.setAlpha(0f);
                                viewAnimatorNew4.setVisibility(View.VISIBLE);
                                //set text
                                tv5.setVisibility(View.VISIBLE);
                                tv5.setText(strName);
                                myArray[which]=true;
                            }else if (viewAnimatorNew5.getVisibility() == View.GONE && !myArray[which]) {
                                System.out.println("This is computer");
                                imageViewNew11.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_on" ,
                                        "drawable", getPackageName()));
                                imageViewNew12.setImageResource(getResources().getIdentifier(strName.toLowerCase() + "_off",
                                        "drawable", getPackageName()));
                                viewAnimatorNew5.setAlpha(0f);
                                viewAnimatorNew5.setVisibility(View.VISIBLE);
                                //set text
                                tv6.setVisibility(View.VISIBLE);
                                tv6.setText(strName);
                            }else if (viewAnimatorNew6.getVisibility() == View.GONE && !myArray[which]) {
                                System.out.println("This is computer");
                                imageViewNew13.setImageResource(getResources().getIdentifier(strName.toLowerCase()+"_on" ,
                                        "drawable", getPackageName()));
                                imageViewNew14.setImageResource(getResources().getIdentifier(strName.toLowerCase() + "_off",
                                        "drawable", getPackageName()));
                                viewAnimatorNew6.setAlpha(0f);
                                viewAnimatorNew6.setVisibility(View.VISIBLE);
                                //set text
                                tv7.setVisibility(View.VISIBLE);
                                tv7.setText(strName);
                                myArray[which]=true;
                            }
                        }

                });


//        mAppearBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mImg.getVisibility() == View.GONE) {
//                    mImg.setAlpha(0f);
//                    mImg.setVisibility(View.VISIBLE);
//                } else  if (mImg1.getVisibility() == View.GONE) {
//                    mImg1.setAlpha(0f);
//                    mImg1.setVisibility(View.VISIBLE);
//                } else if (viewAnimatorNew1.getVisibility() == View.GONE){
//                    viewAnimatorNew1.setAlpha(0f);
//                    viewAnimatorNew1.setVisibility(View.VISIBLE);
//                    setva = true;
//                }
//            }
//        });

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AnimationFactory.flipTransition(viewAnimatorNew, AnimationFactory.FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener1 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AnimationFactory.flipTransition(viewAnimatorNew1, AnimationFactory.FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener2 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AnimationFactory.flipTransition(viewAnimatorNew2, AnimationFactory.FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener3 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AnimationFactory.flipTransition(viewAnimatorNew3, AnimationFactory.FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener4 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AnimationFactory.flipTransition(viewAnimatorNew4, AnimationFactory.FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener5 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AnimationFactory.flipTransition(viewAnimatorNew5, AnimationFactory.FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener6 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AnimationFactory.flipTransition(viewAnimatorNew6, AnimationFactory.FlipDirection.LEFT_RIGHT);

            }
        };

        viewAnimatorNew.setOnClickListener(listener);
        viewAnimatorNew1.setOnClickListener(listener1);
        viewAnimatorNew2.setOnClickListener(listener2);
        viewAnimatorNew3.setOnClickListener(listener3);
        viewAnimatorNew4.setOnClickListener(listener4);
        viewAnimatorNew5.setOnClickListener(listener5);
        viewAnimatorNew6.setOnClickListener(listener6);


        imageViewNew1.setOnClickListener(listener);
        imageViewNew2.setOnClickListener(listener);

        imageViewNew3.setOnClickListener(listener1);
        imageViewNew4.setOnClickListener(listener1);

        imageViewNew5.setOnClickListener(listener2);
        imageViewNew6.setOnClickListener(listener2);

        imageViewNew7.setOnClickListener(listener3);
        imageViewNew8.setOnClickListener(listener3);

        imageViewNew9.setOnClickListener(listener4);
        imageViewNew10.setOnClickListener(listener4);

        imageViewNew11.setOnClickListener(listener5);
        imageViewNew12.setOnClickListener(listener5);

        imageViewNew13.setOnClickListener(listener6);
        imageViewNew14.setOnClickListener(listener6);


    }
}
