package tn.pi.services;

import org.springframework.stereotype.Service;

/**
 * @author Oan Stultjens
 * @author spring.io
 * Properties for the file upload location
 */

@Service
public class StorageProperties {
int dec ;
    private String location = "upload";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
