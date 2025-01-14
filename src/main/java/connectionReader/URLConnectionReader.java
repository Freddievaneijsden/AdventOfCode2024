package connectionReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();

        connection.setRequestProperty("Cookie", "_ga=GA1.2.1331110066.1733300902; _gid=GA1.2.1522666074.1736753873; session=53616c7465645f5fe5bf0416692b069f822d4ee567f9d0fced131b54c75d27227ff131f9cb17e8c003c636d0b72d88d91303ab7755b5fe5926e45a95d03b264c; _ga_MHSNPJKWC7=GS1.2.1736753873.2.1.1736754078.0.0.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);

        in.close();

        return response.toString();
    }

    public static void main(String[] args) throws Exception {
        String content = URLConnectionReader.getText(args[0]);
        System.out.println(content);
    }

}
