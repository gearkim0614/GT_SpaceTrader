package com.example.gttrader.Entity;


/**
 * enum class representing the 10 regions/buildings in the game
 */
public enum Building {

    BOBBYDODD("BobbyDodd", 33.7724, -84.3928,
            Resource.RICHSOIL, TechLevel.RENAISSANCE, 0.11),
    COC("CollegeOfComputing", 33.7774, -84.3973,
            Resource.LIFELESS, TechLevel.HITECH, 0.06),
    CRC("CRC", 33.775627, -84.403491,
            Resource.LOTSOFWATER, TechLevel.INDUSTRIAL, 0.10),
    CULC("CULC", 33.7749, -84.3964,
            Resource.MINERALPOOR, TechLevel.POSTINDISTRIAL, 0.14),
    FreshmanDorms("FreshmanDorms", 33.773412, -84.391609,
            Resource.WEIRDMUSHROOMS, TechLevel.MEDIEVAL, 0.08),
    GreekHouses("GreekHouses", 33.776669, -84.392986,
            Resource.WARLIKE, TechLevel.INDUSTRIAL, 0.10),
    NorthAveDinning("North Ave Dining", 33.771011, -84.391409,
            Resource.LOTSOFHERBS, TechLevel.RENAISSANCE, 0.11),
    StudentCenter("StudentCenter", 33.773887, -84.398766,
            Resource.NOSPECIALRESOURCES, TechLevel.EARLYINDUSTRIAL, 0.15),
    TechSquare("TechSquare", 33.7759, -84.3890,
            Resource.MINERALRICH, TechLevel.HITECH, 0.06),
    TechTower("TechTower", 33.7724, -84.3947,
            Resource.ARTISTIC, TechLevel.MEDIEVAL,0.08),
    ;

    private String name;
    private final double latitude;
    private final double longitude;
    private Resource resource;
    private final TechLevel techLevel;
    private final double salesTax;

    Building(String name, double latitude, double longitude, Resource resource, TechLevel techLevel, double salesTax) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.resource = resource;
        this.techLevel = techLevel;
        this.salesTax = salesTax;
    }

    /**
     * getter for the building name
     * @return string representing the name of the building
     */
    public String getName() {
        return name;
    }

    /**
     * setter for building name
     * @param name the new name of the building
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for building latitude
     * @return double representing the building's latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * getter for building longitude
     * @return double representing the building's longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * getter for building's resources
     * @return Resource that the building has
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * setter for building's resources
     * @param resource new resource the building should have
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * getter for tech level
     * @return Tech level of the building
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }


    /**
     * getter for sales tax
     * @return double representing the building's sales tax
     */
    public double getSalesTax() {
        return salesTax;
    }




}
