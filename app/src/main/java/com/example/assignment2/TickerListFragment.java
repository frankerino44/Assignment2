package com.example.assignment2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.assignment2.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class TickerListFragment extends Fragment {

    private RecyclerView recyclerView;

    private List<String> tickers;
    /*
    public TickerListFragment() {
        adapter = new MyItemRecyclerViewAdapter();
    }

     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticker_list, container, false);
        tickers = new ArrayList<>();
        tickers.add("TSLA");
        tickers.add("F");
        tickers.add("AMZN");
        recyclerView = view.findViewById(R.id.recyclerViewTickerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TickersAdapter(tickers));
        //recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener()));
        return view;
    }


    class TickersAdapter extends RecyclerView.Adapter<TickerViewHolder>{

        private List<String> tickers;

        public TickersAdapter(List<String> tickers) {
            super();
            this.tickers = tickers;
        }

        @NonNull
        @Override
        public TickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TickerViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TickerViewHolder holder, int position) {
            holder.bind(this.tickers.get(position));
        }

        @Override
        public int getItemCount() {
            return this.tickers.size();
        }
    }



    class TickerViewHolder extends RecyclerView.ViewHolder {
        private TextView tickerTextView;
        public TickerViewHolder(ViewGroup itemView) {
            super(itemView);
            tickerTextView = itemView.findViewById(R.id.textViewTicker);
        }
        public void bind(String ticker) {
            tickerTextView.setText(ticker);
        }
    }
}