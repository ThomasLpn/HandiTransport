package controlleur;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metier.Endroit;
import miagesorbonne.Handitransport.Lieu;
import miagesorbonne.Handitransport.R;
import service.SelectAllLieuBD;

/**
 * Created by user on 13/06/2015.
 */
public class ManagerMap {
    Activity activite;
    Context context;
    SelectAllLieuBD selectAllLieuBD;
    Map<Marker,Endroit> dictionnaireEndroit;

    public ManagerMap(Activity activite, Context context){
        this.activite=activite;
        this.context = context;
        selectAllLieuBD = new SelectAllLieuBD();
        dictionnaireEndroit = new HashMap<>();
    }

    public void placerMarker(){
        List<Endroit> listLieu;
        listLieu= selectAllLieuBD.selectAllLieu();
        GoogleMap map = ((MapFragment) activite.getFragmentManager().findFragmentById(R.id.map)).getMap();
        Marker tmp;

        for (int i=0; i<listLieu.size();i++) {
            LatLng latLng = getLocationFromAddress(listLieu.get(i).getAdresse() + " " + listLieu.get(i).getCp() + " " + listLieu.get(i).getVille());
            if (latLng != null) {
                tmp = map.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude)).title(listLieu.get(i).getNom()).snippet(listLieu.get(i).getNote() + ""));
                dictionnaireEndroit.put(tmp, listLieu.get(i));
            }
        }
    }

    public void listennerMarker(){
        GoogleMap map = ((MapFragment) activite.getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intent = new Intent(context, Lieu.class);
                intent.putExtra("id",dictionnaireEndroit.get(marker).getId());
                intent.putExtra("nom",dictionnaireEndroit.get(marker).getNom());
                intent.putExtra("cpVille",dictionnaireEndroit.get(marker).getAdresse());
                intent.putExtra("adresse",dictionnaireEndroit.get(marker).getCp()+" "+dictionnaireEndroit.get(marker).getVille());
                intent.putExtra("accessibilite",dictionnaireEndroit.get(marker).getCommentaire());
                intent.putExtra("note",dictionnaireEndroit.get(marker).getNote()+0);

                activite.startActivity(intent);
                return true;
            }
        });
    }

    private LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            p1 = new LatLng((location.getLatitude()),(location.getLongitude()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return p1;
    }
}
