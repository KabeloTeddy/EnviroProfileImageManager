package com.eviro.assessment.grad001.kabeloteddymorris.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String httpImageLink;
    private String imageFormat;
    private String imageData;

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public void setHttpImageLink(String httpImageLink) {
        this.httpImageLink = httpImageLink;
    }
}
