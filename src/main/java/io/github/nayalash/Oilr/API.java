package io.github.nayalash.Oilr;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    public String apiKey = "INSERT_MyGasFeedAPI_Key";

    private String latitude;
    private String longitude;
    private String radius;
    
    public String getLat() {
        return latitude;
    }
    
    public String getLon() {
        return longitude;   
    }
    
    public String getRadius() {
        return radius;
    }
    
    public void setLat(String latitude) {
        this.latitude = latitude;
    }
    
    public void setLon(String longitude) {
        this.longitude = longitude;
    }
    
    public void setRadius(String radius) {
        return radius;
    }


    public String fetchStaionsPrice() {

        try {

            URL url = new URL("http://api.mygasfeed.com/stations/radius/" + LAT + "/" + LONG + "/" + radius + "/reg/price/" + apiKey + ".json");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader requestReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String currentLine;
            StringBuffer rawData = new StringBuffer();

            //reading
            while ((currentLine = requestReader.readLine()) != null) {
                rawData.append(currentLine);
            }

            requestReader.close();

            JSONObject root = new JSONObject(rawData.toString());
            JSONArray stations = root.getJSONArray("stations");
            JSONObject firstStation = stations.getJSONObject(0);
            return firstStation.getString("reg_price");


        } catch (Exception e) {
            System.out.println("ERROR -> " + e.getMessage());
        }

        return null;
    }




    public String fetchStaionsAddress() {

        try {

            URL url = new URL("http://api.mygasfeed.com/stations/radius/" + LAT + "/" + LONG + "/" + radius + "/reg/price/" + apiKey + ".json");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader requestReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String currentLine;
            StringBuffer rawData = new StringBuffer();

            //reading
            while ((currentLine = requestReader.readLine()) != null) {
                rawData.append(currentLine);
            }

            requestReader.close();

            JSONObject root = new JSONObject(rawData.toString());
            JSONArray stations = root.getJSONArray("stations");
            JSONObject firstStation = stations.getJSONObject(0);
            return firstStation.getString("address");


        } catch (Exception e) {
            System.out.println("ERROR -> " + e.getMessage());
        }

        return null;
    }

    public void tryBlock() {

    }



}
