package ru.sber.kapustin.homework3;

import java.lang.reflect.*;

public class Task3 {

    public static void main(String[] args) {
        final var printer = new APrinter();
        final var printerClass = printer.getClass();

        try {
            final var printMethod = printerClass.getMethod("print", int.class);
            printMethod.invoke(printer, 0);

        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("invoke() arguments error: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.err.println("Error when calling method: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("No access to method: " + e.getMessage());
        }
    }
}

