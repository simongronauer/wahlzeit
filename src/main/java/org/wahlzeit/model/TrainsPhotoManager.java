package org.wahlzeit.model;

import org.wahlzeit.model.PhotoManager;
import java.util.logging.Logger;

public class TrainsPhotoManager extends PhotoManager {
    private static final Logger log = Logger.getLogger(TrainsPhotoManager.class.getName());

    protected static final TrainsPhotoManager instance = new TrainsPhotoManager();
    
    public TrainsPhotoManager() {
        super ();
    }

    public static TrainsPhotoManager getInstance() {
        return (TrainsPhotoManager) instance;
    }
}