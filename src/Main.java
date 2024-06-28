/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : D
 * Group    : 06
 * Members  :
 * 1. 5026231105 Mirza Fathi Taufiqurrahman
 * 2. 5026231072 Arrivo Arsa Mevano
 * 3. 5026231129 Rafindita Sumar Ramadhan
 * ------------------------------------------------------
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import javax.sound.sampled.*;
public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("src/Soundtreck.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        SnL g1 = new SnL(100);
        g1.play();
    }
}
