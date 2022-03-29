package com.techelevator;

import java.awt.*;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("*** Hello and welcome to Vendo-Matic 800! TEST ***");
        System.out.println("****** Brought to you by Umbrella Corp! ******");
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
    }
}
