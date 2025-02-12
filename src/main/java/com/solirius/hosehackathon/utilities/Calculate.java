package com.solirius.hosehackathon.utilities;

import java.time.Duration;

public class Calculate {

    /**
     *
     * @param milesDistance
     * @param duration
     * @return the resulting speed as milesDistance/hour
     */
    public static double speed(double milesDistance, Duration duration){
        //Calculate speed
        double secondsToHour = 3600L;
        double toHours = duration.getSeconds()/secondsToHour;
        if (duration.isZero()) {
            return 0;
        } else {
            return milesDistance/toHours;
        }
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        //Calculate distance
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) *
                Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
