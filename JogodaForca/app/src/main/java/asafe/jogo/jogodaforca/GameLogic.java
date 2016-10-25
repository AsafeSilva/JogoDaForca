package asafe.jogo.jogodaforca;

import android.widget.TextView;


/**
 * Created by Asafe on 11/09/2016.
 */
public class GameLogic {

    private static int life, points;
    private static int hits = 0;

    public static void setLife(int life){
        GameLogic.life = life;
        GameActivity.txtVidas.setText("Vidas: " + life);
    }

    public static void setPoints(int points){
        GameLogic.points = points;
        GameActivity.txtPontos.setText("Pontos: " + points);
    }

    public static void setHits(int hits){
        GameLogic.hits = hits;
    }

    public static int getLife(){ return GameLogic.life; }
    public static int getPoints(){ return GameLogic.points; }
    public static int getHits(){ return GameLogic.hits; }

    public static final int INITIAL_LIFE = 6;
    public static final int INITIAL_POINTS = 0;

}
