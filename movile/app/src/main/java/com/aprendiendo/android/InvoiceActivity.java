package com.aprendiendo.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aprendiendo.android.Adapters.InvoiceAdapter;
import com.aprendiendo.android.Models.InvoiceItemModel;
import com.aprendiendo.android.databinding.ActivityInvoiceBinding;
import java.io.Serializable;
import java.util.ArrayList;

public class InvoiceActivity extends AppCompatActivity {

    ActivityInvoiceBinding invoiceBinding;
    InvoiceAdapter invoiceAdapter;
    ArrayList<? extends Parcelable> invoiceArray;
    int totalInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        invoiceBinding = ActivityInvoiceBinding.inflate(getLayoutInflater());
        View view = invoiceBinding.getRoot();
        setContentView(view);
        totalInvoice = 0;
        InvoiceItemModel modelo ;

        invoiceArray = (ArrayList<? extends Parcelable>) getIntent().getParcelableArrayListExtra("ARRAYLIST");
        invoiceAdapter = new InvoiceAdapter(getApplicationContext(), (ArrayList<InvoiceItemModel>) invoiceArray);
        invoiceBinding.rvInvoice.setHasFixedSize(true);
        invoiceBinding.rvInvoice.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        invoiceBinding.rvInvoice.setAdapter(invoiceAdapter);

        //REGRESO A INICIO
        invoiceBinding.btOutofInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Inicio.class);
                startActivity(intent);
                finish();
            }
        });

        // SE SACA EL TOTAL DE LA FACTURA

        for(int i=0;i<invoiceArray.size();i++)
        {
            modelo = (InvoiceItemModel) invoiceArray.get(i);
            totalInvoice = totalInvoice +modelo.getPriceT();
        }


        invoiceBinding.tvTotal.setText("Total: "+totalInvoice);
    }


}