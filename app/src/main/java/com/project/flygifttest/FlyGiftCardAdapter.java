package com.project.flygifttest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author suzhuning
 * @date 2017/3/7.
 * Description:
 */
public class FlyGiftCardAdapter extends BaseAdapter {

    private List<DataEntity> datas;

    private int cardWidth;
    private int cardHeight;

    public FlyGiftCardAdapter(){
        datas = new ArrayList<>();
    }

    public FlyGiftCardAdapter(int cardWidth, int cardHeight) {
        this();
        this.cardWidth = cardWidth;
        this.cardHeight = cardHeight;
    }

    public void addAll(Collection<DataEntity> collection) {
        if (isEmpty()) {
            datas.addAll(collection);
            notifyDataSetChanged();
        } else {
            datas.addAll(collection);
        }
    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return datas.isEmpty();
    }

    public void remove(int index) {
        if (index > -1 && index < datas.size()) {
            datas.remove(index);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public DataEntity getItem(int i) {
        if(datas == null || datas.size() == 0) return null;
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder;
        DataEntity dataItem = getItem(i);
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_gift_item, parent, false);
            holder = new ViewHolder();
            convertView.setTag(holder);

            convertView.getLayoutParams().width = cardWidth;
            holder.portraitView = ButterKnife.findById(convertView, R.id.portrait);
            holder.portraitView.getLayoutParams().height = cardHeight;
            holder.nameView = ButterKnife.findById(convertView, R.id.name);
            holder.cityView = ButterKnife.findById(convertView, R.id.city);
            holder.eduView = ButterKnife.findById(convertView, R.id.education);
            holder.workView = ButterKnife.findById(convertView, R.id.work_year);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.portraitView.setImageResource(dataItem.getImgRes());
        holder.nameView.setText(dataItem.getName());
        holder.cityView.setText(dataItem.getLocation());
        holder.cityView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_location,0,0);
        holder.eduView.setText(dataItem.getCollege());
        holder.eduView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_edu,0,0);
        holder.workView.setText(dataItem.getYear());
        holder.workView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_work_year,0,0);

        return convertView;
    }

    private static class ViewHolder {
        ImageView portraitView;
        TextView nameView;
        TextView cityView;
        TextView eduView;
        TextView workView;
    }
}
