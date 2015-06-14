package miagesorbonne.Handitransport;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import controlleur.ManagerMap;

/**
 * Classe qui va s'occuper de l'activité contenant la map et l'ensemble de nos lieux
 */
public class AutourDeMoi extends FragmentActivity {

    private static final LatLng PARIS = new LatLng(48.856614,2.352222);
    private Activity act = this;
    private ManagerMap managerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autour_de_moi);
        managerMap = new ManagerMap(this, AutourDeMoi.this);

        managerMap.placerMarker();
        managerMap.listennerMarker();

        GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(PARIS, 12));
        map.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);

    }


        @Override
    protected void onResume() {
        super.onResume();
    }
}
