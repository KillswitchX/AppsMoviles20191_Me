package appmoviles.com.appsmoviles20191;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import appmoviles.com.appsmoviles20191.model.Amigo;

public class AdapterAmigos extends RecyclerView.Adapter<AdapterAmigos.CustomViewHolder> {

    ArrayList<Amigo> data;

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout root;
        public CustomViewHolder(LinearLayout v) {
            super(v);
            root = v;
        }
    }

    public AdapterAmigos(){
        data = new ArrayList<>();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.renglon_amigos, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        ((TextView) holder.root.findViewById(R.id.renglon_amigo_nombre)).setText(data.get(position).getNombre());
        ((TextView) holder.root.findViewById(R.id.renglon_amigo_telefono)).setText(data.get(position).getTelefono());
        holder.root.findViewById(R.id.renglon_amigo_btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
