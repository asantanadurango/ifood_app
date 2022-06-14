package com.aprendiendo.android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.aprendiendo.android.Models.InvoiceItemModel;
import com.aprendiendo.android.databinding.InvoiceItemBinding;

import java.util.ArrayList;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder>{

    private Context where;
    InvoiceItemBinding invoiceItemBinding;
    private ArrayList<InvoiceItemModel> invoiceItems;

    public InvoiceAdapter(Context where, ArrayList<InvoiceItemModel> invoiceItems)
    {
        this.where = where;
        this.invoiceItems = invoiceItems;
    }

    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        invoiceItemBinding = InvoiceItemBinding.inflate(LayoutInflater.from(where));
        return new InvoiceViewHolder(invoiceItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceAdapter.InvoiceViewHolder holder, int position) {
        InvoiceItemModel invoice = invoiceItems.get(position);
        holder.itemBinding.invName.setText(invoice.getName());
        holder.itemBinding.invCant.setText(String.valueOf(invoice.getCant()));
        holder.itemBinding.invPrecU.setText(String.valueOf(invoice.getPriceU()));
        holder.itemBinding.invPrecT.setText(String.valueOf(invoice.getPriceT()));
    }

    @Override
    public int getItemCount() {return invoiceItems.size();}

    public class InvoiceViewHolder extends RecyclerView.ViewHolder {
        InvoiceItemBinding itemBinding;
        public InvoiceViewHolder(@NonNull InvoiceItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

    }
}
