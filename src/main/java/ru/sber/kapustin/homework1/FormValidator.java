package ru.sber.kapustin.homework1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FormValidator {
    public final static LocalDate MIN_BIRTHDATE = LocalDate.of(1900, 1, 1);

    public static void checkName(String str) {
        if (str == null || str.length() < 2 || str.length() > 20 || !Character.isUpperCase(str.charAt(0)))
            throw new IllegalArgumentException("Invalid name format");
    }

    public static void checkBirthdate(String str) {
        try {
            final var birthdate = LocalDate.parse(str);
            final var maxBirthdate = LocalDate.now();

            if (birthdate.isBefore(MIN_BIRTHDATE) || birthdate.isAfter(maxBirthdate))
                throw new IllegalArgumentException("Invalid date of birth format");
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date of birth format");
        }
    }

    public static void checkGender(String str) throws IllegalArgumentException {
        try {
            Gender.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid gender format");
        }
    }

    public static void checkHeight(String str) throws IllegalArgumentException {
        try {
            if (Double.parseDouble(str) <= 0) {
                throw new IllegalArgumentException("Invalid height format");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid height format");
        }
    }
}

