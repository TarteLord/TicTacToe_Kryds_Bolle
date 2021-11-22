package dk.tec.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llGameboard;
    boolean p1Turn;
    boolean winnerFound;
    Button[][] buttons = new Button[3][3];
    int rounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llGameboard = findViewById(R.id.llGamebord);
        p1Turn = true;
        rounds = 0;
        createGameBoard();

    }

    private void createGameBoard() {
        for(int r = 0; r < 3; r++){
            LinearLayout ll = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1
                    );
            ll.setLayoutParams(params);
            for(int c = 0; c < 3; c++){
                buttons[r][c] = createButton();
                buttons[r][c].setOnClickListener(this);
                ll.addView(buttons[r][c]);
            }
            llGameboard.addView(ll);
        }
    }

    private Button createButton() {
        Button btn = new Button(MainActivity.this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1
        );


        btn.setLayoutParams(params);
        btn.setTextSize(50);

        return btn;

    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(this, "Klik", Toast.LENGTH_SHORT).show();
        Button b = (Button) v;

        //if(!b.getText().equals(""))

        b.setEnabled(false);

        b.setText(p1Turn? "X": "O");



        p1Turn = !p1Turn;
    }
}