package music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {              // a player to play music
    private Clip clip;
    private final String filePath;
    private static AudioPlayer instance = null;

    private AudioPlayer() {
        this.filePath = "music/RedRockRiviera.wav";
    }
    private void load() {
        try {
            File audioFile = new File(filePath);
            if (!audioFile.exists()) {
                System.out.println("missing data：" + filePath);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public static void play() {
        if( instance == null ) {
            instance = new AudioPlayer();
        }
        instance.load();
        instance.loop();
    }
}