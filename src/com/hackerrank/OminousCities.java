package com.hackerrank;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ominous Cities (Programming)
 * Say there is a country, Mgarq, that has a number of cities in it.
 * Its inhabitants consider some cities more ominous than others, but based purely on the ratio of consonants to vowels.
 * The name of the country itself ("Mgarq") would get an ominous rating of 4/1 = 4.0 (4 consonants, 1 vowel).
 * The capital city, Aneeaio is very non-ominous, with a rating of 1/6 = 0.1667.
 * Now the inhabitants like to travel, but only to other cities with a similar level of ominous-ness.
 * Write a method that one of these inhabitants can call to find out the optimal city for them to take a vacation to.
 * It takes their home city and the complete list of cities in the country,
 * and returns the city with the closest ominous rating in the country to their home city.
 * The home city should be in the list of cities in the country, but home city should not be returned as the result.
 * <p/>
 * Clarifications
 * Vowels are 'a', 'e', 'i', 'o', and 'u' (lower case and upper case). Everything else is a consonant.
 * If there is a tie, return the first city encountered in the input cities among the tie cities.
 * Return "NOT_FOUND" if no suitable city can be found.
 * <p/>
 * Example Input 1:
 * Home city: Crox
 * All cities: Aneeaio, Crox, Uniq, Zzeta
 * <p/>
 * Example Output 1:
 * Zzeta
 * <p/>
 * Format for custom test case:
 * Home City
 * # of all cities
 * City 1
 * City 2
 * ...
 * <p/>
 * Example Input for custom test case:
 * Crox
 * 4
 * Aneeaio
 * Crox
 * Uniq
 * Zzeta
 *
 * @author m1st
 * @version 1.2
 * @see <a href="http://git.io/ccOaiw">Download the most recent version here</a>
 * @since 8/30/2014
 */

//TODO: reorder "if" statements
public class OminousCities {

    private static final Logger LOGGER = Logger.getLogger(OminousCities.class.getName());

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

        double vowelsCount;
        double consonantsCount;
        double homeRating;
        double travelRating;
        double ceilingRating = 0;
        double floorRating = 0;
        double homeCeilingDiff;
        double homeFloorDiff;
        double closestRating;
        NavigableMap<Double, String> citiesRating = new TreeMap<>();
        Map.Entry<Double, String> ceilingEntry, floorEntry;
        String ceilingCity = null;
        String floorValue = null;
        String closestCity;

        vowelsCount = regexCount(homeCity, "[^aeiou]");
        consonantsCount = regexCount(homeCity, "[aeiou]");
        homeRating = consonantsCount / vowelsCount;
        LOGGER.info("homeRating: {" + homeRating + "=" + homeCity + "}");

        List<String> citiesInLatin = findCitiesInLatin(allCities);

        for (String city : citiesInLatin) {
            if (city.equals(homeCity)) {
                continue; // skips the same city to shorten calculations
            }
            vowelsCount = regexCount(city, "[^aeiou]");
            consonantsCount = regexCount(city, "[aeiou]");
            travelRating = consonantsCount / vowelsCount;
            if (citiesRating.containsKey(travelRating)) {
                continue; // skips the same travelRating to shorten calculations
            }
            citiesRating.put(travelRating, city);
        }

        ceilingEntry = citiesRating.ceilingEntry(homeRating);
        floorEntry = citiesRating.floorEntry(homeRating);

        // START: Calculation cases due to data insufficiency
        if (citiesRating.isEmpty()) {
            LOGGER.info("citiesRating.isEmpty()");
            LOGGER.info("NOT_FOUND");
            return "NOT_FOUND";
        } else {
            LOGGER.info("citiesRating: " + citiesRating);
        }

        if (ceilingEntry == null & floorEntry == null) {
            LOGGER.info("ceilingEntry == null & floorEntry == null");
            LOGGER.info("NOT_FOUND");
            return "NOT_FOUND";
        }
        if (ceilingEntry != null) {
            ceilingRating = ceilingEntry.getKey();
            if (ceilingRating == 0) {
                //TODO
            }
            ceilingCity = ceilingEntry.getValue();
            LOGGER.info("ceilingRating: {" + ceilingRating + "=" + ceilingCity + "}");
        } else {
            LOGGER.info("ceilingRating = null");
            //TODO
        }
        if (floorEntry != null) {
            floorRating = floorEntry.getKey();
            if (floorRating == 0) {
                //TODO
            }
            floorValue = floorEntry.getValue();
            LOGGER.info("floorRating: {" + floorRating + "=" + floorValue + "}");
        } else {
            LOGGER.info("floorRating = null");
            //TODO
        }

        if (ceilingRating == 0 & floorRating == 0) {
            //TODO
        } else if (ceilingRating == homeRating) {
            //TODO
        } else if (floorRating == homeRating) {
            //TODO
        }
        // END: Calculation cases due to data insufficiency

        // START: Calculation cases due to data sufficiency
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
        // END: Calculation cases due to data sufficiency

        closestCity = citiesRating.get(closestRating);
        LOGGER.info("closestCityRating: {" + closestRating + "=" + closestCity + "}");

        return closestCity;
    }

    public static void testFindBestCity() {
        // Checking VM args
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> vmArgs = runtimeMxBean.getInputArguments();
        boolean isEA = false;

        if ((!vmArgs.contains("-ea")) & (!vmArgs.contains("-enableassertions"))) {
            System.out.println("Add \"-ea\"/\"-enableassertions\" to VM options for assertions");
        } else {
            isEA = true;
        }

        // Official TC
        assert "Zzeta".equals(findBestCity("Crox", new String[]{"4", "Aneeaio", "Crox", "Uniq", "Zzeta"})) : "Test #1";
        assert "NOT_FOUND".equals(findBestCity("Crox", new String[]{"1", "Crox"})) : "Test #2";
        // My TC
        assert "Crax".equals(findBestCity("Crox", new String[]{"6", "Aneeaio", "Crox", "Uniq", "Zzeta", "Crax", "Crex"})) : "Test #3";
        assert "AAneeaio".equals(findBestCity("Aneeaio", new String[]{"6", "AAneeaio", "Aneeaio", "Crox", "Uniq", "Zzeta", "вфыа", "Crax", "Crex", "Cc5rex", "Cccrex"})) : "Test #4";
        assert "Crax".equals(findBestCity("Crox", new String[]{"6", "Aneeaio", "Crox", "Uniq", "Zzeta", "вфыа", "Crax", "Crex", "Cc5rex", "Cccrex"})) : "Test #5";
        assert "Zzeta".equals(findBestCity("Crox", new String[]{"5", "Aneeaio", "Crox", "Uniq", "Zzeta", "Cccrex"})) : "Test #6";
        assert "Ccrex".equals(findBestCity("Crox", new String[]{"5", "Aneeaio", "Crox", "Uniq", "Zzeta", "Ccrex"})) : "Test #7";

        if (isEA) {
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": All tests passed");
        }

    }

    public static void main(String[] args) {
        LOGGER.setLevel(Level.OFF); // to enable/disable logging
        testFindBestCity();
    }

}
