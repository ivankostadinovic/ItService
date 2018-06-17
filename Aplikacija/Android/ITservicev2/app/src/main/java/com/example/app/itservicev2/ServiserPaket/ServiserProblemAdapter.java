package com.example.app.itservicev2.ServiserPaket;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.itservicev2.Klase.Problem;
import com.example.app.itservicev2.KlijentPaket.KlijentProblemPopActivity;
import com.example.app.itservicev2.R;

import java.util.List;

public class ServiserProblemAdapter extends RecyclerView.Adapter<ServiserProblemAdapter.ViewHolder> {


    private List<Problem> listaProblema;
    private Context context;


    public ServiserProblemAdapter(List<Problem>listaP, Context context)
    {
        listaProblema=listaP;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.serviser_problem_item,parent,false);

        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Problem problem=listaProblema.get(position);


        holder.txtTipProblema.setText(problem.getTipProblema());
        holder.txtNaziv.setText(problem.getNaziv());
        holder.txtDatum.setText(problem.getDatumPrijavljivanja());
        holder.txtStatus.setText(problem.getStatus());


    }


    @Override
    public int getItemCount() {
        return listaProblema.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtNaziv,txtDatum,txtStatus,txtTipProblema;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTipProblema=(TextView)itemView.findViewById(R.id.txtTipProblema);
            txtNaziv=(TextView)itemView.findViewById(R.id.txtNazivProblema);
            txtDatum=(TextView) itemView.findViewById(R.id.txtDatumPrijavljivanja);
            txtStatus=(TextView)itemView.findViewById(R.id.txtStatusProblema);
        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            Problem p=listaProblema.get(position);

            Intent i=new Intent(context, ServiserProblemPopActivity.class);
            i.putExtra("Problem",p);
            context.startActivity(i);


        }
    }
}
