package com.kiosk.beingsrv.kiosk;

import com.kiosk.beingsrv.kiosk.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class KioskActivity extends Activity {

    private TextView mLink;
    private EditText fName;
    private EditText lName;
    private EditText eMail;
    private Button submit ;
    private CheckBox isChecked;
    private String first_name;
    private String last_name ;
    private String email_address;
    private Boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_kiosk);

        mLink = (TextView) findViewById(R.id.link);
        if (mLink != null) {
            mLink.setMovementMethod(LinkMovementMethod.getInstance());
        }

        fName = (EditText) findViewById(R.id.first_name);
        lName = (EditText) findViewById(R.id.last_name);
        eMail = (EditText) findViewById(R.id.email);
        isChecked = (CheckBox) findViewById(R.id.checkBox);
        submit = (Button) findViewById(R.id.btn_submit);

        first_name = fName.getText().toString();
        last_name = lName.getText().toString();
        email_address = eMail.getText().toString();
        check = isChecked.isChecked();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
            }
        });



    }

}
