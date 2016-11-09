package com.andrecastrom.miscontactosfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.andrecastrom.miscontactosfragment.adapter.PageAdapter;
import com.andrecastrom.miscontactosfragment.vista.fragment.PerfilFragment;
import com.andrecastrom.miscontactosfragment.vista.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //https://api.instagram.com/oauth/authorize/?client_id=3ffdea63088e4785a73981c4fcb2a27a&redirect_uri=https://www.instagram.com/andrecm12345&response_type=code&scope=basic+comments+follower_list+likes+relationships+public_content
    //https://www.instagram.com/andrecm12345/?code=517136131faa497d845d7193d20e1ea5
    /*
    curl.exe -F 'client_id=3ffdea63088e4785a73981c4fcb2a27a' \
    -F 'client_secret=2994bd1077704540bdffefebbe730b71' \
    -F 'grant_type=authorization_code' \
    -F 'redirect_uri=https://www.instagram.com/andrecm12345' \
    -F 'code=517136131faa497d845d7193d20e1ea5' \
    https://api.instagram.com/oauth/access_token

    curl.exe -F 'client_id=3ffdea63088e4785a73981c4fcb2a27a' -F 'client_secret=2994bd1077704540bdffefebbe730b71' -F 'grant_type=authorization_code' -F 'redirect_uri=https://www.instagram.com/andrecm12345' -F 'code=517136131faa497d845d7193d20e1ea5' https://api.instagram.com/oauth/access_token

    {
        "access_token": "3918358801.3ffdea6.42f6cf9d434b4309aba72d072ed3e6db",
        "user": {
            "username": "andrecm12345",
            "bio": "",
            "website": "",
            "profile_picture": "https://scontent-sin6-1.cdninstagram.com/t51.2885-19/11906329_960233084022564_1448528159_a.jpg",
            "full_name": "Andreeee",
            "id": "3918358801"
        }
    }

    https://api.instagram.com/v1/users/self/?access_token=3918358801.3ffdea6.42f6cf9d434b4309aba72d072ed3e6db
    https://api.instagram.com/v1/users/2225629405/?access_token=3918358801.3ffdea6.42f6cf9d434b4309aba72d072ed3e6db
    https://api.instagram.com/v1/users/search?q=andrecastromartinez&access_token=3918358801.3ffdea6.42f6cf9d434b4309aba72d072ed3e6db
    https://api.instagram.com/v1/users/3918358801/media/recent/?access_token=3918358801.3ffdea6.42f6cf9d434b4309aba72d072ed3e6db
    */

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        /*
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        */
        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
//                finish();
            }
        });
        */



    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.lista);
        tabLayout.getTabAt(1).setIcon(R.drawable.person);
    }


}
