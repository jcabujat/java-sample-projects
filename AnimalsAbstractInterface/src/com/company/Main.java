package com.company;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Browny");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Philippine hanging parrot");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }
}
