package com.hackerrank;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by m1st on 8/29/2014.
 *
 * @version 1.0
 */
public class OminousCities {

    private final static Logger LOGGER = Logger.getLogger(OminousCities.class.getName());

    public static ArrayList<String> findCitiesInLatin(String[] allCities) {
        Pattern latinPattern = Pattern.compile("[a-z]+");
        ArrayList<String> result = new ArrayList<>();
        for (String city : allCities) {
            Matcher latinMatcher = latinPattern.matcher(city.toLowerCase());
            if (latinMatcher.matches()) {
                result.add(city);
            }
        }
        return result;
    }

    public static int regexCount(String input, String pattern) {
        return input.toLowerCase().replaceAll(pattern, "").length();
    }

    static String findBestCity(String homeCity, String[] allCities) {

        double vowelsCount,
                consonantsCount,
                homeRating,
                travelRating,
                ceilingRating = 0,
                floorRating = 0,
                homeCeilingDiff,
                homeFloorDiff,
                closestRating;

        NavigableMap<Double, String> citiesRating = new TreeMap<>();

        Map.Entry<Double, String> ceilingEntry, floorEntry;

        String ceilingCity = null,
                floorValue = null,
                closestCity;

        vowelsCount = regexCount(homeCity, "[^aeiou]");
        consonantsCount = regexCount(homeCity, "[aeiou]");
        homeRating = consonantsCount / vowelsCount;
        LOGGER.info("homeRating: {" + homeRating + "=" + homeCity + "}");

        List<String> citiesInLatin = findCitiesInLatin(allCities);

        for (String city : citiesInLatin) {
            if (city.equals(homeCity)) {
                continue;
            }
            vowelsCount = regexCount(city, "[^aeiou]");
            consonantsCount = regexCount(city, "[aeiou]");
            travelRating = consonantsCount / vowelsCount;
            if (citiesRating.containsKey(travelRating)) {
                continue;
            }
            citiesRating.put(travelRating, city);
        }

        ceilingEntry = citiesRating.ceilingEntry(3.0);
        floorEntry = citiesRating.floorEntry(3.0);

        if (citiesRating.isEmpty()) {
            LOGGER.info("citiesRating.isEmpty()");
            LOGGER.info("NOT_FOUND");
            return "NOT_FOUND";
        } else {
            LOGGER.info("citiesRating: " + citiesRating);
        }

        if (ceilingEntry != null) {
            ceilingRating = ceilingEntry.getKey();
            ceilingCity = ceilingEntry.getValue();
            LOGGER.info("ceilingRating: {" + ceilingRating + "=" + ceilingCity + "}");
        } else {
            LOGGER.info("ceilingRating = null");
        }

        if (floorEntry != null) {
            floorRating = floorEntry.getKey();
            floorValue = floorEntry.getValue();
            LOGGER.info("floorRating: {" + floorRating + "=" + floorValue + "}");
        } else {
            LOGGER.info("floorRating = null");
        }

        if (ceilingEntry == null & floorEntry == null) {
            LOGGER.info("ceilingEntry == null & floorEntry == null");
            LOGGER.info("NOT_FOUND");
            return "NOT_FOUND";
        } else {
            homeCeilingDiff = Math.abs(homeRating - ceilingRating);
            LOGGER.info("homeCeilingDiff: {" + homeRating + "=" + homeCity + "} - {" + ceilingRating + "=" + ceilingCity + "} = [" + homeCeilingDiff + "]");
            homeFloorDiff = Math.abs(homeRating - floorRating);
            LOGGER.info("homeFloorDiff: {" + homeRating + "=" + homeCity + "} - {" + floorRating + "=" + floorValue + "} = [" + homeFloorDiff + "]");

            if (homeCeilingDiff > homeFloorDiff) {
                LOGGER.info("homeCeilingDiff=[" + homeCeilingDiff + "] > homeFloorDiff=[" + homeFloorDiff + "]");
                closestRating = floorRating;
            } else {
                LOGGER.info("homeCeilingDiff=[" + homeCeilingDiff + "] < homeFloorDiff=[" + homeFloorDiff + "]");
                closestRating = ceilingRating;
            }

            closestCity = citiesRating.get(closestRating);
            LOGGER.info("closestCityRating: {" + closestRating + "=" + closestCity + "}");
        }

        return closestCity;
    }

    public static void testCase() {
        //official TC
        assert "Zzeta".equals(findBestCity("Crox", new String[]{"4", "Aneeaio", "Crox", "Uniq", "Zzeta"}));
        assert "NOT_FOUND".equals(findBestCity("Crox", new String[]{"1", "Crox"}));
        //my TC
        assert "Crax".equals(findBestCity("Crox", new String[]{"6", "Aneeaio", "Crox", "Uniq", "Zzeta", "Crax", "Crex"}));
        assert "Crax".equals(findBestCity("Crox", new String[]{"6", "Aneeaio", "Crox", "Uniq", "Zzeta", "вфыа", "Crax", "Crex", "Cc5rex", "Cccrex"}));
        assert "Zzeta".equals(findBestCity("Crox", new String[]{"5", "Aneeaio", "Crox", "Uniq", "Zzeta", "Cccrex"}));
        assert "Ccrex".equals(findBestCity("Crox", new String[]{"5", "Aneeaio", "Crox", "Uniq", "Zzeta", "Ccrex"}));
    }

    public static void main(String[] args) {
        LOGGER.setLevel(Level.ALL);
        testCase();

    }

}
