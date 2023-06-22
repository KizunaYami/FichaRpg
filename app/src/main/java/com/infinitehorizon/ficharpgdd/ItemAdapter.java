package com.infinitehorizon.ficharpgdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {
    private final ArrayList<Item> list;
    private final onClickItem onClickListener;

    public ItemAdapter(@NonNull Context context, ArrayList<Item> list, onClickItem onClickListener) {
        super(context, 0, list);
        this.list = list;
        this.onClickListener = onClickListener;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            Context context = getContext();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_list_layout,parent,false);
        }
        Item item = list.get(position);
        TextView textView = view.findViewById(R.id.idTextViewItem);
        textView.setText(item.getItem());
        Button button = view.findViewById(R.id.idBtDelItem);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickListener.onClickDelItem(item);
                    }
                }
        );
        return  view;
    }

    public interface onClickItem{
        public void onClickDelItem(Item item);
    }
}
