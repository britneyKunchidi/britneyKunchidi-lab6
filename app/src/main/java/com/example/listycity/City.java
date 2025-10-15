package com.example.listycity;

/**
* class that defines a city with a name and province
 */
public class City implements Comparable <City> {
    private String city;
    private String province;

    /**
     * Creates a city
     * @param city city name
     * @param province province name
     *
     */

    City (String city, String province) {
        this.city = city;
        this.province = province;
    }
    /** @return the city name */
    String getCityName(){ return this.city; }

    /** @return the province name */
    String getProvinceName() {return this.province; }
/**
 * compares this city with another city by name
 * @param other another city to compare to
 * @return 0 if equal, positive if this city comes after , negative if it comes before
 *
 */

@Override
public int compareTo (City other) {
    return this.city.compareTo(other.getCityName());
}

/**
 * Two cities are equal if both name and province match.
 * @param o the object to compare
 * @return true if equal, otherwise false
 */
@Override
public boolean equals (Object o) {
    if (this == o) return true;
    if (!(o instanceof City)) return false;
    City other = (City) o;
    return this.city.equals(other.getCityName())
            && this.province.equals(other.getProvinceName());
}
/**
 * Hashes by city name and province.
 * @return hash code consistent with equals
 */

@Override
public int hashCode() {
    int result = city.hashCode();
    result = 31 * result + province.hashCode();
    return result;
}

}