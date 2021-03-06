package kz.softeng.sdu.SmartHouse;


import Animation.AnimationFactory;
import Animation.AnimationFactory.FlipDirection;
import Animation.AnimationFactory.*;

import android.app.Activity;
import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sayazhan on 06.05.2015.
 */
public class MainView extends Activity implements RecognitionListener {

    private SpeechRecognizer speech = null;
    private Intent recognizerIntent;

    private boolean bnewauto=false, notcorrect=false;

    private boolean svet = false, devices = false, cleanhouse = false, garage = false, doors = false, security = false, wifi=false;

    private ViewAnimator viewAnimator, viewAnimator1, viewAnimator2, viewAnimator3, viewAnimator4, viewAnimator5, viewAnimator6, viewAnimator7;

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9,
            imageView10, imageView11, imageView12, imageView13, imageView15;

    private String[] snew, knew;

    private boolean nosuchcommand=false, error=false;

    private boolean hello = true;

    //Text To Speech instance
    private TextToSpeech tts;

    @Override
    public void onCreate(Bundle savedInstateState) {
        super.onCreate(savedInstateState);
        setContentView(R.layout.view);
//
//        getActionBar().hide();

        speechaction();

        speech = SpeechRecognizer.createSpeechRecognizer(this);
        speech.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);

        final View touchView = findViewById(R.id.mainView);
        touchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("HELLO:     ssss");
                if (hello) {
                    speech.startListening(recognizerIntent);
                    hello = false;
                }

//                Toast.makeText(getApplication(), "Touch coordinates : " +
//                        String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        viewAnimator = (ViewAnimator) this.findViewById(R.id.viewFlipper);
        viewAnimator1 = (ViewAnimator) this.findViewById(R.id.viewFlipper1);
        viewAnimator2 = (ViewAnimator) this.findViewById(R.id.viewFlipper2);
        viewAnimator3 = (ViewAnimator) this.findViewById(R.id.viewFlipper3);
        viewAnimator4 = (ViewAnimator) this.findViewById(R.id.viewFlipper4);
        viewAnimator5 = (ViewAnimator) this.findViewById(R.id.viewFlipper5);
        viewAnimator6 = (ViewAnimator) this.findViewById(R.id.viewFlipper6);
        viewAnimator7 = (ViewAnimator) this.findViewById(R.id.viewFlipper7);

        imageView1 = (ImageView) this.findViewById(R.id.imageView1);
        imageView2 = (ImageView) this.findViewById(R.id.imageView2);

        imageView3 = (ImageView) this.findViewById(R.id.imageView3);
        imageView4 = (ImageView) this.findViewById(R.id.imageView4);

        imageView5 = (ImageView) this.findViewById(R.id.imageView5);
        imageView6 = (ImageView) this.findViewById(R.id.imageView6);

        imageView7 = (ImageView) this.findViewById(R.id.imageView7);
        imageView8 = (ImageView) this.findViewById(R.id.imageView8);

        imageView9 = (ImageView) this.findViewById(R.id.imageView9);
        imageView10 = (ImageView) this.findViewById(R.id.imageView10);

        imageView11 = (ImageView) this.findViewById(R.id.imageView11);
        imageView12 = (ImageView) this.findViewById(R.id.imageView12);

        imageView13 = (ImageView) this.findViewById(R.id.imageView13);

        imageView15 = (ImageView) this.findViewById(R.id.imageView15);


        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(imageView1.isPressed()){
                    svet=true;
                }else{
                    svet=false;
                }
                AnimationFactory.flipTransition(viewAnimator, FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener1 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(imageView3.isPressed()){
                    security=true;
                }else{
                    security=false;
                }
                AnimationFactory.flipTransition(viewAnimator1, FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener2 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(imageView5.isPressed()){
                    cleanhouse=true;
                }else{
                    cleanhouse=false;
                }
                AnimationFactory.flipTransition(viewAnimator2, FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener3 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(imageView7.isPressed()){
                    garage=true;
                }else{
                    garage=false;
                }
                AnimationFactory.flipTransition(viewAnimator3, FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener4 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(imageView9.isPressed()){
                    wifi=true;
                }else{
                    wifi=false;
                }
                AnimationFactory.flipTransition(viewAnimator4, FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener5 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(imageView11.isPressed()){
                    doors=true;
                }else{
                    doors=false;
                }
                AnimationFactory.flipTransition(viewAnimator5, FlipDirection.LEFT_RIGHT);

            }
        };
        View.OnClickListener listener6 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), Temperature.class));

