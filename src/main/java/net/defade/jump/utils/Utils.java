package net.defade.jump.utils;

public class Utils {
    /**
     * Converts time in milliseconds to a human-readable format (HH:mm:ss).
     *
     * @param milliseconds Time in milliseconds.
     * @return A string representing the time in the format HH:mm:ss.
     */
    public static String convertToReadableTime(long milliseconds) {
        long ms = milliseconds % 1000;
        long seconds = (milliseconds / 1000) % 60;
        long minutes = (milliseconds / (1000 * 60)) % 60;
        long hours = (milliseconds / (1000 * 60 * 60)) % 24;

        if (hours > 0) {
            return String.format("%dh %02dm %02ds %03dms", hours, minutes, seconds, ms);
        } else {
            return String.format("%02dm %02ds %03dms", minutes, seconds, ms);
        }
    }
}
