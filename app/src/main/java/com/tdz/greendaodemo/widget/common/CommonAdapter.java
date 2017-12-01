package com.tdz.greendaodemo.widget.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by HaoXi on 2017/6/4.
 */

/**
 * 通用适配器
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private Context                 context;
    private LayoutInflater          inflater;
    private List<T>                 list;
    private int                     layoutId;
    private String                  dataId; //数据id
    private OnItemClickListener     itemClickListener;
    private OnItemLongClickListener itemLongClickListener;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public CommonAdapter(Context context, List<T> list, int layoutId) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final CommonViewHolder viewHolder = getViewHolder(position, convertView, parent);

        convert(viewHolder, (T) getItem(position));
        final View view = viewHolder.getConvertView();
        if (itemClickListener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(view, position);
                }
            });
        }
        if (itemLongClickListener != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemLongClickListener.onItemLongClick(view, position);
                    return true;
                }
            });
        }
        return view;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    /**
     * 获取ViewHolder
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    private CommonViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return CommonViewHolder.get(context, convertView, parent, layoutId, position);
    }

    public abstract void convert(CommonViewHolder viewHolder, T item);

    public interface OnItemClickListener {
        public void onItemClick(View itemView, int pos);
    }

    public interface OnItemLongClickListener {
        public void onItemLongClick(View itemView, int pos);
    }
}
