package com.eviro.assessment.grad001.kabeloteddymorris.demo;

import java.io.File;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile);


    File convertCSVDataToImage(String base64ImageData);
    URI createImageLink(File fileImage);
    // Additional method to persist AccountProfile in the database
    void saveAccountProfile(AccountProfile accountProfile);
//    void setImageFormat(AccountProfile accountProfile, String imageFormat);
//    void setImageData(AccountProfile accountProfile, String imageData);
//    URI createHttpImageLink(AccountProfile accountProfile);
}
