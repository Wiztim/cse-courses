package com.torlov.cseeleven;

public class Open1A {
    public static void main(String args[]) {
        Dog germanShepard = new Dog("German Shepard");
        Cat tabby = new Cat("Tabby");

        System.out.println("The dog's breed is: " + germanShepard.breed);
        System.out.println("The cat's breed is: " + tabby.breed);
    }
}

class Dog {
    String breed;

    Dog(String breed) {
        this.breed = breed;
    }
}

class Cat {
    String breed;

    Cat(String breed) {
        this.breed = breed;
    }
}
