package com.andrecastrom.miscontactosfragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetalleContacto extends AppCompatActivity {

    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";

//    private TextView tvNombre;
//    private TextView tvTelefono;
//    private TextView tvEmail;
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        Bundle parametros = getIntent().getExtras();
        String url = parametros.getString(KEY_EXTRA_URL);
        int likes = parametros.getInt(KEY_EXTRA_URL);

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);

        tvLikesDetalle.setText(String.valueOf(likes));

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.shock_rave_2)
                .into(imgFotoDetalle);

    }
/*
    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Cancelar llamada", Toast.LENGTH_SHORT).show();
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Toast.makeText(this, "Llamando...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }


    public void enviarMail(View v) {
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }
*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
//            startActivity(intent);
//        }
        return super.onKeyDown(keyCode, event);
    }
}
