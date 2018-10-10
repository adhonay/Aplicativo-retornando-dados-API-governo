package com.software.tp.adhonay.tp02lddm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ContratoAdapter extends ArrayAdapter<Contrato> {
    public ContratoAdapter(Context context, int resource, List<Contrato> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_list_contrato, parent, false);
        }

        TextView objeto = (TextView) v.findViewById(R.id.objeto);

        Contrato c = getItem(position);

        objeto.setText(String.valueOf(c.getObjeto()));

        return v;

        //return super.getView(position, convertView, parent);
    }
}
