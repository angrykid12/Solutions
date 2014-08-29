package com.hackerrank;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by m1st on 8/29/2014.
 *
 * @version 1.0
 */
public class OminousCities {

//    Logger logger = new Logger();

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

        String ceilingValue = null,
                floorValue = null,
                closestCity;

        vowelsCount = regexCount(homeCity, "[^aeiou]");
        consonantsCount = regexCount(homeCity, "[aeiou]");
        homeRating = consonantsCount / vowelsCount;
        System.out.println("homeRating: {" + homeRating + "=" + homeCity + "}");

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
            System.out.println("citiesRating.isEmpty()");
            return "NOT_FOUND";
        } else {
            System.out.println("citiesRating: " + citiesRating);
        }

        if (ceilingEntry != null) {
            ceilingRating = ceilingEntry.getKey();
            ceilingValue = ceilingEntry.getValue();
            System.out.println("ceilingRating: {" + ceilingRating + "=" + ceilingValue + "}");
        } else {
            System.out.println("ceilingRating = null");
        }

        if (floorEntry != null) {
            floorRating = floorEntry.getKey();
            floorValue = floorEntry.getValue();
            System.out.println("floorRating: {" + floorRating + "=" + floorValue + "}");
        } else {
            System.out.println("floorRating = null");
        }

        if (ceilingEntry == null & floorEntry == null) {
            System.out.println("ceilingEntry == null & floorEntry == null");
            return "NOT_FOUND";
        } else {
            homeCeilingDiff = Math.abs(homeRating - ceilingRating);
            System.out.println("homeCeilingDiff: {" + homeRating + "=" + homeCity + "} - {" + ceilingRating + "=" + ceilingValue + "} = [" + homeCeilingDiff + "]");
            homeFloorDiff = Math.abs(homeRating - floorRating);
            System.out.println("homeFloorDiff: {" + homeRating + "=" + homeCity + "} - {" + floorRating + "=" + floorValue + "} = [" + homeFloorDiff + "]");

            if (homeCeilingDiff > homeFloorDiff) {
                System.out.println("homeCeilingDiff=[" + homeCeilingDiff + "] > homeFloorDiff=[" + homeFloorDiff + "]");
                closestRating = floorRating;
            } else {
                System.out.println("homeCeilingDiff=[" + homeCeilingDiff + "] < homeFloorDiff=[" + homeFloorDiff + "]");
                closestRating = ceilingRating;
            }

            closestCity = citiesRating.get(closestRating);
            System.out.println("closestCityRating: {" + closestRating + "=" + closestCity + "}");
        }

        return closestCity;
    }

    public static void main(String[] args) {
//        assert findBestCity("Crox", new String[]{"6", "Aneeaio", "Crox", "Uniq", "Zzeta", "Crax", "Crex"});
        findBestCity("Crox", new String[]{"6", "Aneeaio", "Crox", "Uniq", "Zzeta", "вфыа", "Crax", "Crex", "Ccrex", "Cccrex"});
//        findBestCity("Crox", new String[]{"4", "Aneeaio", "Crox", "Uniq", "Zzeta"});
//        System.out.println(findBestCity("Crox", new String[]{"1", "Crox"}));
//        findBestCity("Crox", new String[]{"5", "Aneeaio", "Crox", "Uniq", "Zzeta", "Cccrex"});
//        findBestCity("Crox", new String[]{"5", "Aneeaio", "Crox", "Uniq", "Zzeta", "Ccrex"});
    }

}
