package com.example.visumed.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.visumed.DrugDetailsActivity;
import com.example.visumed.R;
import com.example.visumed.entidades.Drug;

import java.util.List;

public class DrugListAdapter extends RecyclerView.Adapter<DrugListAdapter.DrugHolder> {
    List<Drug> drugs;
    private Context context;

    public DrugListAdapter(Context context, List<Drug> drugs) {
        this.context=context;
        this.drugs = drugs;
    }

    @Override
    public DrugHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drug_list_item, parent, false);
        return new DrugHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(DrugHolder holder, int position) {
        final int pos = position;
        holder.bindDrug(drugs.get(pos));

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, DrugDetailsActivity.class);
                intent.putExtra("titulo_remedio", drugs.get(pos).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drugs.size();
    }

    public class DrugHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView indications;
        TextView counterIndications;
        TextView dosage;
        LinearLayout parentLayout;

        private Drug drug;

        public DrugHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.drug_name);
            indications = itemView.findViewById(R.id.drug_indications);
            counterIndications = itemView.findViewById(R.id.drug_counterIndications);
            dosage = itemView.findViewById(R.id.drug_dosage);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

        public void bindDrug(Drug drug){
            this.drug = drug;
            name.setText(drug.getName());
        }
    }
}
