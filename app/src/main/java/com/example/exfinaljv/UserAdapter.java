package com.example.exfinaljv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<Usuario> usuarios;
    private Context context;

    public UserAdapter(List<Usuario> usuarios, Context context) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.name.setText(usuario.getName());
        holder.email.setText(usuario.getEmail());
        holder.country.setText(usuario.getCountry());
        Glide.with(context)
                .load(usuario.getPicture())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, country;
        ImageView image;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.userEmail);
            country = itemView.findViewById(R.id.userCountry);
            image = itemView.findViewById(R.id.userImage);
        }
    }
}