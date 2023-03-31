package com.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class Gpt3Service {

    private static final String API_KEY = "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"; // 여기에 발급받은 API 키를 입력하세요.
    private static final String MODEL = "text-davinci-002";

    public String generateAnswer(String prompt) {
        String apiUrl = "https://api.openai.com/v1/engines/" + MODEL + "/completions";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setDoOutput(true);

            String requestBody = String.format(
                "{\"prompt\": \"%s\", \"max_tokens\": 150, \"n\": 1, \"temperature\": 0.5, \"top_p\": 1, \"stop\": null}",
                prompt
            );

            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.write(requestBody.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder response = new StringBuilder();
                try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    String inputLine;
                    while ((inputLine = inputReader.readLine()) != null) {
                        response.append(inputLine);
                    }
                }
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> responseMap = objectMapper.readValue(response.toString(), Map.class);
                Map<String, Object> choices = (Map<String, Object>) ((List<?>) responseMap.get("choices")).get(0);
                return (String) choices.get("text");
            } else {
                return "Error occurred while generating the answer. Response code: " + responseCode;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        	return "Error occurred while generating the answer.";
        	}
		}
	}
