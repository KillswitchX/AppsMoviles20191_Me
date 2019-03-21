package appmoviles.com.appsmoviles20191;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAmigos extends RecyclerView.Adapter<AdapterAmigos.CustomViewHolder> {

    ArrayList<Object> data;

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
        ((TextView) holder.root.findViewById(R.id.nombre)).setText(data.get(position).getParam1());
        ((TextView) holder.root.findViewById(R.id.fecha)).setText(data.get(position).getParam2());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
