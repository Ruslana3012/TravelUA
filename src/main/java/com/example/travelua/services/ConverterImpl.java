package com.example.travelua.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ConverterImpl implements Converter{
    public double convert(String currency, double amount) {
        String url_str = String.format("https://api.exchangerate.host/convert?from=UAH&to=%s&amount=%.2f", currency, amount);
        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            return jsonobj.get("result").getAsDouble();
        } catch (Exception e) {
            return  0;
        }
    }
}
