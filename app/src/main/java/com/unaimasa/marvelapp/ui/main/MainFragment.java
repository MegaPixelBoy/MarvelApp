package com.unaimasa.marvelapp.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.unaimasa.marvelapp.R;
import com.unaimasa.marvelapp.model.MarvelCharacter;
import com.unaimasa.marvelapp.model.MarvelComic;
import com.unaimasa.marvelapp.util.CircleTransform;
import com.unaimasa.marvelapp.util.ImageUtil;
import com.unaimasa.marvelapp.util.SimpleDividerItemDecoration;
import com.unaimasa.marvelapp.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


public class MainFragment extends Fragment implements MainContract.View {

    public static final String FRAGMENT_TAG = "_main_fragment";
    public static final String CAPTAIN_AMERICA_ID = "1009220";

    private MainContract.Presenter mMainPresenter;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private ImageView mCharacterImage;
    private TextView mCharacterDescription;

    private LinearLayoutManager mLayoutManager;
    private RecyclerView mMainRecyclerView;
    private MainAdapter mMainAdapter;

    private ProgressBar mMainProgressBar;

    private boolean loading = true;
    private int pastVisibleItems;
    private int visibleItemCount;
    private int totalItemCount;


    public MainFragment() {
        // Requires empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainAdapter = new MainAdapter(new ArrayList<MarvelComic>(), getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) root.findViewById(R.id.collapsing_toolbar);

        mCharacterImage = (ImageView) root.findViewById(R.id.iv_character);

        mCharacterDescription = (TextView) root.findViewById(R.id.tv_character_description);

        mMainRecyclerView = (RecyclerView) root.findViewById(R.id.rv_character_comics);
        mMainRecyclerView.setHasFixedSize(true);
        mMainRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

        mLayoutManager = new LinearLayoutManager(this.getContext());
        mMainRecyclerView.setLayoutManager(mLayoutManager);
        mMainRecyclerView.setAdapter(mMainAdapter);

        mMainProgressBar = (ProgressBar) root.findViewById(R.id.pb_load_main_info);

        mMainRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0) {
                    visibleItemCount = mLayoutManager.getChildCount();
                    totalItemCount = mLayoutManager.getItemCount();
                    pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if ( (visibleItemCount + pastVisibleItems) >= (totalItemCount / 2)) {
                            loading = false;
                            mMainProgressBar.setVisibility(View.VISIBLE);
                            mMainPresenter.populateCharacterComicList(CAPTAIN_AMERICA_ID);
                        }
                    }
                }
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainPresenter.populateCharacterInfo(CAPTAIN_AMERICA_ID);
    }

    // ----- Base View Methods ----- //
    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mMainPresenter = checkNotNull(presenter);
    }

    // ----- Main Contract View Methods ----- //
    @Override
    public void startLoading() {
        loading = true;
    }

    @Override
    public void showCharacterInfo(MarvelCharacter marvelCharacter) {
        mCollapsingToolbarLayout.setTitle(marvelCharacter.getName());
        String characterThumbnail = ImageUtil.getMarvelImageProtraitMedium(marvelCharacter.getThumbnail());
        Picasso.with(getContext()).load(characterThumbnail).transform(new CircleTransform()).into(mCharacterImage);
        mCharacterDescription.setText(StringUtil.splitString(marvelCharacter.getDescription()));
    }

    @Override
    public void showCharacterComics(List<MarvelComic> marvelComics) {
        mMainAdapter.swap(marvelComics);
        mMainProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorToast() {
        mMainProgressBar.setVisibility(View.GONE);
        Toast.makeText(this.getContext(), "Network Error", Toast.LENGTH_LONG).show();
    }
}
