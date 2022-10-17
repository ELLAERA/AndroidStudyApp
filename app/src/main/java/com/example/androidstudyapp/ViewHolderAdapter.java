package com.example.androidstudyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewHolderAdapter extends BaseAdapter {
    public static class ViewHolderModel {
        public String name;
        public String mail;
        public String mobile;

        public ViewHolderModel(String a, String b, String c) {
            name = a;
            mail = b;
            mobile = c;
        }
    }
    public static class ViewHolder {
        TextView nameTxv;
        TextView mailTxv;
        TextView mobileTxv;

        public void bind(ViewHolderModel data) {
            nameTxv.setText(data.name);
            mailTxv.setText(data.mail);
            mobileTxv.setText(data.mobile);
        }
    }

    private Context ctx;
    private ArrayList<ViewHolderModel> data;

    @Override
    public int getCount() {
        return data.size();
    }
    @Override
    public Object getItem(int i) {
        return data.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    public ViewHolderAdapter(Context ctx, ArrayList<ViewHolderModel> data) {
        //super(ctx, rid, data);
        this.ctx = ctx;
        this.data = data;
        int n = 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;

        if (view == null) {
            LayoutInflater lyInflt = LayoutInflater.from(ctx);
            view  = lyInflt.inflate(R.layout.adapter_view_holder, null);

            vh = new ViewHolder();
            vh.nameTxv = view.findViewById(R.id.txt_value_name);
            vh.mailTxv = view.findViewById(R.id.txt_value_email);
            vh.mobileTxv = view.findViewById(R.id.txt_value_mobile);
        }
        else
            vh = (ViewHolder) view.getTag();

        if (vh != null && i < data.size())
            vh.bind(data.get(i));

        return view;
    }
}