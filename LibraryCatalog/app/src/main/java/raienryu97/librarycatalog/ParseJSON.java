package raienryu97.librarycatalog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {

    public static String[] names;
    public static String[] authors;
    public static String[] categories;
    public static String[] ids;
    public static String[] availabilities;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_NAME = "name";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_ID = "id";
    public static final String KEY_AVAILABILITY = "availability";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            names = new String[users.length()];
            authors = new String[users.length()];
            categories = new String[users.length()];
            ids = new String[users.length()];
            availabilities = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                names[i] = jo.getString(KEY_NAME);
                authors[i] = jo.getString(KEY_AUTHOR);
                categories[i] = jo.getString(KEY_CATEGORY);
                ids[i] = jo.getString(KEY_ID);
                availabilities[i] = jo.getString(KEY_AVAILABILITY);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
