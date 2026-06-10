package com.project.aiimagedetector.controller;

import com.project.aiimagedetector.dto.PredictionResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class UploadController {

    @PostMapping("/upload")
    public String uploadImage(
            @RequestParam("image") MultipartFile image,
            Model model) {

        try {

            URL url = new URL("http://localhost:5000/predict");
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String boundary = "Boundary-" + System.currentTimeMillis();

            connection.setRequestProperty(
                    "Content-Type",
                    "multipart/form-data; boundary=" + boundary);

            OutputStream outputStream =
                    connection.getOutputStream();

            PrintWriter writer =
                    new PrintWriter(
                            new OutputStreamWriter(
                                    outputStream, "UTF-8"), true);

            writer.append("--").append(boundary).append("\r\n");
            writer.append(
                    "Content-Disposition: form-data; name=\"image\"; filename=\""
                            + image.getOriginalFilename() + "\"\r\n");
            writer.append(
                    "Content-Type: application/octet-stream\r\n\r\n");

            writer.flush();

            outputStream.write(image.getBytes());

            outputStream.flush();

            writer.append("\r\n");
            writer.append("--").append(boundary)
                    .append("--").append("\r\n");

            writer.close();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));

            StringBuilder response =
                    new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            JSONObject json =
                    new JSONObject(response.toString());

            model.addAttribute(
                    "filename",
                    image.getOriginalFilename());

            model.addAttribute(
                    "result",
                    json.getString("prediction"));

            model.addAttribute(
                    "confidence",
                    json.getDouble("confidence"));

            return "result";

        } catch (Exception e) {

            model.addAttribute(
                    "filename",
                    image.getOriginalFilename());

            model.addAttribute(
                    "result",
                    "Error");

            model.addAttribute(
                    "confidence",
                    0);

            return "result";
        }
    }
}