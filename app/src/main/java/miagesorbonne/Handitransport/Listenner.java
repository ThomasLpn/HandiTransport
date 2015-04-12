package miagesorbonne.Handitransport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;


/**
 * Created by user on 05/04/2015.
 */

public class Listenner implements View.OnClickListener {

    Intent intent;
    Activity act;

    public Listenner(Context inte, Class classe, Activity act){
        intent = new Intent(inte, classe);
        this.act=act;
    }

    @Override
    public void onClick(View v) {
        act.startActivity(intent);
    }
}
