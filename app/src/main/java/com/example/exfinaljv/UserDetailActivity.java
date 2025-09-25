package com.example.exfinaljv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UserDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView name, email, country, address, phone, nationality, userId;
    private ImageView userImage, userFlag;
    private SupportMapFragment mapFragment;
    private double latitude = 47.3769;  // Suiza (Zürich)
    private double longitude = 8.5417;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        name = findViewById(R.id.userName);
        email = findViewById(R.id.userEmail);
        country = findViewById(R.id.userCountry);
        address = findViewById(R.id.userAddress);
        phone = findViewById(R.id.userPhone);
        nationality = findViewById(R.id.userNationality);
        userId = findViewById(R.id.userId);
        userImage = findViewById(R.id.userImage);
        userFlag = findViewById(R.id.userFlag);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapContainer);

        // Cargar detalles del usuario (esto depende de cómo pasas los datos)
        name.setText("Marlise Guerin");
        email.setText("Correo electrónico: marlise.guerin@example.com");
        country.setText("País: Suiza");
        address.setText("Dirección: Rue Abel-Gance 277, Schwendibach, Zug, Switzerland");
        phone.setText("Teléfono: 076 204 13 05");
        nationality.setText("Nacionalidad: Suiza (CH)");
        userId.setText("Identificación: 756.0083.1011.26");

        // Cargar la bandera usando la API
        Glide.with(this)
                .load("https://restcountries.com/v3.1/name/switzerland")
                .into(userFlag);

        // Iniciar el mapa
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng location = new LatLng(latitude, longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));

        // Marcar la ubicación en el mapa
        mMap.addMarker(new MarkerOptions().position(location).title("Zürich, Suiza"));

        // Mostrar una ventana emergente cuando se haga clic en el marcador
        mMap.setOnMarkerClickListener(marker -> {
            Toast.makeText(this, "Ubicación: " + marker.getTitle(), Toast.LENGTH_SHORT).show();
            return false;
        });
    }
}