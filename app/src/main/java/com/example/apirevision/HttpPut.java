package com.example.apirevision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPut {

        public static void main(String[] args) throws IOException {
            // Create a URL object for the endpoint we want to hit
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // Open a connection to the URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method to PUT
            con.setRequestMethod("PUT");

            // Set the content type of the request body
            con.setRequestProperty("Content-Type", "application/json");

            // Enable output for the request body
            con.setDoOutput(true);

            // Create the JSON data we want to send in the request body
            String postData = "{\"id\":1,\"title\":\"foo\",\"body\":\"bar\",\"userId\":2}";

            // Write the JSON data to the output stream
            try (OutputStream outputStream = con.getOutputStream()) {
                byte[] input = postData.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            // Print out the response body
            System.out.println(content.toString());
        }
    }


