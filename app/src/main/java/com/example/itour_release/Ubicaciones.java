package com.example.itour_release;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Ubicaciones extends AppCompatActivity {


    List<Edificios> edificios = new ArrayList<>();

    String imagenViewID;
    ImageView imagenview;
    int imageID;
    String drawable;
    int idDrawable;
    String textViewID;
    int resID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        LatLng EA = new LatLng(17.078413,-96.745638);
        LatLng EB = new LatLng(17.078253,-96.744824);
        LatLng EC = new LatLng(17.0780357,-96.744878);
        LatLng ED= new LatLng(17.077242, -96.743530);
        LatLng EE = new LatLng(17.076978, -96.744072);
        LatLng EElec = new LatLng(17.078679,-96.743775);
        LatLng EF = new LatLng(17.076693, -96.744116);
        LatLng EG = new LatLng(17.076471, -96.744178);
        LatLng EI=new LatLng(17.0760628,-96.7447535);
        LatLng EJ = new LatLng(17.0762137,-96.74452380);
        LatLng EL = new LatLng(17.078134,-96.744110);
        LatLng Gym =new LatLng(17.077692,-96.743639);
        LatLng Bib = new LatLng(17.077711,-96.744199);
        LatLng LabE1= new LatLng(17.079001, -96.744982);
        LatLng LabS2 = new LatLng(17.079258, -96.744811);
        LatLng LabQ3= new LatLng(17.078576,-96.744589);
        LatLng LabM4= new LatLng(17.078721,-96.744533);
        LatLng LabQ5 = new LatLng(17.077990,-96.744427);
        LatLng LabC6 = new LatLng(17.078653,-96.7443106);
        LatLng Lab7CC= new LatLng(17.079082,-96.744324);
        LatLng LabQ8 = new LatLng(17.079408, -96.743909);
        LatLng LabE9 = new LatLng(17.078784,-96.743807);
        LatLng cafe_izq = new LatLng(17.077187, -96.744013);
        LatLng STitulacion= new LatLng(17.078233,-96.745259);
        LatLng P1= new LatLng(17.077804, -96.746049);
        LatLng P2= new LatLng(17.075941, -96.744244);
        LatLng P3= new LatLng(17.076591, -96.745322);
        LatLng cafe_der= new LatLng(17.0771993,-96.7440196);

        edificios.add(new Edificios("Edificio A", EA,"", "edi_a"));
        edificios.add(new Edificios("Edificio B",EB, "", "edi_b"));
        edificios.add(new Edificios("Edificio C",EC, "", "edi_c"));
        edificios.add(new Edificios("Edificio Ing. Química",ED, "", "edi_quimica"));
        edificios.add(new Edificios("Edificio E",EE, "", "edi_e"));
        edificios.add(new Edificios("Edificio\nElectronica",EElec, "Edificio donde los alumnos de electronica pueden realizar actividades.", "edi_electronica"));
        edificios.add(new Edificios("Edificio F",EF, "", "edi_f"));
        edificios.add(new Edificios("Edificio G",EG, "", "edi_g"));
        edificios.add(new Edificios("Edificio I",EI, "", "edi_i"));
        edificios.add(new Edificios("Edificio J",EJ, "", "edi_j"));
        edificios.add(new Edificios("Edificio Ing.Civil",EL, "", "civil"));
        edificios.add(new Edificios("Gym ITO",Gym, "Gimnasio del ITO donde los estudiantes pueden realizar actividades recreativas como Baloncesto y Danza.", "gym_ito"));
        edificios.add(new Edificios("Biblioteca",Bib, "Espacio de estudio y con cientos de libros de todo tipo.", "biblio"));
        edificios.add(new Edificios("Lab 1\nElectronica",LabE1, "", "lab_electrica"));
        edificios.add(new Edificios("Lab 2\nSimulación",LabS2, "", "lab_sim1"));
        edificios.add(new Edificios("Lab 3:\nIng. Quimica",LabQ3, "", "lb_quimica_bioquimica"));
        edificios.add(new Edificios("Lab 4:\nIng. Mecánica",LabM4, "", "lab_ing_mecanica"));
        edificios.add(new Edificios("Lab 5:\nIng. Quimica",LabQ5, "", "lab_quimica_analitica2"));
        edificios.add(new Edificios("Lab 6:\nIng. Civil",LabC6, "", "lab_civil"));
        edificios.add(new Edificios("Sala\nde Computo",Lab7CC, "Espacio comodo y en silencio para realizar actividades de redes y computación", "centro_computo"));
        edificios.add(new Edificios("Lab 8:\nIng. Quimica",LabQ8, "", "lab_ing_mecanica"));
        edificios.add(new Edificios("Lab 9:\nIng Industrial",LabE9, "", "lab_ing_indus"));
        edificios.add(new Edificios("Cafeteria", cafe_izq,"", "cafe_izq"));
        edificios.add(new Edificios("Sala \ndeTitulación",STitulacion, "", "sala_titulacion"));
        edificios.add(new Edificios("Estacionamiento Principal",P1, "", "parking"));
        edificios.add(new Edificios("Estacionamiento #2",P2, "", "parking"));
        edificios.add(new Edificios("Cafe #2",cafe_der, "", "cafe_izq"));


        for (int i = 0; i < edificios.size() ; i++) {
            imagenViewID = "imageView"+ (i+1);
            imageID = getResources().getIdentifier(imagenViewID, "id", getPackageName());
            imagenview = findViewById(imageID);
            drawable = ""+edificios.get(i).getRuta();
            idDrawable = getResources().getIdentifier(drawable, "drawable", getPackageName());
            try{
                imagenview.setImageDrawable(getResources().getDrawable(idDrawable));
                imagenview.setClipToOutline(true);

            textViewID = "textView" + (i+1);

            resID = getResources().getIdentifier(textViewID, "id", getPackageName());
            TextView textView = findViewById(resID);
            textView.setText(edificios.get(i).getNombre());
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setTextSize(18);
            textView.setTypeface(null, Typeface.BOLD);

            }
            catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }


    }

    //Regresar al Mapa

    public void Mapa(View view){
        finish();
    }


    public void Click(View view){
        //Función para abrir la interfaz de detalles de la
        //Intent intent = new Intent(getApplicationContext(), Detalles.class);
        //startActivity(intent);

//        //ACTUALIZAR IMAGEN CAMBIANTE Y DESCRIPCIONES
//        for(int i=0; i<edificios.size();i++){
//            if(view.getTag().equals(""+i)){
//                drawable = ""+edificios.get(i).getRuta();
//                idDrawable = getResources().getIdentifier(drawable, "drawable", getPackageName());
//                //titulo.setText(edificios.get(i).getNombre());
//                //descripcion.setText(edificios.get(i).getDescripcion());
//                try {
//                    imagenview.setImageDrawable(getResources().getDrawable(idDrawable));
//                }catch (Exception e){
//                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
    }


}