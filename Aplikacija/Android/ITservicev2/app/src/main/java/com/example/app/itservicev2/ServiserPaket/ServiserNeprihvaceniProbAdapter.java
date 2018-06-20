package com.example.app.itservicev2.ServiserPaket;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.Klase.Serviser;
import com.example.app.itservicev2.R;

import java.util.List;

public class ServiserNeprihvaceniProbAdapter extends RecyclerView.Adapter<ServiserNeprihvaceniProbAdapter.ViewHolder> {


    private List<Problem> listaProblema;
    private Activity activity;
    private Serviser serviser;


    public ServiserNeprihvaceniProbAdapter(List<Problem>listaP, Activity activity,Serviser serviser)
    {
        listaProblema=listaP;
        this.activity=activity;
        this.serviser=serviser;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_serviser_neprihvaceni_problem,parent,false);

        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Problem problem=listaProblema.get(position);
        holder.txtTipProblema.setText(problem.getTipProblema());
        holder.txtNaziv.setText(problem.getNaziv());
        holder.txtDatum.setText(problem.getDatumPrijavljivanja());
        holder.txtVrstaOpreme.setText(problem.getVrstaOpreme());



    }


    @Override
    public int getItemCount() {
        return listaProblema.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtNaziv,txtDatum,txtTipProblema,txtVrstaOpreme;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTipProblema=(TextView)itemView.findViewById(R.id.txtTipProblema);
            txtNaziv=(TextView)itemView.findViewById(R.id.txtNazivProblema);
            txtDatum=(TextView) itemView.findViewById(R.id.txtDatumStartovanja);
            txtVrstaOpreme=(TextView) itemView.findViewById(R.id.txtVrstaOpreme);

        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            Problem p=listaProblema.get(position);
            Intent i=new Intent(activity, ServiserNeprihvaceniPopActivity.class);
            i.putExtra("Serviser",serviser);
            i.putExtra("Problem",p);

            activity.startActivity(i);

        }
    }
}
