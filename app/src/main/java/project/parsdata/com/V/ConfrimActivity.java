package project.parsdata.com.V;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfrimActivity extends AppCompatActivity {
    SmsListener smsListener = new SmsListener();
    private ArrayList<String> UserID,AppID;
    private String sAppID;
    String sRegisterCode = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrim);


        Button btnConfirmation = (Button) findViewById(R.id.btnConfirmation);
        btnConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtConfrimCode = (TextView) findViewById(R.id.txtConfirmationCode);
                String sActivCode = txtConfrimCode.getText().toString();
                if (txtConfrimCode.getText() != null && txtConfrimCode.getText().length() == 4)
                {
                    Bundle extras = getIntent().getExtras();
                    if (extras != null)
                    {
                        sRegisterCode = extras.getString("ActiveCode");

                        if (Integer.parseInt(txtConfrimCode.getText().toString()) == Integer.parseInt(sRegisterCode))
                        {
                            startActivity(new Intent(ConfrimActivity.this,ProfileActivity.class));
                        }
                        else
                        {
                            Toast.makeText(ConfrimActivity.this,"کد فعالسازی وارد شده اشتباه می باشد.",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else if(txtConfrimCode.getText().length() != 4)
                {
                    Toast.makeText(ConfrimActivity.this,"تعداد کارکتر وارد شده کمتر از ۴ می باشد.",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(ConfrimActivity.this,"کد وارد شده اشتباه می باشد.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
