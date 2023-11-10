package com.maksim.demo;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Result {

    void myMethod (Player p1) {



        try (
                Writer writer = new BufferedWriter(
                                new OutputStreamWriter(
                                new FileOutputStream("myFile.txt"), StandardCharsets.UTF_8));
        )

        {
            writer.write("Name: " + p1.getName());
            writer.write(System.getProperty( "line.separator" ));
            writer.write("Level: " + p1.getLevel());
            writer.write(System.getProperty( "line.separator" ));
            writer.write("Enemies defeated: " + p1.getEnemiesDefeated());
            writer.write(System.getProperty( "line.separator" ));
            writer.write("Weapons obtained: ");
            writer.write(System.getProperty( "line.separator" ));
            if (p1.getSword()) {
                writer.write("  Sword");
            }
            writer.write(System.getProperty( "line.separator" ));
            if (p1.getShield()) {
                writer.write("  Shield");
            }
            writer.write(System.getProperty( "line.separator" ));
            writer.write(System.getProperty( "line.separator" ));
            if (p1.getEnemiesDefeated() >= 3) {
                writer.write("You won!");
            } else {
                writer.write("You lost");
            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}