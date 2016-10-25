package asafe.jogo.jogodaforca;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Asafe on 11/09/2016.
 */
public class Word{

    private Dictionary dictionary;
    private Activity activity;
    private ArrayList<Button> buttons;

    public Word(Activity activity, Dictionary dictionary, ArrayList<Button> buttons){
        this.dictionary = dictionary;
        this.activity = activity;
        this.buttons = buttons;
    }

    private static String word, realWord;

    public static void setWord(String word){ Word.word = word; }
    public static String getWord(){ return Word.word; }
    public static void setRealWord(String word){ Word.realWord = word; }
    public static String getRealWord(){ return Word.realWord; }
    public static int getSizeWord(){ return Word.word.length(); }
    public static char getChar(int index){ return Word.realWord.charAt(index); }

    public void checkLetter(char input){

        // "Pegar" as posições que contém a letra digitada
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < Word.getWord().length(); i++){
            if(Character.toLowerCase(input) == Word.getWord().toLowerCase().charAt(i)){
                indexes.add(i);
                GameLogic.setHits(GameLogic.getHits()+1);
            }
        }

        // Se letra não existe na palavra
        if(indexes.isEmpty()){
            GameLogic.setLife(GameLogic.getLife()-1);

            // se perdeu
            if(GameLogic.getLife() == 0){
                generateDialog("Você perdeu!", "Palavra: " + Word.getRealWord());
                newGame();
            }

            return;
        }

        // Se acertou letra, subistituir na palavra "invisível"
        StringBuilder tempTxtLetras = new StringBuilder(GameActivity.txtLetras.getText());
        for(int i = 0; i < indexes.size(); i++){
            char letter = Word.realWord.charAt(indexes.get(i));
            tempTxtLetras.setCharAt(indexes.get(i)*2, Character.toUpperCase(letter));
            // *2 devido aos espaços que txtLetras contém
        }

        GameActivity.txtLetras.setText(tempTxtLetras.toString());

        // Se acertou a palavra
        if(GameLogic.getHits() == Word.getWord().length()){
            GameLogic.setPoints(GameLogic.getPoints()+1);

            generateDialog("Você acertou!", "Palavra: " + Word.getRealWord());
            newWord();
        }


    }

    public void newGame(){
        dictionary.chooseWord();
        GameLogic.setLife(GameLogic.INITIAL_LIFE);
        GameLogic.setPoints(GameLogic.INITIAL_POINTS);
        GameLogic.setHits(0);

        String hiddenLetters = "";
        for(int i = 0; i < Word.getSizeWord(); i++)
            hiddenLetters += "_" + " ";

        GameActivity.txtLetras.setText(hiddenLetters.trim());

        enableButtons();
    }

    public void newWord(){
        dictionary.chooseWord();
        GameLogic.setLife(GameLogic.INITIAL_LIFE);
        GameLogic.setHits(0);

        String hiddenLetters = "";
        for(int i = 0; i < Word.getSizeWord(); i++)
            hiddenLetters += "_" + " ";

        GameActivity.txtLetras.setText(hiddenLetters.trim());

        enableButtons();
    }

    private void enableButtons(){
        for(Button b : buttons){
            Button btn = b;
            btn.setEnabled(true);
        }
    }

    private void generateDialog(String title, String message){
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);

        dialog.setTitle(title).setMessage(message).setNeutralButton("Continuar", null);
        dialog.show();
    }

    private void generateToast(CharSequence message){
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

}
