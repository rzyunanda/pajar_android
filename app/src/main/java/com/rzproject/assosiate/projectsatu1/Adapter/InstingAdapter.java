package com.rzproject.assosiate.projectsatu1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rzproject.assosiate.projectsatu1.Model.InstingItemModel;
import com.rzproject.assosiate.projectsatu1.R;

import java.util.ArrayList;

public class InstingAdapter extends RecyclerView.Adapter<InstingAdapter.InstingHolder> {
    private ArrayList<InstingItemModel> listInsting;
    Context context;
    FragmentManager fragmentManager;
    OnItemClick handler;

    public InstingAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public void setListInsting(ArrayList<InstingItemModel> listInsting) {
        this.listInsting = listInsting;
    }

    @NonNull
    @Override
    public InstingAdapter.InstingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.insting_list_item, parent, false);
        return new InstingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstingAdapter.InstingHolder holder, int position) {
        InstingItemModel model = listInsting.get(position);
        holder.judul.setText(model.judul);


    }

    @Override
    public int getItemCount() {
        if(listInsting != null) {
            return listInsting.size();
        }
        return 0;
    }

    public interface OnItemClick{
        void click(InstingItemModel m);
    }
    public void setHandler(OnItemClick clickHandler){
        handler = clickHandler;
    }

    public class InstingHolder extends RecyclerView.ViewHolder {
        private TextView judul;
        public InstingHolder(@NonNull View itemView) {
            super(itemView);

            judul= itemView.findViewById(R.id.tv_insting_judul);
        }
    }
}
