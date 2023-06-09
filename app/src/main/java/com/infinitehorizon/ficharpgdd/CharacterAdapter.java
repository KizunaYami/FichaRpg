package com.infinitehorizon.ficharpgdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CharacterAdapter extends ArrayAdapter<Character> {
    private final ArrayList<Character> list;
    private final onClick onClickListener;

    public CharacterAdapter(@NonNull Context context, ArrayList<Character> list, onClick onClickListener) {
        super(context, 0, list);
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            Context ctx = getContext();
            LayoutInflater layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.character_list_layout,parent, false);
        }

        Character character = list.get(position);

        TextView charName = view.findViewById(R.id.idTextViewCharName);

        charName.setText(character.getName());

        LinearLayout linearLayout = view.findViewById(R.id.idLinearL);

        linearLayout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickListener.clickChar(character);
                    }
                }
        );

        Button btDelete = view.findViewById(R.id.idBtDeleteChar);

        btDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickListener.onClick(character);
                    }
                }
        );

        return view;
    }

    public interface onClick{
        public void onClick(Character character);
        public void clickChar(Character character);
    }
}
