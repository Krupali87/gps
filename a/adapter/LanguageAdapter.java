package com.app.gpsphonelocator_new.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.phone.language.IClickLanguage;
import com.app.gpsphonelocator_new.phone.model.LanguageModel;
import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.phone.language.IClickLanguage;
import com.app.gpsphonelocator_new.phone.model.LanguageModel;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {
    private final Context context;
    private final IClickLanguage iClickLanguage;
    private final List<LanguageModel> lists;

    public LanguageAdapter(Context context, List<LanguageModel> list, IClickLanguage iClickLanguage) {
        this.context = context;
        this.lists = list;
        this.iClickLanguage = iClickLanguage;
    }


    @Override
    public LanguageViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_language, parent, false);
        return new LanguageViewHolder(view);
    }

    @Override
    public void onBindViewHolder( LanguageViewHolder holder, int position) {
        LanguageModel languageModel = lists.get(position);
        holder.imgLanguage.setImageResource(languageModel.getImage());
        holder.tvTitle.setText(languageModel.getLanguageName());

        if (languageModel.isCheck()) {
            holder.layoutItem.setBackgroundResource(R.drawable.bg_item_language_selected);
            holder.tvTitle.setTextColor(Color.WHITE);
        } else {
            holder.layoutItem.setBackgroundResource(R.drawable.bg_item_language);
            holder.tvTitle.setTextColor(Color.parseColor("#08154B"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheck(languageModel.getCode());
                iClickLanguage.onClick(languageModel);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists != null ? lists.size() : 0;
    }

    public static class LanguageViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLanguage;
        View layoutItem;
        TextView tvTitle;

        public LanguageViewHolder(View view) {
            super(view);
            imgLanguage = view.findViewById(R.id.img_language);
            tvTitle = view.findViewById(R.id.tv_title);
            layoutItem = view.findViewById(R.id.relay_language);
        }
    }

    public void setCheck(String str) {
        for (LanguageModel next : lists) {
            next.setCheck(next.getCode().equals(str));
        }
        notifyDataSetChanged();
    }
}