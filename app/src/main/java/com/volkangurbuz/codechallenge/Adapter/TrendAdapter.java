package com.volkangurbuz.codechallenge.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.volkangurbuz.codechallenge.Model.Repo;
import com.volkangurbuz.codechallenge.Model.RepoDetails;
import com.volkangurbuz.codechallenge.Model.Trend;
import com.volkangurbuz.codechallenge.R;

import java.util.List;

public class TrendAdapter extends RecyclerView.Adapter<TrendAdapter.ContactViewHolder> {


    private List<Trend> trendList;
    private List<Repo> repoList;

    public TrendAdapter(List<Trend> trendList, List<Repo> repoList) {
        this.trendList = trendList;
        this.repoList = repoList;
    }

    public TrendAdapter(List<Trend> trendList) {
        this.trendList = trendList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.trend_list_row, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {

        Trend t =  trendList.get(i);
        Repo r = repoList.get(i);

        contactViewHolder.name.setText(t.getName());
        contactViewHolder.nameDetail.setText(t.getNameDetail());
        contactViewHolder.url.setText(t.getUrl());
        contactViewHolder.star.setText(r.getStar()+"");
        contactViewHolder.watcher.setText(r.getWatcher()+"");

    }

    @Override
    public int getItemCount() {
        return trendList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView name, nameDetail, url, star, watcher;

        public ContactViewHolder(View v){
            super(v);

            name = v.findViewById(R.id.userName);
            nameDetail = v.findViewById(R.id.userNameDetail);
            url = v.findViewById(R.id.url);
            star = v.findViewById(R.id.star);
            watcher = v.findViewById(R.id.watcher);


        }

    }



}
