package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;;

public class TrainsPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(TrainsPhotoFactory.class.getName());

    protected TrainsPhotoFactory () {

    }

    public static void initialize () {
        getInstance();
    }

    /**
     * Public singleton access method.
     */
    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new TrainsPhotoFactory());
        }

        return instance;
    }

    /**
     * @methodtype factory
     */
    public TrainsPhoto createPhoto(PhotoId id, String country, int power, int topSpeed) {
        return new TrainsPhoto(id, country, power, topSpeed);
    }


    public TrainsPhoto createPhoto() {
        return new TrainsPhoto();
    }
}