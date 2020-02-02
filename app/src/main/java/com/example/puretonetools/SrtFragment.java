package com.example.puretonetools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SrtFragment extends Fragment implements OnClickListener {
    int dogru;
    public int i;
    private boolean isSDS;
    String[] list;
    int listcount;
    private OnFragmentInteractionListener mListener;
    private int page;
    private String title;

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public static SrtFragment newInstance(int page, String title, boolean isSDS) {
        SrtFragment fragment = new SrtFragment();
        Bundle args = new Bundle();
        args.putInt("someint", page);
        args.putString("sometitle", title);
        args.putBoolean("Issds", isSDS);
        fragment.setArguments(args);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.page = getArguments().getInt("someint", 1);
            this.title = getArguments().getString("sometitle");
            this.isSDS = getArguments().getBoolean("Issds");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_srt, container, false);
    }

    public void onButtonPressed(Uri uri) {
        OnFragmentInteractionListener onFragmentInteractionListener = this.mListener;
        if (onFragmentInteractionListener != null) {
            onFragmentInteractionListener.onFragmentInteraction(uri);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView pert = (TextView) getView().findViewById(R.id.percent);
        pert.setVisibility(View.INVISIBLE);
        TextView srtText = (TextView) getView().findViewById(R.id.srtText);
        Button once = (Button) getView().findViewById(R.id.onceki);
        once.setOnClickListener(this);
        Button basa = (Button) getView().findViewById(R.id.basadon);
        basa.setOnClickListener(this);
        Button sonra = (Button) getView().findViewById(R.id.sonraki);
        sonra.setOnClickListener(this);
        if (isSDS) {
            once.setText("Yanlış");
            basa.setText("Sonraki Liste");
            sonra.setText("Doğru");
            pert.setVisibility(View.VISIBLE);
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void onClick(View v) {
        TextView srtText = (TextView) getView().findViewById(R.id.srtText);
        switch (v.getId()) {


        }


    }
}
