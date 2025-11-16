import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", port), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        System.out.println("✅ Server started at http://0.0.0.0:" + port);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String timeStamp = new SimpleDateFormat("EEEE, MMMM dd yyyy HH:mm:ss").format(new Date());
            String response = "<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                    "<title>Hello Docker - Main Branch</title>" +
                    "<style>" +
                    "body { font-family: Arial; background: aqua; color: black; text-align: center; padding-top: 50px; }" +
                    "h1 { font-size: 3em; }" +
                    "h2 { font-size: 2em; }" +
                    "footer { margin-top: 50px; font-size: 0.9em; opacity: 0.8; }" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<h1>🚀 Hello, Docker from <span style='color:darkblue'>Main Branch!</span></h1>" +
                    "<p>Current date and time:</p>" +
                    "<h2>" + timeStamp + "</h2>" +
                    "<footer>Powered by Java & Docker (Prod Branch)</footer>" +
                    "</body>" +
                    "</html>";

            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
