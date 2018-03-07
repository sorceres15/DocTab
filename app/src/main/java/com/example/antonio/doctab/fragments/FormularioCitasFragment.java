package com.example.antonio.doctab.fragments;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.antonio.doctab.R;

import java.util.Calendar;

/**
 * Created by Ricardo on 13/02/2018.
 */

public class FormularioCitasFragment extends Fragment implements View.OnClickListener {


    private static TextInputLayout tilCitasFecha;
    Spinner sp_hora,sp_minuto;
    Calendar currentDate;
    EditText fecha;
    int dia, mes, year;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario_citas,container,false);

        tilCitasFecha = (TextInputLayout) view.findViewById(R.id.til_citas_fecha);
        fecha = (EditText)view.findViewById(R.id.ed_citas_fecha);
        currentDate = Calendar.getInstance();
        dia = currentDate.get(Calendar.DAY_OF_MONTH);
        mes = currentDate.get(Calendar.MONTH);
        year = currentDate.get(Calendar.YEAR);
        tilCitasFecha.getEditText().setText(dia+"/"+mes+"/"+year);

        sp_hora = (Spinner)view.findViewById(R.id.sp_hora);
        sp_minuto = (Spinner)view.findViewById(R.id.sp_minutos);

        fecha.setOnClickListener(this);




        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ed_citas_fecha:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                month = month+1;

                                tilCitasFecha.getEditText().setText(dayOfMonth+"/"+month+"/"+year);
                            }
                        },year,mes,dia);
                datePickerDialog.show();
                break;
        }

    }

}



