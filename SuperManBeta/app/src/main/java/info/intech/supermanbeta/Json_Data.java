package info.intech.supermanbeta;

/**
 * Created by Amin2 on 8/26/2017.
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Json_Data {
    //------------------------------delete this class------------------------------//
    private String Id;
    private String Title;
    private String Content;
    private ArrayList<String> myList;

    public Json_Data(JSONObject object) {
        try {
            this.Id = object.getString("id");
            this.Title = object.getString("title");
            this.Content = object.getString("content");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Json_Data(String Title, String Content) {
        this.Title = Title;
        this.Content = Content;
    }

    public String getId() {
        return this.Id;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
}
