package com.example.eduardo.demoproyecto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Eduardo on 18/09/2015.
 */
public class CrearReporteFragment extends Fragment {

    EditText fechaActual;

    private int mYear, mMonth, mDay;
    static final int DATE_DIALOG_ID =0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_altar_reporte,container,false);
        fechaActual = (EditText) rootView.findViewById(R.id.fechaActual);

        Calendar mcurrentDate = Calendar.getInstance();
        mYear = mcurrentDate.get(Calendar.YEAR);
        mMonth = mcurrentDate.get(Calendar.MONTH);
        mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        fechaActual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(),onDateSetListener ,mYear, mMonth, mDay);
                mDatePicker.setTitle("Selecciona Fecha");
                mDatePicker.show();
            }
        });

        return rootView;
    }

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
            fechaActual.setText( selectedday + " / " + (selectedmonth + 1) + " / " + selectedyear);
            Calendar mcurrentDate = Calendar.getInstance();
            mYear = selectedyear;
            mMonth = selectedmonth;
            mDay = selectedday;
        }
    };


    public String formatDateMySQL(Integer day, Integer month, Integer year){
        return year + "/" + month +"/"+day;
    }

}
