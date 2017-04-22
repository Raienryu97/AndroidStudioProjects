package raienryu97.librarycatalog;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class Phy extends AppCompatActivity{

    public static final String JSON_URL = "http://192.168.137.201/dbConnect.php";
    //private Button buttonGet;
    private ListView listView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = (ListView) findViewById(R.id.listView);
        sendRequest();
    }


    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Phy.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        String[] new_names;
        String[] new_authors;
        String[] new_categories;
        String[] new_ids;
        String[] new_availabilities;
        int i,k;
        k=0;
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        new_names = new String[2];
        new_authors = new String[2];
        new_categories = new String[2];
        new_ids = new String[2];
        new_availabilities = new String[2];
        for(i=0;i<10;i++) {
            if (ParseJSON.categories[i].equals("Physics")) {
                new_names[k] = ParseJSON.names[i];
                new_authors[k] = ParseJSON.authors[i];
                new_categories[k] = ParseJSON.categories[i];
                new_ids[k] = ParseJSON.ids[i];
                new_availabilities[k] = ParseJSON.availabilities[i];
                CustomList cl = new CustomList(this, new_names, new_authors,
                        new_categories, new_ids, new_availabilities);
                listView.setAdapter(cl);
                k=k+1;
            }
        }
    }


    @Override
    public void onBackPressed() {
        Intent main = new Intent(Phy.this,MainActivity.class);
        main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(main);
        finish();
    }
}
