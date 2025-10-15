package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages a list of City objects and provides methods
 * to add, remove, count, and check for cities.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it is not already in the list.
     * @param city the City to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * returns a list of cities sorted by name
     * @return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a given city exists in the list.
     * @param city the City to check
     * @return true if the city is in the list, otherwise false
     */

    public boolean hasCity (City city) {
        return cities.contains(city);
    }

    /**
     * Removes the specified city from the list.
     * @param city the City to remove
     * @throws IllegalArgumentException if the city does not exist
     */

    public void delete (City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found: " + city.getCityName());
        }
        cities.remove(city);
        }

    /**
     * Returns the number of cities currently in the list.
     * @return the count of cities
     */
    public int countCities() {
        return cities.size();
    }
}
