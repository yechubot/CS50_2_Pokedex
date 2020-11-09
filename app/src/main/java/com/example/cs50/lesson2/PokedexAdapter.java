package com.example.cs50.lesson2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {//viewHolder가 필요한 제네릭임

    public static class PokedexViewHolder extends RecyclerView.ViewHolder {//static으로 사용해서 바로 어댑터.홀더 이렇게 접근할 수 있
        public LinearLayout containerView;
        public TextView textView;

        PokedexViewHolder(View view) {
            super(view);
            containerView = view.findViewById(R.id.pokedex_row);
            textView = view.findViewById(R.id.pokedex_row_text_view);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Pokemon current = (Pokemon)containerView.getTag();
                    Intent intent = new Intent(v.getContext(),PokemonActivity.class);
                    intent.putExtra("name",current.getName());
                    intent.putExtra("number",current.getNumber());

                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<Pokemon> pokemon = Arrays.asList(
            new Pokemon("Bulbasaur", 1),
            new Pokemon("Ivysaur", 2),
            new Pokemon("Venusaur", 3)
    );

    @NonNull
    @Override
    public PokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_row, parent, false);
        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokedexViewHolder holder, int position) {
        Pokemon current = pokemon.get(position);
        holder.textView.setText(current.getName());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }
}
