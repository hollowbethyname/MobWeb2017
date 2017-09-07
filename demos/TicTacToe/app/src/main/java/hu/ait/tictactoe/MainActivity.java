package hu.ait.tictactoe;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.facebook.shimmer.ShimmerFrameLayout;

import hu.ait.tictactoe.view.TicTacToeView;

public class MainActivity extends AppCompatActivity {

    private TextView tvData;
    private ToggleButton toggleButton;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = (TextView) findViewById(R.id.tvData);
        final TicTacToeView gameView = (TicTacToeView) findViewById(R.id.gameView);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        linearLayout = (LinearLayout) findViewById(R.id.activity_main);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.resetGame();
            }
        });

        ShimmerFrameLayout shimmerFrameLayout =
                (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        shimmerFrameLayout.startShimmerAnimation();

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gameView.setMode(isChecked);
            }
        });

    }

    public void setMessage(String text) {
        tvData.setText(text);
        Snackbar.make(linearLayout,"Change!",Snackbar.LENGTH_LONG).show();
    }
}
