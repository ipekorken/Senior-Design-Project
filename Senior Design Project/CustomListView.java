package com.example.pc.deepmakeupkiller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {

    private String [] markalar;
    private String [] adlar;
    private String [] renkler;
    private String [] fiyatlar;
    private Integer [] resimler;
    private Activity context;

    public CustomListView(Activity context, String [] markalar, String [] adlar, String [] renkler, String [] fiyatlar, Integer [] resimler) {
        super(context, R.layout.listview_layout, markalar);

        this.context=context;
        this.markalar=markalar;
        this.adlar=adlar;
        this.renkler=renkler;
        this.fiyatlar=fiyatlar;
        this.resimler=resimler;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        CustomListView.ViewHolder viewHolder = null;
        if(r==null) {

            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder = new CustomListView.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {

            viewHolder = (CustomListView.ViewHolder)r.getTag();
        }
        viewHolder.imageView.setImageResource(resimler[position]);
        viewHolder.tvurunmarka.setText(markalar[position]);
        viewHolder.tvurunad.setText(adlar[position]);
        viewHolder.tvurunrenk.setText(renkler[position]);
        viewHolder.tvurunfiyat.setText(fiyatlar[position]);

        return r;
    }

    class ViewHolder {

        TextView tvurunmarka, tvurunad, tvurunrenk, tvurunfiyat;
        ImageView imageView;
        ViewHolder(View v) {

            tvurunmarka = (TextView)v.findViewById(R.id.tvurunmarka);
            tvurunad = (TextView)v.findViewById(R.id.tvurunad);
            tvurunrenk = (TextView)v.findViewById(R.id.tvurunrenk);
            tvurunfiyat = (TextView)v.findViewById(R.id.tvurunfiyat);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }

    }
}