package rest;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Евгений Дубовой on 19.10.2017.
 */
public class StaticFilesHandler implements HttpHandler {

    private final File staticFilesFolder;

    public StaticFilesHandler(String staticFilesPath) {
        this.staticFilesFolder = new File(staticFilesPath);
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {


        String query = httpExchange.getRequestURI().toString();

        File file = new File(staticFilesFolder + query);

        if (file.exists() && file.isFile()) {
            String body = FileUtils.readFileToString(file, "UTF-8");
            try (OutputStream os = httpExchange.getResponseBody()) {
                byte[] bytes = body.getBytes();
                httpExchange.sendResponseHeaders(200, bytes.length);
                os.write(bytes);
            }
        } else {
            String body = "File not found!";
            try (OutputStream os = httpExchange.getResponseBody()) {
                byte[] bytes = body.getBytes();
                httpExchange.sendResponseHeaders(404, bytes.length);
                os.write(bytes);
            }

        }
    }
}