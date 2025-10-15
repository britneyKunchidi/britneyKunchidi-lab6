package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private City mockCity() {
        return new City ("Edmonton", "Alberta");
    }

    private CityList muckCityList () {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
    }

    @Test
    void testAdd() {
        CityList cityList = new CityList();
        City city = new City ("Edmonton", "Alberta");
        cityList.add(city);

        assertEquals(1, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void hasCity_trueWhenPresent_falseWhenAbsent() {
        CityList list = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        list.add(edmonton);

        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));  // present
        assertFalse(list.hasCity(new City("Calgary", "Alberta")));  // absent
    }

    @Test
    void delete_removesExistingCity() {
        CityList list = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        list.add(edmonton);

        list.delete(new City("Edmonton", "Alberta"));
        assertEquals(0, list.countCities());
        assertFalse(list.hasCity(edmonton));
    }

    @Test
    void delete_throwsWhenMissing() {
        CityList list = new CityList();
        assertThrows(IllegalArgumentException.class,
                () -> list.delete(new City("Calgary", "Alberta")));
    }

    @Test
    void countCities_tracksAddsAndDeletes() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());

        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));
        assertEquals(2, list.countCities());

        list.delete(new City("Calgary", "Alberta"));
        assertEquals(1, list.countCities());
    }

}
