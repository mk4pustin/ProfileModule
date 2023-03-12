package ru.sber.kapustin.homework3;

public class Task2 {

    public static void checkIsLikeAnnotation(Class<?> checkedClass) {
        final var isLikeAnnotation = checkedClass.getAnnotation(IsLike.class);

        final var message = isLikeAnnotation != null?
                "Value in @IsLike annotation: " + isLikeAnnotation.value() :
                "@IsLike annotation not found on class " + checkedClass.getName();

        System.out.println(message);
    }
}
