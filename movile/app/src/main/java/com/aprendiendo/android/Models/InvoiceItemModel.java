package com.aprendiendo.android.Models;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class InvoiceItemModel implements Parcelable {

    int id;
    private String name;
    int cant;
    private int priceU;

    public InvoiceItemModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        cant = in.readInt();
        priceU = in.readInt();
    }

    public static final Creator<InvoiceItemModel> CREATOR = new Creator<InvoiceItemModel>() {
        @Override
        public InvoiceItemModel createFromParcel(Parcel in) {
            return new InvoiceItemModel(in);
        }

        @Override
        public InvoiceItemModel[] newArray(int size) {
            return new InvoiceItemModel[size];
        }
    };

    public InvoiceItemModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getPriceU() {
        return priceU;
    }

    public void setPriceU(int priceU) {
        this.priceU = priceU;
    }

    public int getPriceT() {
        return priceU*cant;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(cant);
        parcel.writeInt(priceU);
    }
}
