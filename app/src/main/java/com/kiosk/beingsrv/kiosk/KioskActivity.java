package com.kiosk.beingsrv.kiosk;

import com.kiosk.beingsrv.kiosk.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private String check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_kiosk);
        DbHelper dBHelper = new DbHelper(getApplicationContext());
        dBHelper.getWritableDatabase();
        mLink = (TextView) findViewById(R.id.link);
        if (mLink != null) {
            mLink.setMovementMethod(LinkMovementMethod.getInstance());
        }

        fName = (EditText) findViewById(R.id.first_name);
        lName = (EditText) findViewById(R.id.last_name);
        eMail = (EditText) findViewById(R.id.email);
        isChecked = (CheckBox) findViewById(R.id.checkBox);
        submit = (Button) findViewById(R.id.btn_submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first_name = fName.getText().toString();
                last_name = lName.getText().toString();
                email_address = eMail.getText().toString();
                Log.i("first name", first_name);
                Log.i("last name", last_name);

                if (isChecked.isChecked())
                    check = "Yes";
                else
                    check = "No";

                Log.i("ischecked", check);
                if (isValidate()) {
                    Log.i("Executed inside", "Is validate");
                    UserData data = new UserData();
                    data.set_fname(first_name);
                    data.set_lname(last_name);
                    data.set_email(email_address);
                    data.set_updatecheck(check);
                    DbHelper d = new DbHelper(getApplicationContext());
                    d.addEntry(data);
                    fName.setText("");
                    lName.setText("");
                    eMail.setText("");
                    isChecked.setChecked(false);
                }

            }
        });



    }

    protected boolean isValidate(){

        if ( fName.getText().toString().matches("")) {
            Toast.makeText(KioskActivity.this, "Please enter your first name", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (lName.getText().toString().matches("")) {
            Toast.makeText(KioskActivity.this, "Please enter your last name", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (eMail.getText().toString().matches("")) {
            Toast.makeText(KioskActivity.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }

}
