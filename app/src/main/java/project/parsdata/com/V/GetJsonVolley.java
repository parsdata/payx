package project.parsdata.com.V;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class GetJsonVolley extends AsyncTask<String,Boolean,Boolean> {
    private Context context;
    private String[] jsonobjectname;
    private String url;

    private ArrayList<ArrayList<String>> JSON_NOD_ARRAY = new ArrayList<>();
    private ProgressDialog progressDialog;


    public GetJsonVolley(Context context, String[] jsonobjectname, String url) {
        this.context=context;
        this.jsonobjectname = jsonobjectname;
        this.url=url;
    }

    @Override
    protected void onPreExecute() {
        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("لطفا صبور باشید ...");
        progressDialog.setTitle("در حال دریافت اطلاعات");
        progressDialog.setCancelable(false);
        progressDialog.show();

        for (int i = 0; i < jsonobjectname.length; i++) {
            ArrayList<String> a = new ArrayList<>();
            JSON_NOD_ARRAY.add(a);
        }

        super.onPreExecute();
    }


    @Override
    protected Boolean doInBackground(String... params) {

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = (JSONObject) response.get(i);
                                for (int j = 0; j < jsonobjectname.length; j++) {
                                    JSON_NOD_ARRAY.get(j).add(jsonObject.getString(jsonobjectname[j]));
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(req);
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
            progressDialog.dismiss();
    }


    public ArrayList<String> getJson(int position) {
        if (JSON_NOD_ARRAY.size() > 0)
            return JSON_NOD_ARRAY.get(position);
        else
            return null;
    }
    public String getJson_String(int position) {
        if (JSON_NOD_ARRAY.size() > 0) {
            String sResult = null;
            sResult = JSON_NOD_ARRAY.get(position).toString();
            return sResult;
        }
        else
            return null;
    }
}


