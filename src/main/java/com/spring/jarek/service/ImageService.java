package com.spring.jarek.service;

import com.spring.jarek.dto.PixelRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    public Resource getImage() throws MalformedURLException {
        Path path = Paths.get("src/main/resources/static/image.jpg");
        // Load the resource
        return new UrlResource(path.toUri());
    }

    public void setPixel(PixelRequest pixelRequest) throws IOException {
        Resource resource = new UrlResource(Paths.get("src/main/resources/static/image.jpg").toUri());
        InputStream inputStream = resource.getInputStream();
        BufferedImage image = ImageIO.read(inputStream);
        System.out.println(pixelRequest);

        image.setRGB(pixelRequest.getX(), pixelRequest.getY(), Color.RED.getRGB());

        File outputFile = new File("C:\\Users\\Jarek\\Desktop\\jarek\\src\\main\\resources\\static\\image2.jpg");
        ImageIO.write(image, "jpeg", outputFile);
    }
}
