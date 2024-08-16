import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {
    public static void playBackgroundMusic(String path) {
        try {

            File audioSrc = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioSrc);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            audioClip.start();


        } catch (Exception e) {
            System.out.println("Problem with sound");
        }
    }
}
