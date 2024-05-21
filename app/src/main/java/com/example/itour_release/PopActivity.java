package com.example.itour_release;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.maps.model.LatLng;


public class PopActivity extends Activity {
    ImageButton btn_Close;
    Button btn_Informacion;
    ConstraintLayout constraintLayout;
    private LatLng savedLocation;
    private TextView tv_Name;
    private TextView tv_Subtitle;
    private String nLocacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        constraintLayout=findViewById(R.id.disposicion);
        MyApplication myApplication = (MyApplication) getApplicationContext();
        savedLocation = myApplication.getMiDestino();
        nLocacion=myApplication.getnDestino();

        btn_Close=(android.widget.ImageButton)findViewById(R.id.btn_cerrar);
        btn_Informacion=findViewById(R.id.btn_info);
        tv_Name=findViewById(R.id.tv_Nombre);
        tv_Subtitle=findViewById(R.id.tv_subititulo);

        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        btn_Informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ubicaciones.class);
                startActivity(intent);
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width= displayMetrics.widthPixels;
        int height=displayMetrics.widthPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*0.9));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x=0;
        params.y=525;
        getWindow().setAttributes(params);

        tv_Name.setText(nLocacion);
        tv_Subtitle.setText("Coord:("+savedLocation.latitude+","+savedLocation.longitude+")");


    }
}