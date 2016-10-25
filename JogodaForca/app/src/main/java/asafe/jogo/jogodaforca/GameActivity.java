package asafe.jogo.jogodaforca;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPalavra;
    private ArrayList<Button> buttons;
    public static TextView txtVidas, txtPontos;
    public static TextView txtLetras;

    private Dictionary dictionary;
    private Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttons = new ArrayList<Button>();
        txtVidas    = (TextView)findViewById(R.id.txtVidas);
        txtPontos   = (TextView)findViewById(R.id.txtPontos);
        txtLetras   = (TextView)findViewById(R.id.txtLetras);
        btnPalavra = (Button)findViewById(R.id.btnPalavra);

        buttons.add((Button)findViewById(R.id.btnA));
        buttons.add((Button)findViewById(R.id.btnB));
        buttons.add((Button)findViewById(R.id.btnC));
        buttons.add((Button)findViewById(R.id.btnD));
        buttons.add((Button)findViewById(R.id.btnE));
        buttons.add((Button)findViewById(R.id.btnF));
        buttons.add((Button)findViewById(R.id.btnG));
        buttons.add((Button)findViewById(R.id.btnH));
        buttons.add((Button)findViewById(R.id.btnI));
        buttons.add((Button)findViewById(R.id.btnJ));
        buttons.add((Button)findViewById(R.id.btnK));
        buttons.add((Button)findViewById(R.id.btnL));
        buttons.add((Button)findViewById(R.id.btnM));
        buttons.add((Button)findViewById(R.id.btnN));
        buttons.add((Button)findViewById(R.id.btnO));
        buttons.add((Button)findViewById(R.id.btnP));
        buttons.add((Button)findViewById(R.id.btnQ));
        buttons.add((Button)findViewById(R.id.btnR));
        buttons.add((Button)findViewById(R.id.btnS));
        buttons.add((Button)findViewById(R.id.btnT));
        buttons.add((Button)findViewById(R.id.btnU));
        buttons.add((Button)findViewById(R.id.btnV));
        buttons.add((Button)findViewById(R.id.btnW));
        buttons.add((Button)findViewById(R.id.btnX));
        buttons.add((Button)findViewById(R.id.btnY));
        buttons.add((Button)findViewById(R.id.btnZ));

        btnPalavra.setOnClickListener(this);
        for(Button b : buttons){
            b.setOnClickListener(this);
        }

        dictionary = new Dictionary();
        word = new Word(GameActivity.this, dictionary, buttons);

        word.newGame();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is
        // present.
        getMenuInflater().inflate(R.menu.menu_aplicacao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()){
            case R.id.NovoJogo:
                word.newGame();
                return true;
            case R.id.Animal:
                dictionary.loadWords(Dictionary.ANIMAIS);
                word.newWord();
                return true;
            case R.id.Fruta:
                dictionary.loadWords(Dictionary.FRUTAS);
                word.newWord();
                return true;
            case R.id.Pais:
                dictionary.loadWords(Dictionary.PAISES);
                Toast.makeText(GameActivity.this, "Banco de dados vazio", Toast.LENGTH_SHORT).show();
                Toast.makeText(GameActivity.this, "Palavra: NOTHING", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Banda:
                dictionary.loadWords(Dictionary.BANDAS);
                Toast.makeText(GameActivity.this, "Banco de dados vazio", Toast.LENGTH_SHORT).show();
                Toast.makeText(GameActivity.this, "Palavra: NOTHING", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnPalavra){

        }else{
            Button btnLetter = (Button)findViewById(view.getId());
            btnLetter.setEnabled(false);
            word.checkLetter(btnLetter.getText().charAt(0));

            MediaPlayer sound = MediaPlayer.create(getApplicationContext(), R.raw.click);
            sound.start();
        }
    }

}
