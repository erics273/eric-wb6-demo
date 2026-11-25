package com.pluralsight;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import com.pluralsight.models.Character;

public class StreamsWithObjects {

    public static void main(String[] args) {

        List<Character> characters = Arrays.asList(
                new Character("Luke Skywalker", 172, 77, "blue", "male"),
                new Character("Darth Vader", 202, 136, "yellow", "male"),
                new Character("Leia Organa", 150, 49, "brown", "female"),
                new Character("Anakin Skywalker", 188, 84, "blue", "male")
        );

        //the elevator has a weight limit of 300, total the mass of all these characters to see if they will die in the elevator
        //calculate the total mass, store it in a variable, and print it to the screen
        int totalMass = characters.stream()
                .mapToInt(character -> character.getMass())
                .sum();

        System.out.println("Total mass: " + totalMass);

        //get the average mass
        double averageMass = characters.stream()
                .mapToInt(Character::getMass)
                .average()
                .orElse(0);

        System.out.println("Average mass: " + averageMass);

        //use map to print out each name uppercase
        characters.stream()
                .map(character -> character.getName().toUpperCase())
                .forEach(System.out::println);

       characters.stream()
                .map(character -> character.getMass() * 100)
                .forEach(System.out::println);



       //create new list of charactes with a mass > 80
        List<Character> heavyCharacters = characters.stream()
                .filter(character -> character.getMass() > 80)
                .toList();

        heavyCharacters.forEach(character -> System.out.println(character.getName()));


        //find the character most likely to hit their head on a low ceiling
        //just ask for what I want, it knows how to figure it out
        int tallestHeight = characters.stream()
                .mapToInt(character -> character.getHeight())
                .max()
                .orElse(0);

        System.out.println("Tallest height: " + tallestHeight);

        //old loopy way where i have to tell it how to figure it out
        int tallest = 0;
        for (Character character : characters) {
            if (character.getHeight() > tallest) {
                tallest = character.getHeight();
            }
        }

        System.out.println("Tallest height: " + tallest);

        //get me only the blue eyed characters
        characters.stream()
                .filter(character -> character.getEyeColor().equalsIgnoreCase("blue"))
                .forEach(character -> System.out.println(character.getName()));

        boolean hasBlueEyes = characters.stream()
                .anyMatch(character -> character.getEyeColor().equalsIgnoreCase("blue"));

        if(hasBlueEyes) {
            System.out.println("at least one has blueEyes");
        }

        boolean allFemales = characters.stream()
                .allMatch(character -> character.getEyeColor().equalsIgnoreCase("female")   );

        if(allFemales) {
            System.out.println("all are Females");
        }


    }


}
