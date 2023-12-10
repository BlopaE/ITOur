package com.example.itour_release;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Resultados extends AppCompatActivity {

    ListView listView;
    TextView label_pag;
    Button btn_next,btn_prev;
    List<Edificios> edificios = new ArrayList<>();
    List<String> nombres= new ArrayList<>();
    MyApplication aplicacion;
    ArrayAdapter<String> arrayAdapter;

    int rangoInferior =0, page_counter=1,tope_pag=10; //limite inferior
    int rangoSuperior=10; //limite superior



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        aplicacion = (MyApplication) getApplicationContext();

        //EDIFICIOS ITO
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
        LatLng DSin = new LatLng(17.076477, -96.744565);
        LatLng STitulacion= new LatLng(17.078233,-96.745259);
        LatLng P1= new LatLng(17.077804, -96.746049);
        LatLng P2= new LatLng(17.075941, -96.744244);
        LatLng P3= new LatLng(17.076591, -96.745322);
        LatLng cafe_der= new LatLng(17.077209,-96.7440196);

        edificios.add(new Edificios("Edificio A", EA,"", "ruta2"));
        edificios.add(new Edificios("Edificio B",EB, "", "ruta2"));
        edificios.add(new Edificios("Edificio C",EC, "", "ruta2"));
        edificios.add(new Edificios("Edificio Ing. Química",ED, "", "edi_quimica"));
        edificios.add(new Edificios("Edificio E",EE, "", "ruta2"));
        edificios.add(new Edificios("Edificio de Electronica",EElec, "Edificio donde los alumnos de electronica pueden realizar actividades.", "ruta2"));
        edificios.add(new Edificios("Edificio F",EF, "", "ruta2"));
        edificios.add(new Edificios("Edificio G",EG, "", "ruta2"));
        edificios.add(new Edificios("Edificio I",EI, "", "ruta2"));
        edificios.add(new Edificios("Edificio J",EJ, "", "ruta2"));
        edificios.add(new Edificios("Edificio L",EL, "", "ruta2"));
        edificios.add(new Edificios("Gym ITO",Gym, "Gimnasio del ITO donde los estudiantes pueden realizar actividades recreativas como Baloncesto y Danza.", "ruta2"));
        edificios.add(new Edificios("Biblioteca",Bib, "Espacio de estudio y con cientos de libros de todo tipo.", "ruta2"));
        edificios.add(new Edificios("Laboratorio 1: Electronica",LabE1, "", "ruta2"));
        edificios.add(new Edificios("Laboratorio 2: Simulación",LabS2, "", "ruta2"));
        edificios.add(new Edificios("Laboratorio 3: Ing. Quimica",LabQ3, "", "ruta2"));
        edificios.add(new Edificios("Laboratorio 4:Ing. Mecánica",LabM4, "", "ruta2"));
        edificios.add(new Edificios("Laboratorio 5: Ing. Quimica",LabQ5, "", "ruta2"));
        edificios.add(new Edificios("Laboratorio 6: Ing. Civil",LabC6, "", "ruta2"));
        edificios.add(new Edificios("Centro de Cómputo: Laboratorio 7",Lab7CC, "Espacio comodo y en silencio para realizar actividades de redes y computación", "@drawable/centro_computo.PNG"));
        edificios.add(new Edificios("Laboratorio 8: Ing. Quimica",LabQ8, "", "ruta2"));
        edificios.add(new Edificios("Laboratorio 9: Ing. Electrónica",LabE9, "", "ruta2"));
        edificios.add(new Edificios("Delegación Sindical D-II-11",DSin, "", "ruta2"));
        edificios.add(new Edificios("Sala de Titulación",STitulacion, "", "ruta2"));
        edificios.add(new Edificios("Estacionamiento Principal",P1, "", "ruta2"));
        edificios.add(new Edificios("Estacionamiento #2",P2, "", "ruta2"));
        edificios.add(new Edificios("Cafe #2",cafe_der, "", "cafe_izq"));

        nombres.clear();
        int i=0;
        rangoInferior=0;
        rangoSuperior=10;
        for (i = rangoInferior; i < rangoSuperior; i++) {
            nombres.add(edificios.get(i).getNombre());
        }
        listView=findViewById(R.id.listView);
        label_pag=findViewById(R.id.tv_pagina);
        btn_next=findViewById(R.id.btn_pag_siguiente);
        btn_prev=findViewById(R.id.btn_pag_anterior);
        btn_prev.setEnabled(false);


        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombres);
        listView.setAdapter(arrayAdapter);
        //justifyListViewHeightBasedOnChildren(new ListView(listView.getContext()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                aplicacion.setMiDestino(edificios.get(tope_pag-10+position).getUbi());
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
                int [] coords = new int[2];
                //view.getLocationOnScreen(coords);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    view.getLocationInSurface(coords);
                }else{
                view.getLocationOnScreen(coords);
                }
                int x=coords[0];
                int y=coords[1];
                String texto=("Coords: X:"+x+"y:"+y);
                Toast.makeText(Resultados.this,texto,Toast.LENGTH_LONG).show();
            }
        });


    }


    public void siguienteP(View view){
        if(!btn_prev.isEnabled()){btn_prev.setEnabled(true);}
        if (rangoSuperior>edificios.size()) {
            btn_next.setEnabled(false);
            nombres.clear();
            actualiza_lista();
            arrayAdapter.notifyDataSetChanged();
            rangoInferior-=10;
            rangoSuperior-=10;
        } else
        if (rangoInferior<0) {
                page_counter++;
                nombres.clear();
                actualiza_lista();
                arrayAdapter.notifyDataSetChanged();
            rangoInferior+=10;
            rangoSuperior+=10;
            } else{
            page_counter++;
            nombres.clear();
            rangoInferior=rangoSuperior;
            rangoSuperior+=10;
            actualiza_lista();
            arrayAdapter.notifyDataSetChanged();
            if(rangoSuperior>edificios.size()) {
                btn_next.setEnabled(false);
                btn_prev.setEnabled(true);
            }
            //Toast.makeText(view.getContext(),"SIGUIENTE",Toast.LENGTH_LONG).show();
        }
    }

    public void  actualiza_lista(){
        label_pag.setText(String.valueOf(page_counter));
        tope_pag=page_counter*10;
        if (rangoInferior<=0){
            for (int i = 0; i < tope_pag; i++) {
                nombres.add(edificios.get(i).getNombre());
            }
        }else
        if(tope_pag>edificios.size()) {
            for (int i = tope_pag - 10; i < edificios.size(); i++) {
                nombres.add(edificios.get(i).getNombre());
            }
        }else{
            for (int i = tope_pag-10; i<tope_pag; i++) {
                nombres.add(edificios.get(i).getNombre());
            }
        }
    }
    public void anteriorP(View view) {
        if(!btn_next.isEnabled()){btn_next.setEnabled(true);}
            if (rangoInferior<0){
                rangoInferior+=10;
                rangoSuperior+=10;
            nombres.clear();
            actualiza_lista();
            arrayAdapter.notifyDataSetChanged();
        } else if (rangoSuperior>edificios.size()) {
                page_counter--;
                rangoSuperior-=10;
                rangoInferior-= 10;
                nombres.clear();
                actualiza_lista();
                arrayAdapter.notifyDataSetChanged();
            } else {
                page_counter--;
                rangoSuperior-=rangoInferior;
                rangoInferior -= 10;
                nombres.clear();
                actualiza_lista();
                if(rangoInferior<=0) {
                    btn_next.setEnabled(true);
                    btn_prev.setEnabled(false);
                }
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public void Regresar(View view){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem= menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Búsqueda");
        searchView.setFocusable(true);
        searchView.setIconifiedByDefault(true);
        //searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    showInputMethod(view.findFocus());
                }
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
    private void showInputMethod(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(view, 0);
        }
    }


    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
}


