package com.example.antonio.doctab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.antonio.doctab.R;
import com.example.antonio.doctab.fragments.ConsultoriosFragment;
import com.example.antonio.doctab.helpers.DecodeItemHelper;
import com.example.antonio.doctab.models.Consultorios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvier on 21/12/2017.
 */

public class ConsultoriosAdapterVP extends RecyclerView.Adapter<ConsultoriosAdapterVP.ViewHolder> {

    View.OnClickListener onClickListener;
    List<Consultorios> dataList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView txtCalle,txtNumExt,txtColonia;



        public ViewHolder(View itemView) {
            super(itemView);

            txtCalle = (TextView)itemView.findViewById(R.id.item_consultorios_calle);
            txtNumExt = (TextView)itemView.findViewById(R.id.item_consultorios_num_ext);
            txtColonia= (TextView)itemView.findViewById(R.id.item_consultorios_colonia);


        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Consultorios getItemByPosition(int position) {
        return dataList.get(position);
    }

    public void addAll(List<Consultorios> _data) {
        this.dataList.addAll(_data);
    }

    public void remove(int position) {
        this.dataList.remove(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_consultorios_nbtn, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Consultorios item = dataList.get(position);
        /**Llena el objeto que sera enviado al fragmento**/
        final DecodeItemHelper decodeItem = new DecodeItemHelper();

        decodeItem.setItemModel(item);
        decodeItem.setPosition(position);


        //TODO HACER UN METODO PARA CONCATENAR SIN NULL
        holder.txtCalle.setText(item.getCalle() +" #"+item.getNumeroExt() + " " + item.getColonia());



    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}