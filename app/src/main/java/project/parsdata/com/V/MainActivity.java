package project.parsdata.com.V;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.provider.Settings.Secure;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<RegisterUser> gamesList;
    String sURL = "http://beta.api.parsdata.com/Register/GetRegisterByMobile/";
    private String sActiveCode;
    private String sAndroidID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button1);
        sAndroidID = "1233";/*Secure.getString(getContentResolver(), Secure.ANDROID_ID);*/
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView txtMobile = (TextView) findViewById(R.id.txtMobileNumber);
                String sMobile = txtMobile.getText().toString();

                if (!sMobile.matches(getString(R.string.RexMobile))) {
                    Toast.makeText(MainActivity.this, getString(R.string.Mobile_No), Toast.LENGTH_SHORT).show();
                } else {

                    sURL = sURL + sMobile +"/1/"+sAndroidID+"/"+sAndroidID;
                    requestData(sURL);
                }
            }
        });
    }
    public void requestData(String uri) {

        StringRequest request = new StringRequest(uri,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        gamesList = JSONParser.parseData(response);
                        RegisterUserAdapter adapter = new RegisterUserAdapter(MainActivity.this, gamesList);

                        sActiveCode = adapter.getJson_String(0,gamesList);

                        if(sActiveCode != null)
                        {
                            Intent intent = new Intent(getApplicationContext(), ConfrimActivity.class);
                            intent.putExtra("ActiveCode", sActiveCode);
                            startActivity(intent);

                            Toast.makeText(MainActivity.this,"کد فعالسازی 62 برای شما ارسال شد.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, "tstmsg", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
