package com.unaimasa.marvelapp.ui.main;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.unaimasa.marvelapp.R;
import com.unaimasa.marvelapp.model.MarvelComic;
import com.unaimasa.marvelapp.ui.detail.DetailActivity;
import com.unaimasa.marvelapp.util.CircleTransform;
import com.unaimasa.marvelapp.util.ImageUtil;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ComicsViewHolder> {

    private List<MarvelComic> mMarvelComicList;
    private Context mContext;

    public MainAdapter(List<MarvelComic> marvelComicList, Context context) {
        this.mMarvelComicList = marvelComicList;
        this.mContext = context;
    }

    @Override
    public ComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_list_fragment_character_comic_row, parent, false);

        return new ComicsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComicsViewHolder holder, int position) {
        MarvelComic marvelComic = mMarvelComicList.get(position);
        holder.mComicTitle.setText(marvelComic.getTitle());
        String comicThumbnail = ImageUtil.getMarvelImageProtraitMedium(marvelComic.getThumbnail());
        Picasso.with(mContext).load(comicThumbnail).transform(new CircleTransform()).into(holder.mComicThumbnail);
        holder.setMarvelComic(marvelComic);
    }

    @Override
    public int getItemCount() {
        return mMarvelComicList.size();
    }

    public void swap(List<MarvelComic> gitHubUsersList){
        mMarvelComicList.addAll(gitHubUsersList);
        this.notifyDataSetChanged();
    }

    // ----- Movie View Holder ----- //
    class ComicsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mComicThumbnail;
        private TextView mComicTitle;
        private MarvelComic mMarvelComic;

        ComicsViewHolder(View view) {
            super(view);
            mComicThumbnail = (ImageView) view.findViewById(R.id.iv_comic_thumbnail);
            mComicTitle = (TextView) view.findViewById(R.id.tv_comic_title);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String comicThumbnail = ImageUtil.getMarvelImagePortraitIncredible(mMarvelComic.getThumbnail());
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("marvel_comic_title", mMarvelComic.getTitle());
            intent.putExtra("marvel_comic_description", mMarvelComic.getDescription());
            intent.putExtra("marvel_comic_image_url", comicThumbnail);
            mContext.startActivity(intent);
        }

        public void setMarvelComic(MarvelComic marvelComic) {
            this.mMarvelComic = marvelComic;
        }
    }
}
