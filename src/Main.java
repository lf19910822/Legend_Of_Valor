import music.AudioPlayer;

import java.io.IOException;

public class Main {                     // the main function
    public static void main(String[] args) throws IOException, InterruptedException {
        while(true){
            AudioPlayer.play();
            WorkFlow wf = new WorkFlow();
            wf.startGame();
            break;
        }

    }


}