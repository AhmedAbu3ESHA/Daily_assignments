package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner j=new Scanner(System.in);
        String input=j.next();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.omdbapi.com/?t="+ input +"&apikey=8de0f502")
                .build();

        try (Response response = client.newCall(request).execute()) {
            //System.out.println(response.body().string());
             Gson gson=new Gson();
Film film =gson.fromJson(response.body().string(),Film.class);
            System.out.println(film.getActors());

            System.out.println("+++++++++++++++++++++++++++++++++");
            film.getRatings().forEach((m)->{
                System.out.println(m.getSource()+m.getValue());
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}