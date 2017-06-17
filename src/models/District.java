package models;

import java.io.Serializable;

/**
 * Class used to manipulate district objects
 */
public class District implements Serializable {
    private static final long serialVersionUID = 1;
    private String name;

    public District(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

