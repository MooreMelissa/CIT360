/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlhttpexample;

import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author melissamoore
 */
public class UrlHttpExample {

    private final String USER_AGENT = "Chrome";

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        UrlHttpExample hUCon = new UrlHttpExample();

        System.out.println("Testing 1 - Send Http GET request");
        hUCon.sendGet();

        System.out.println("\nTesting 2 - Sent Http POST request");
        hUCon.sendPost();
    }

    //http GET request
    private void sendGet() throws MalformedURLException, IOException {

        String url = "https://www.lds.org";

        URL site = new URL(url);
        HttpURLConnection connect = (HttpURLConnection) site.openConnection();

        // optional defoaul is GET
        connect.setRequestMethod("GET");

        // add request header
        connect.setRequestProperty("User-Agent", USER_AGENT);

        int response = connect.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + response);

        StringBuffer responses;
        try (BufferedReader inrespon = new BufferedReader(
                new InputStreamReader(connect.getInputStream()))) {
            String inputLine;
            responses = new StringBuffer();
            while ((inputLine = inrespon.readLine()) != null) {
                responses.append(inputLine);
            }
        }

        //print result
        System.out.println(responses.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL site = new URL(url);
        HttpsURLConnection connects = (HttpsURLConnection) site.openConnection();

        //add reuqest header
        connects.setRequestMethod("POST");
        connects.setRequestProperty("User-Agent", USER_AGENT);
        connects.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        connects.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(connects.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

        int responseCode = connects.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        StringBuilder response;
        try (BufferedReader inrespon = new BufferedReader(
                new InputStreamReader(connects.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = inrespon.readLine()) != null) {
                response.append(inputLine);
            }
        }

        //print result
        System.out.println(response.toString());

    }

}
