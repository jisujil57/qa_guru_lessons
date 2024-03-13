package helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomDataGenerator {
    private static final Faker faker = new Faker(new Locale("en"));


    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomFullName() {
        return faker.name().fullName();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String randomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String randomYear() {
        return String.valueOf(faker.number().numberBetween(1990, 2024));
    }

    public static String randomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return faker.options().option(months);
    }

    public static String randomDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String randomPictureName() {
        String[] pictureName = {"img.png", "img2.png", "img3.png"};
        return faker.options().option(pictureName);
    }

    public static String randomSubject() {
        String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
                "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        return faker.options().option(subjects);
    }

    public static String randomHobby() {
        String[] hobbies = {"Sport", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public static String randomAddress() {
        return faker.address().fullAddress();
    }

    public static String randomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public static String randomCity(String state) {
        String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
        String[] uttarPradeshCities = {"Agra", "Lucknow", "Merrut"};
        String[] haryanaCities = {"Karnal", "Panipat"};
        String[] rajasthanCities = {"Jaipur", "Jaiselmer"};

        return switch (state) {
            case "NCR" -> faker.options().option(ncrCities);
            case "Uttar Pradesh" -> faker.options().option(uttarPradeshCities);
            case "Haryana" -> faker.options().option(haryanaCities);
            case "Rajasthan" -> faker.options().option(rajasthanCities);
            default -> throw new IllegalArgumentException("Invalid state: " + state);
        };
    }

}


