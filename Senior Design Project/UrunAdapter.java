package com.example.pc.deepmakeupkiller;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pc.deepmakeupkiller.Fragments.ListFragment;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class UrunAdapter extends RecyclerView.Adapter<UrunAdapter.ImageViewHolder> {
    @NonNull

    private Context mContext;
    private List<Urun> urunList;

    public UrunAdapter(Context context, List<Urun> uruns) {

        mContext = context;
        urunList = uruns;
    }

    public UrunAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listview_layout,viewGroup, false);
        return new UrunAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UrunAdapter.ImageViewHolder holder, int i) {
        final Urun post = urunList.get(i);
        Glide.with(mContext).load(post.getRujImg()).into(holder.post_image);
        holder.ad.setText(post.getAd());
        holder.fiyat.setText(post.getFiyat().toString());
        holder.renk.setText(post.getRenk());
        holder.marka.setText(post.getMarka());
        holder.post_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + mContext.getResources().getResourcePackageName(R.drawable.rujsecimi2boyutlu)
                        + '/' + mContext.getResources().getResourceTypeName(R.drawable.rujsecimi2boyutlu)
                        + '/' + mContext.getResources().getResourceEntryName(R.drawable.rujsecimi2boyutlu) );
                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                //     editor.putString("profileforteacherid", publisher);
                editor.putString("marka",null);
                editor.putString("uri",imageUri.toString());
                editor.apply();
                ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ListFragment()).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
      return  urunList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder  {
        public ImageView post_image;
        public TextView fiyat,ad,renk,marka;

        public ImageViewHolder(View itemView) {
            super(itemView);

           post_image = itemView.findViewById(R.id.imageView);
           fiyat =itemView.findViewById(R.id.tvurunfiyat);
           ad=itemView.findViewById(R.id.tvurunad);
           renk= itemView.findViewById(R.id.tvurunrenk);
           marka=itemView.findViewById(R.id.tvurunmarka);

        }
    }
}
