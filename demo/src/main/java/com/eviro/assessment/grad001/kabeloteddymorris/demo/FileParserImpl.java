package com.eviro.assessment.grad001.kabeloteddymorris.demo;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Component
public class FileParserImpl implements  FileParser{
    private final String imageDirectory = "./images/"; // Directory to store converted images

    private final AccountProfileRepository accountProfileRepository; // Constructor injection for AccountProfileRepository
    @Autowired
    private final ResourceLoader resourceLoader;

    public FileParserImpl(AccountProfileRepository accountProfileRepository,ResourceLoader resourceLoader) {
        this.accountProfileRepository = accountProfileRepository;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void parseCSV(File csvFile) {

        Resource resource = resourceLoader.getResource("classpath:file.csv");

        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            // to Skip the header row if the CSV file has one
            reader.readLine();
            // to Read the CSV file line by line and process the data
            while ((line = reader.readLine()) != null) {
                // to split the line based on the CSV delimiter (comma in this case)
                String[] data = line.split(",");

                // I am assuming ssuming the order of data is: Name, Surname, ImageFormat, ImageData
                String name = data[0].trim();
                String surname = data[1].trim();
                String imageFormat = data[2].trim();
                String imageData = data[3].trim();

                // Create and save AccountProfile entity in the database
                AccountProfile accountProfile = new AccountProfile();
                accountProfile.setName(name);
                accountProfile.setSurname(surname);
                accountProfile.setImageFormat(imageFormat); // its Set the image format using the method
                accountProfile.setImageData(imageData); // this is to Set the image data using the method
                createHttpImageLink(accountProfile); // to also Set the HTTP image link
                accountProfileRepository.save(accountProfile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // handle any potential exceptions here
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        // CTo convert Base64 image data to a physical image file
        if (StringUtils.isEmpty(base64ImageData)) {
            return null; // This is to andle the case when base64ImageData is empty or null
        }

        byte[] imageBytes = Base64.getDecoder().decode(base64ImageData);
//        File imageFile = new File(imageDirectory + "image.png");
//        File imageFile = new File("./images/image.png");
        File imageFile = new File("src/main/resources/images/image.png");// storing as png as per the .csv table


        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            fos.write(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }

    @Override
    public URI createImageLink(File fileImage) {
        // This is to eate an HTTP link to access the physical image file
        if (fileImage == null || !fileImage.exists()) {
            return null; // This is to handle the case when the file is not available
        }

        Path path = Paths.get(fileImage.getAbsolutePath());
        return path.toUri();
    }

    @Override
    public void saveAccountProfile(AccountProfile accountProfile) {
        // This is to ave the AccountProfile entity in the database using Spring Data JPA
        accountProfileRepository.save(accountProfile);
    }
    private void setImageFormat(AccountProfile accountProfile, String imageFormat) {
        accountProfile.setImageFormat(imageFormat);
    }
    private void setImageData(AccountProfile accountProfile, String imageData) {
        accountProfile.setImageData(imageData);

    }
    // Ths is is to create an HTTP link to access the physical image file
    private URI createHttpImageLink(AccountProfile accountProfile) {
        File imageFile = convertCSVDataToImage(accountProfile.getImageData());
        if (imageFile != null) {
            setImageFormat(accountProfile, "png"); // Assuming the format is PNG for simplicity
            accountProfileRepository.save(accountProfile); // Update the entity with the image format
            return createImageLink(imageFile);
        }
        return null;
    }
    }

