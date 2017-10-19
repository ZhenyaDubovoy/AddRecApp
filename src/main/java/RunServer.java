import com.sun.net.httpserver.HttpServer;
import rest.AddRecordHandler;

import java.net.InetSocketAddress;

/**
 * Created by Евгений Дубовой on 19.10.2017.
 */
public class RunServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8000), 0);


        server.createContext("/add-record", new AddRecordHandler());

    }

}
