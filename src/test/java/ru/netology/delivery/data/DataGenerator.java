package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        List<String> towns = new ArrayList<>();
        towns.add("Москва");
        towns.add("Нижний Новгород");
        towns.add("Владикавказ");
        towns.add("Орёл");
        towns.add("Владивосток");
        towns.add("Иваново");
        towns.add("Саратов");

        Random random = new Random();
        String city = towns.get(random.nextInt(towns.size()));
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generateNameWithYo(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName() + "ё";
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }

        public static UserInfo generateUserYo(String locale){
            UserInfo user = new UserInfo(generateCity(locale), generateNameWithYo(locale), generatePhone(locale));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}