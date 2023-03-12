package ru.sber.kapustin.homework3;

import java.util.*;

public class Task4 {

    public static Set<Class<?>> getAllInterfaces(Class<?> c) {
        final var interfaces = new HashSet<Class<?>>();
        getAllInterfacesRecursive(c, interfaces);

        return interfaces;
    }

    private static void getAllInterfacesRecursive(Class<?> c, Set<Class<?>> interfaces) {
       final var currentInterfaces = c.getInterfaces();

        interfaces.addAll(Arrays.asList(currentInterfaces));

        if (c.getSuperclass() != null) getAllInterfacesRecursive(c.getSuperclass(), interfaces);
        Arrays.stream(currentInterfaces).forEach(i -> getAllInterfacesRecursive(i, interfaces));
    }
}
