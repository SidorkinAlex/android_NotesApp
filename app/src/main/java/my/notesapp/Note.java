package my.notesapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Note implements Serializable {
    private UUID id;
    private Date time;
    private String title;
    private String description;
    SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
    public Note(JSONObject jsonNote){
        try {
            id = UUID.fromString(jsonNote.getString("id"));
            time =  new Date(jsonNote.getLong("time"));
            title =  jsonNote.getString("title");
            description =  jsonNote.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Note() {
        id = UUID.randomUUID();
    }

    public String getDate(){
        String date = formatDate.format(time);
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
