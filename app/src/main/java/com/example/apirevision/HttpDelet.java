package com.example.apirevision;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpDelet {

        public static void main(String[] args) throws IOException {
            // Create a URL object for the endpoint we want to hit
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // Open a connection to the URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method to DELETE
            con.setRequestMethod("DELETE");

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
