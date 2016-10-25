package asafe.jogo.jogodaforca;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Asafe on 11/09/2016.
 */
public class Dictionary {

    private ArrayList<String> Words;

    public static final int DEFAULT = 0;
    public static final int ANIMAIS = 1;
    public static final int FRUTAS = 2;
    public static final int PAISES = 3;
    public static final int BANDAS = 4;
    private static int category = DEFAULT;


    public void chooseWord(){

        if(this.getCategory() == Dictionary.DEFAULT) loadWords(Dictionary.ANIMAIS);

        if(Words.size() == 0){
            Word.setWord("Nothing");
            Word.setRealWord("Nothing");
            return;
        }

        Random random = new Random();
        int indexWord = random.nextInt(Words.size());
        Word.setWord(processString(Words.get(indexWord)));
        Word.setRealWord(Words.get(indexWord));

    }

    public void loadWords(int category){

        switch (category){
            case ANIMAIS:
                Words = Animais();
                break;
            case FRUTAS:
                Words = Frutas();
                break;
            case PAISES:
                Words = Paises();
                break;
            case BANDAS:
                Words = Bandas();
                break;
        }

        Dictionary.category = category;
    }

    public int getCategory(){
        return Dictionary.category;
    }

    private String processString(String word){
        word = word.replaceAll("[ÂÀÁÄÃ]", "A");
        word = word.replaceAll("[âãàáä]", "a");
        word = word.replaceAll("[ÊÈÉË]", "E");
        word = word.replaceAll("[êèéë]", "e");
        word = word.replaceAll("[ÎÍÌÏ]", "I");
        word = word.replaceAll("[îíìï]", "i");
        word = word.replaceAll("[ÔÕÒÓÖ]", "O");
        word = word.replaceAll("[ôõòóö]", "o");
        word = word.replaceAll("[ÛÙÚÜ]", "U");
        word = word.replaceAll("[ûúùü]", "u");
        word = word.replaceAll("Ç", "C");
        word = word.replaceAll("ç", "c");

        return word;
    }

    private ArrayList<String> Animais(){
        ArrayList<String> animais = new ArrayList<String>();

        animais.add("Abelha");
        animais.add("Águia");
        animais.add("Alce");
        animais.add("Andorinha");
        animais.add("Anta");
        animais.add("Antílope");
        animais.add("Aranha");
        animais.add("Avestruz");
        animais.add("Babuíno");
        animais.add("Baleia");
        animais.add("Barata");
        animais.add("Borboleta");
        animais.add("Burro");
        animais.add("Cabra");
        animais.add("Camelo");
        animais.add("Canguru");
        animais.add("Caracol");
        animais.add("Caranguejo");
        animais.add("Carneiro");
        animais.add("Castor");
        animais.add("Cavalo");

        return animais;
    }

    private ArrayList<String> Frutas(){
        ArrayList<String> frutas = new ArrayList<String>();

        frutas.add("Abacate");
        frutas.add("Amora");
        frutas.add("Ameixa");
        frutas.add("Acerola");
        frutas.add("Abacaxi");
        frutas.add("Açaí");
        frutas.add("Banana");
        frutas.add("Bacuri");
        frutas.add("Buriti");
        frutas.add("Butiá");
        frutas.add("Bacaba");
        frutas.add("Carambola");
        frutas.add("Cajá");
        frutas.add("Caju");
        frutas.add("Cereja");
        frutas.add("Cacau");
        frutas.add("Caqui");
        frutas.add("Cupuaçu");
        frutas.add("Graviola");
        frutas.add("Goiaba");
        frutas.add("Groselha");
        frutas.add("Guaraná");
        frutas.add("Grumixama");
        frutas.add("Guariroba");
        frutas.add("Ingá");
        frutas.add("Ibapó");
        frutas.add("Itu");
        frutas.add("Laranja");
        frutas.add("Limão");
        frutas.add("Lixia");
        frutas.add("Melancia");
        frutas.add("Mamão");
        frutas.add("Melão");
        frutas.add("Maracujá");
        frutas.add("Manga");
        frutas.add("Macadâmia");
        frutas.add("Maçã");
        frutas.add("Mangaba");
        frutas.add("Mexerica");

        return frutas;
    }

    private ArrayList<String> Paises(){
        ArrayList<String> paises = new ArrayList<String>();

        return paises;
    }

    private ArrayList<String> Bandas(){
        ArrayList<String> bandas = new ArrayList<String>();

        return bandas;
    }


}
