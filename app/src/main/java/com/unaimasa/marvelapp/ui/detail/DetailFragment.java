package com.unaimasa.marvelapp.ui.detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.unaimasa.marvelapp.R;
import com.unaimasa.marvelapp.util.CircleTransform;

import static com.google.common.base.Preconditions.checkNotNull;

public class DetailFragment extends Fragment implements DetailContract.View{

    public static final String FRAGMENT_TAG = "_detail_fragment";

    private DetailContract.Presenter mDetailPresenter;

    private Toolbar mToolbar;

    private ImageView mComicImage;
    private TextView mComicTitle;
    private TextView mComicDescription;

    public DetailFragment() {
        // Requires empty public constructor
    }

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.detail_fragment, container, false);

        mToolbar = (Toolbar) root.findViewById(R.id.detail_toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        activity.getSupportActionBar().setTitle("Comic Information");

        mComicImage = (ImageView) root.findViewById(R.id.iv_comic_thumbnail_detail);
        mComicTitle = (TextView) root.findViewById(R.id.tv_comic_title_detail);
        mComicDescription = (TextView) root.findViewById(R.id.tv_comic_description_detail);

        return root;
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mDetailPresenter = checkNotNull(presenter);
    }

    // ----- Detail Contract View Methods ----- //
    @Override
    public void setComicInformation(String title, String description, String thumbnail) {
        mComicTitle.setText(title);
        mComicDescription.setText(description);
        Picasso.with(getContext()).load(thumbnail).into(mComicImage);
    }
}
