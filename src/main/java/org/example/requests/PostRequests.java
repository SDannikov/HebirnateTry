package org.example.requests;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class PostRequests {

    public String sendCity(String urlStr, String json) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        getOutputStream(connection, json);

        StringBuilder sb = new StringBuilder();

        sb = getInputStream(connection, sb);

        return sb.toString();
    }

    public String sendPersonByCityId(String urlStr, String json, Long cityId) throws Exception {
        URL url = new URL(urlStr + "/" + cityId + "/persons");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        getOutputStream(connection, json);

        StringBuilder sb = new StringBuilder();

        sb = getInputStream(connection, sb);

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
