package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгений Дубовой on 19.10.2017.
 */
public class Record {

    public static List<Record> records = new ArrayList<>();

    private String title;
    private String body;

    public Record(String body, String title) {
        this.body = body;
        this.title = title;

        Record.records.add(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