                MainView.this.overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);

            }
        };
        View.OnClickListener listener7 = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), Devices.class));

                MainView.this.overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
            }
        };

        viewAnimator.setOnClickListener(listener);
        viewAnimator1.setOnClickListener(listener1);
        viewAnimator2.setOnClickListener(listener2);
        viewAnimator3.setOnClickListener(listener3);
        viewAnimator4.setOnClickListener(listener4);
        viewAnimator5.setOnClickListener(listener5);
        viewAnimator6.setOnClickListener(listener6);
        viewAnimator7.setOnClickListener(listener7);

        imageView1.setOnClickListener(listener);
        imageView2.setOnClickListener(listener);

        imageView3.setOnClickListener(listener1);
        imageView4.setOnClickListener(listener1);

        imageView5.setOnClickListener(listener2);
        imageView6.setOnClickListener(listener2);

        imageView7.setOnClickListener(listener3);
        imageView8.setOnClickListener(listener3);

        imageView9.setOnClickListener(listener4);
        imageView10.setOnClickListener(listener4);

        imageView11.setOnClickListener(listener5);
        imageView12.setOnClickListener(listener5);

        imageView13.setOnClickListener(listener6);

        imageView15.setOnClickListener(listener7);

    }

    @Override
    public void onResults(Bundle results) {
        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String text = "";
        text = matches.get(0);

        System.out.println("This is text: " + text);
        snew = new String[10];
        knew = new String[10];

        snew = text.split(" ");
        for (int i = 0; i < snew.length; i++) {
            knew[i] = snew[i];
        }
         if (snew.length>=4){
            Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT).show();
             error=true;
        }else {
             if(snew.length==2){
                 knew[2]="";
             }
             if (knew[2].equals("light")) {
                 System.out.println("Find svet");
                 if (knew[1].equals("off") && svet) {
                     AnimationFactory.flipTransition(viewAnimator, FlipDirection.LEFT_RIGHT);
                     svet = false;
                 } else if (knew[1].equals("on") && !svet) {
                     AnimationFactory.flipTransition(viewAnimator, FlipDirection.LEFT_RIGHT);
                     svet = true;
                 }
             } //clean house
             else if (knew[1].equals("house")) {
                 System.out.println("Find electro");
                 if (knew[2].equals("off") && cleanhouse) {
                     AnimationFactory.flipTransition(viewAnimator2, FlipDirection.LEFT_RIGHT);
                     cleanhouse = false;
                 } else if (knew[2].equals("on") && !cleanhouse) {
                     AnimationFactory.flipTransition(viewAnimator2, FlipDirection.LEFT_RIGHT);
                     cleanhouse = true;
                 }
             } else if (knew[1].equals("garage")) {
                 System.out.println("Find garrage");
                 if (knew[0].equals("close") && garage) {
                     AnimationFactory.flipTransition(viewAnimator3, FlipDirection.LEFT_RIGHT);
                     garage = false;
                 } else if (knew[0].equals("open") && !garage) {
                     AnimationFactory.flipTransition(viewAnimator3, FlipDirection.LEFT_RIGHT);
                     garage = true;
                 }
             } else if (knew[2].equals("doors")) {
                 System.out.println("Find doors");
                 if (knew[0].equals("lock") && doors) {
                     AnimationFactory.flipTransition(viewAnimator5, FlipDirection.LEFT_RIGHT);
                     doors = false;
                 } else if (knew[0].equals("open") && !doors) {
                     AnimationFactory.flipTransition(viewAnimator5, FlipDirection.LEFT_RIGHT);
                     doors = true;
                 }
             } else if (knew[2].equals("security")) {
                 System.out.println("Find security");
                 if (knew[1].equals("off") && security) {
                     AnimationFactory.flipTransition(viewAnimator1, FlipDirection.LEFT_RIGHT);
                     security = false;
                 } else if (knew[1].equals("on") && !security) {
                     AnimationFactory.flipTransition(viewAnimator1, FlipDirection.LEFT_RIGHT);
                     security = true;
                 }
             } else if (knew[2].equals("WiFi") || knew[2].equals("wifi")) {
                 System.out.println("Find wifi");
                 if (knew[1].equals("off") && wifi) {
                     AnimationFactory.flipTransition(viewAnimator4, FlipDirection.LEFT_RIGHT);
                     wifi = false;
                 } else if (knew[1].equals("on") && !wifi) {
                     AnimationFactory.flipTransition(viewAnimator4, FlipDirection.LEFT_RIGHT);
                     wifi = true;
                 }
             } else if (knew[1].equals("temperature")) {
                 System.out.println("Find temperature");
                 if (knew[0].equals("open")) {
                     startActivity(new Intent(getApplication(), Temperature.class));

                     MainView.this.overridePendingTransition(android.R.anim.slide_in_left,
                             android.R.anim.slide_out_right);
                 }
             } else if (knew[1].equals("devices")) {
                 System.out.println("Find devices");
                 if (knew[0].equals("open")) {
                     startActivity(new Intent(getApplication(), Devices.class));
                 }

             }else if(knew[1].equals("light")){
                 if(knew[0].equals("open")) {
                     startActivity(new Intent(getApplication(), Lights.class));

                     MainView.this.overridePendingTransition(android.R.anim.slide_in_left,
                             android.R.anim.slide_out_right);
                 }

             }
             else{
                 nosuchcommand = true;
                 Toast.makeText(getApplication(), "No such command!", Toast.LENGTH_SHORT).show();
             }
         }
        speechaction();
        return;
    }
    private void speechaction() {
        tts = new TextToSpeech(MainView.this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.US);
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueID");


                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("error", "This Language is not supported");
                    } else if (!bnewauto) {
                        tts.speak("Welcome to main menu. What would you like to do?", TextToSpeech.QUEUE_FLUSH, map);
                        bnewauto = true;
                    } else if (bnewauto && !notcorrect && !nosuchcommand && !error) {
                        tts.speak("Roger that.", TextToSpeech.QUEUE_FLUSH, map);
                    } else if (nosuchcommand || error){
                        tts.speak("No such command.",TextToSpeech.QUEUE_FLUSH, map);
                        nosuchcommand=false;
                        error=false;
                    }
                }
            }
        });
    }
    @Override
    public void onResume() {
        speech = SpeechRecognizer.createSpeechRecognizer(this);
        speech.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (speech != null) {
            speech.destroy();
            System.out.println("Method: onPause");
        }
    }

    @Override
    public void onEndOfSpeech() {
        speech.stopListening();
        hello = true;
        System.out.println("Method: stopListening");
    }

    @Override
    public void onError(int i) {
        String errorMessage = getErrorText(i);
        Toast.makeText(getApplication(), "ERROR" + errorMessage, Toast.LENGTH_SHORT).show();
        speech.stopListening();
        hello = true;
        System.out.println("Method: onError");
    }



    @Override
    public void onDestroy() {

        speech.destroy();
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }

        public static String getErrorText(int errorCode) {
            String message;
            switch (errorCode) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "Audio recording error";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "Client side error";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "Insufficient permissions";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "Network error";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "Network timeout";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "No match";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RecognitionService busy";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "error from server";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "No speech input";
                    break;
                default:
                    message = "Didn't understand, please try again.";
                    break;
            }
            return message;
        }
}

