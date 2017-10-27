package rest;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.Record;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Евгений Дубовой on 19.10.2017.
 */
public class AddRecordHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        Gson gson = new Gson();

        if (httpExchange.getRequestMethod().equals("POST")){
            Record addedRecord = new Record("","");
            addedRecord = gson.fromJson(new InputStreamReader(httpExchange.getRequestBody()), Record.class);
            String body = addedRecord.getBody();
        }

        System.out.println(Record.records.isEmpty());

    }
}
