package util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Sound {

    public static void play(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("sound/" + path + ".wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

    }
}