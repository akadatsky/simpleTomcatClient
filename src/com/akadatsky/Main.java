package com.akadatsky;

import com.akadatsky.model.Message;
import com.akadatsky.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class Main {

    private static final String URL = "http://127.0.0.1:12345/my_api/";

    private static Gson gson = new GsonBuilder().create();

    public static void main(String[] args) {
        Message messageForSend = new Message("TEST TEST TEST");
        String json = gson.toJson(messageForSend);

        try {
            String response = sendPostRequest(json);
            Message receivedMessage = gson.fromJson(response, Message.class);
            System.out.println("Message from server: " + receivedMessage.getText());
        } catch (Exception e) {
            System.out.println("Can't parse response from server");
        }
    }

    private static String sendPostRequest(String json) {
        return HttpUtil.sendRequest(URL, null, json);
    }

}
