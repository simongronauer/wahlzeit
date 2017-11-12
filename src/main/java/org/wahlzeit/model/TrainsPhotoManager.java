package org.wahlzeit.model;

import java.util.logging.Logger;

public class TrainsPhotoManager extends PhotoManager {
    private static final Logger log = Logger.getLogger(TrainsPhotoManager.class.getName());


    public TrainsPhotoManager() {
        super ();
    }

    public static TrainsPhotoManager getInstance() {
        return (TrainsPhotoManager) instance;
    }
}