package com.krbmsoft.volleyplus;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.krbmsoft.volleyplus.app.AppController;
import com.krbmsoft.volleyplus.app.MkRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Button submit;

    EditText name;
    EditText roll;
    EditText cls;

    ProgressDialog pDialog;

    private String URL_POST = "http://192.168.0.3/android/post/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.savebtn);
        name = (EditText) findViewById(R.id.name);
        roll = (EditText) findViewById(R.id.roll);
        cls = (EditText) findViewById(R.id.cls);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name.getText().toString());
                params.put("roll", roll.getText().toString());
                params.put("class", cls.getText().toString());

                MkRequest jsObjRequest = new MkRequest(Request.Method.POST, URL_POST, params, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                         name.setText("");
                         roll.setText("");
                         cls.setText("");

                        Toast t = Toast.makeText(getApplicationContext(),"Data Saved to Database..",Toast.LENGTH_SHORT);
                        t.show();
                        name.requestFocus();

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError response) {
                        Log.d("Response: ", response.toString());
                    }
                });
                AppController.getInstance().addToRequestQueue(jsObjRequest);


            }
        });
    }

}
