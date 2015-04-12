package miagesorbonne.Handitransport;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by user on 05/04/2015.
 */
public class Translater {

    public static void menu(Resources res, Activity act){
        Button bolton = (Button)act.findViewById(R.id.pannes);
        bolton.setText(res.getString(R.string.pannes));

        bolton = (Button)act.findViewById(R.id.autourDeMoi);
        bolton.setText(res.getString(R.string.autourDeMoi));

        bolton = (Button)act.findViewById(R.id.ajoutPanne);
        bolton.setText(res.getString(R.string.ajoutPanne));

        bolton = (Button)act.findViewById(R.id.ajoutLieu);;
        bolton.setText(res.getString(R.string.ajoutLieu));

        EditText et = (EditText) act.findViewById(R.id.rechercher);
        et.setHint(R.string.rechercher);


    }

    public static void autourDeMoi(Resources res, Activity act){
        TextView txview = (TextView)act.findViewById(R.id.textView2);
        txview.setText(res.getString(R.string.sectionnerLigneText01));
    }
}
