package org.example.requests;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@Component
public class GetRequests {

    public String getCityByName(String urlStr, String name) throws Exception{
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }

        return sb.toString();
    }

    private void getOutputStream(HttpURLConnection connection, String json) throws IOException {
        try (OutputStream os = new BufferedOutputStream(connection.getOutputStream())) {
            byte[] bytes = json.getBytes("UTF-8");

            os.write(bytes, 0, bytes.length);
        }
    }

    private StringBuilder getInputStream(HttpURLConnection connection, StringBuilder sb) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb;
    }
}
