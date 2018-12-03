package com.cybozu.labs.langdetect.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.DetectorInitializer;
import com.cybozu.labs.langdetect.LangDetectException;

/**
 * Created on 12/3/18.
 *
 * @author sdelaysam
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DetectorInitializer.init("en", "es", "ru", "tr", "fr");

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > before) {
                    detectLanguage(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void detectLanguage(String text) {
        if (text.length() < 2) {
            textView.setText("");
        } else {
            try {
                Detector detector = DetectorFactory.create();
                detector.append(text);
                String lang = detector.detect();
                String outcome;
                switch (lang) {
                    case "en":
                        outcome = "You're speaking English";
                        break;
                    case "es":
                        outcome = "You're speaking Spanish";
                        break;
                    case "ru":
                        outcome = "You're speaking Russian";
                        break;
                    case "tr":
                        outcome = "You're speaking Turkish";
                        break;
                    case "fr":
                        outcome = "You're speaking French";
                        break;
                    default:
                        outcome = "I don't understand";
                        break;
                }
                textView.setText(outcome);
            } catch (LangDetectException e) {
                e.printStackTrace();
                textView.setText("Error occured");
            }
        }
    }


}
