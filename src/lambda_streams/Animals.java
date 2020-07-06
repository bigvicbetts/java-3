package lambda_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        // clean up the animals array by using the capsFirst() method. follow instructions in the method
        // definition.
        List<String> cleaned = capsFirst(animals, false);
        System.out.println(cleaned);
       
        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        //---------------------------------------

        System.out.println(sortAnimals(false));

        capsFirst(animals,true);
        System.out.println(animals);

        List<String> lowered = lowerFirst(animals,false);
        System.out.println(lowered);

        System.out.println(flipAnimals(true));

        takeListReturnList capsFirst2 = animals -> {
            animals.stream()
                    .map(String::toLowerCase)
                    .map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1))
                    .collect(Collectors.toList());
            return animals;
        };

        capsFirstLambda(animals, capsFirst2);

        takeListReturnList lowerFirst2 = animals -> {
            animals = animals.stream()
                    .map(String::toUpperCase)
                    .map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1))
                    .collect(Collectors.toList());
            //Stream.of(animals).map(String::toLowerCase).collect(Collectors.toList());
            return animals;
        };

        lowerFirstLambda(animals, lowerFirst2);

        takeListReturnList flippedAnimals2 = animals -> {
            List<String> flippedAnimals = new ArrayList<>();
            animals.stream()
                    .forEach(animal -> flippedAnimals.add(0, animal));
            animals = flippedAnimals;
            return animals;
        };

        flipAnimalsLambda(animals, flippedAnimals2);

        takeListReturnList sortAnimals2 = animals -> {
            animals = animals.stream()
                    .map(animal -> animal.toLowerCase())
                    .sorted()
                    .collect(Collectors.toList());
            return animals;
        };


        // This is the beginning of my bonus section
        takeListReturnNothing sortAnimalsAlphabetical = animals -> {
            String choice = "Alphabetical";
            animals = animals.stream()
                    .map(animal -> animal.toLowerCase())
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(choice + ": " + animals);
        };

        takeListReturnNothing sortAnimalsReversed = animals -> {
            String choice = "Reversed alphabetical";
            animals = animals.stream()
                    .map(animal -> animal.toLowerCase())
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            System.out.println(choice + ": " + animals);
        };

        takeListReturnNothing shortestToLongest = animals -> {
            String choice = "Shortest to longest";
            animals = animals.stream()
                    .map(animal -> animal.toLowerCase())
                    .sorted(Comparator.comparing(String::length))
                    .collect(Collectors.toList());
            System.out.println(choice + ": " + animals);
        };

        takeListReturnNothing longestToShortest = animals -> {
            String choice = "Longest To shortest";
            List<String> flippedAnimals = new ArrayList<>();
            animals.stream()
                    .map(animal -> animal.toLowerCase())
                    .sorted(Comparator.comparing(String::length))
                    .forEach(animal -> flippedAnimals.add(0, animal));
            animals = flippedAnimals;
            System.out.println(choice + ": " + animals);
        };

        sortAnimals(animals, sortAnimalsReversed);

        sortAnimalsLambda(animals, sortAnimals2);

    }

    interface takeListReturnList {
        List<String> takeAction(List<String> list);
    }

    interface takeListReturnNothing {
        void takeAction(List<String> list);
    }

    static List<String> capsFirstLambda(List<String> animals, takeListReturnList capsFirst) {
        System.out.println("Caps First Lambda: " + capsFirst.takeAction(animals));
        return animals;
    }

    static List<String> capsFirst(List<String> animaList, boolean mutate) {
        // clean up the animals list so that the first letter is capitalized, and all the other letters are
        // lowercased. Use a stream to accomplish this task.  Also, the 2nd parameter of this function is a
        // boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array
        // stored as a static class field.  if the flag is set to 'true', mutate the animals and return the
        // animals out of the function.  if it is false, create a copy of the animals, perform your stream
        // operations on the copy, and return the copy of animals out of the function, WITHOUT modifying the
        // original animals array.

        if (mutate) {
            animals = animals.stream()
                    .map(String::toLowerCase)
                    .map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1))
                    .collect(Collectors.toList());
            //Stream.of(animals).map(String::toLowerCase).collect(Collectors.toList());
            return animals;
        }
        else {
            List<String> newAnimalList = animals.stream()
                    .map(String::toLowerCase)
                    .map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1))
                    .collect(Collectors.toList());

            return newAnimalList;
        }
    }

    static String addAnimal(String animal) {
        //add an animal to the animal list.
        List<String> newAnimals = animals.stream().collect(Collectors.toList());    // Convert animals to a List (because right now it's basically an array and nothing can be added to it.
        newAnimals.add(animal);
        animals = newAnimals;
        return animal;
    };

    static List<String> lowerFirstLambda(List<String> animals, takeListReturnList lowerFirst) {
        System.out.println("Lower First Lambda: " + lowerFirst.takeAction(animals));
        return animals;
    }

    static List<String> lowerFirst(List<String> animaList, boolean mutate) {
        // lowercase the first letter, and uppercase the rest of the letters, using streams.  Also, depending
        // on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream
        // operations on a 'copy' of the animals list.  return the list out of hte function in both cases.
        if (mutate) {
            animaList = animaList.stream()
                    .map(String::toUpperCase)
                    .map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1))
                    .collect(Collectors.toList());
            //Stream.of(animals).map(String::toLowerCase).collect(Collectors.toList());
            return animaList;
        }
        else {
            List<String> newAnimalList = animals.stream()
                    .map(String::toUpperCase)
                    .map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1))
                    .collect(Collectors.toList());
            return newAnimalList;
        }
    }

    static List<String> flipAnimalsLambda(List<String> animals, takeListReturnList flipAnimals) {
        System.out.println("Flipped Animals Lambda: " + flipAnimals.takeAction(animals));
        return animals;
    }

    static List<String> flipAnimals(boolean mutate) {
        // reverse the order of the animals in the animal list.  If the booleaen parameter is true, reverse the
        // static animals array list by mutating the array.  if the mutate boolean is false, flip a 'copy' of
        // the animals list, then return that list of flipped animals, WITHOUT mutating the static animals
        // array. return the flipped list in both cases.

        List<String> instructions = Arrays.asList("Flip","the","animals","list","."," ","Mutate","the","animals","only","if","flag","true");

        List<String> flippedAnimals = new ArrayList<String>();
        if (mutate) {
            animals.stream()
                    .forEach(animal -> flippedAnimals.add(0, animal));
            animals = flippedAnimals;
            return animals;
        }
        animals.stream()
                .forEach(animal -> flippedAnimals.add(0, animal));
        return flippedAnimals;
    }

    static List<String> sortAnimalsLambda(List<String> animals, takeListReturnList sortAnimals) {
        System.out.println("Sorted animals: " + sortAnimals.takeAction(animals));
        return animals;
    }

    static List<String> sortAnimals(boolean mutate) {
        // sort the animals in alphabetical order.  If the booleaen parameter is true, mutating the animals
        // list.  If the mutate boolean is false, sort a 'copy' of the animals list, then return that list of
        // sorted animals, WITHOUT mutating the static animals array. return the sorted list in both cases.

        if (mutate) {
            animals = animals.stream()
                    .map(animal -> animal.toLowerCase())
                    .sorted()
                    .collect(Collectors.toList());
            return animals;
        }
        List<String> newAnimals = animals.stream()
                .map(animal -> animal.toLowerCase())
                .sorted()
                .collect(Collectors.toList());
    return newAnimals;
    }

    static void sortAnimals(List<String> animals, takeListReturnNothing choice) {
        if (choice == null) {
            animals = animals.stream()
                    .map(animal -> animal.toLowerCase())
                    .sorted()
                    .collect(Collectors.toList());
        }
        else {
            choice.takeAction(animals);
        }
    }

    }



