package miagesorbonne.Handitransport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;


public class Lieu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieu);
        Intent intent = getIntent();

//        int id = Integer.valueOf(intent.getStringExtra("id"));
        String nomlieu = intent.getStringExtra("nom");
        String adresse = intent.getStringExtra("adresse");
        String cpVille = intent.getStringExtra("cpVille");
        String accessibilite = intent.getStringExtra("accessibilite");
//        String note = intent.getStringExtra("note");

        TextView textView1 = (TextView) findViewById(R.id.nomLieu);
        TextView textView2 = (TextView) findViewById(R.id.adresseLieu);
        TextView textView3 = (TextView) findViewById(R.id.CPVille);
        TextView textView4 = (TextView) findViewById(R.id.accessibiliteLieu);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBarLieu);

        textView1.setText(nomlieu);
        textView2.setText(adresse);
        textView3.setText(cpVille);
        textView4.setText(accessibilite);
        ratingBar.setRating(3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lieu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
