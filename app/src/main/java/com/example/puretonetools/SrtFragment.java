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
    public int i = 0;
    private boolean isSDS;
    String[] list;
    int listcount;
    private OnFragmentInteractionListener mListener;
    private int page;
    private String title;
    int yuzde;
    boolean isclikedonceki = true;

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
//TODO TAKE SRT CALCULATIONS TO ANTOHER CLASS AND CREATE SORURCES.XML TO MULTİLANG SUPPORT

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
        TextView pert = (TextView) getView().findViewById(R.id.yuzde);
        pert.setVisibility(View.INVISIBLE);
        TextView srtText = (TextView) getView().findViewById(R.id.srtText);
        srtText.setText("Hatıra");
        Button once = (Button) getView().findViewById(R.id.onceki);
        once.setOnClickListener(this);
        Button basa = (Button) getView().findViewById(R.id.basadon);
        basa.setOnClickListener(this);
        Button sonra = (Button) getView().findViewById(R.id.sonraki);
        sonra.setOnClickListener(this);
        if (isSDS) {
            once.setText(R.string.yanlis);
            basa.setText(R.string.degis);
            sonra.setText(R.string.dogru);
            pert.setVisibility(View.VISIBLE);
            srtText.setText("Kas");
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void onClick(View v) {
        TextView srtText = (TextView) getView().findViewById(R.id.srtText);
        TextView pert = (TextView) getView().findViewById(R.id.yuzde);
        if (!isSDS) {
            list = getResources().getStringArray(R.array.srt_list);


            switch (v.getId()) {

                case (R.id.basadon):
                    i = 0;
                    srtText.setText(list[0]);
                    break;
                case (R.id.sonraki):
                    if (i < list.length - 1) {
                        i++;
                        srtText.setText(list[i]);

                    }
                    break;
                case (R.id.onceki):
                    if (i > 0) {
                        i--;
                        srtText.setText(list[i]);
                    }


                    break;


            }

        }
        if (isSDS) {

            switch (v.getId()) {

                case (R.id.basadon):
                    switch (listcount) {
                        case (0):
                            list = null;
                            list = getResources().getStringArray(R.array.sds_1);

                            srtText.setText(list[0]);
                            i = 0;
                            dogru = 0;
                            listcount++;
                            break;


                        case (1):
                            list = null;
                            list = getResources().getStringArray(R.array.sds_2);

                            srtText.setText(list[0]);
                            i = 0;
                            dogru = 0;
                            listcount++;
                            break;

                        case (2):
                            list = null;
                            list = getResources().getStringArray(R.array.sds_3);
                            i = 0;
                            srtText.setText(list[0]);
                            dogru = 0;
                            listcount++;
                            break;

                        case (3):
                            list = null;
                            list = getResources().getStringArray(R.array.sds_4);
                            i = 0;
                            dogru = 0;
                            srtText.setText(list[0]);
                            listcount++;
                            break;

                        case (4):
                            list = null;
                            list = getResources().getStringArray(R.array.sds_5);
                            i = 0;
                            srtText.setText(list[0]);
                            dogru = 0;
                            listcount++;
                            break;

                        case (5):
                            list = null;
                            list = getResources().getStringArray(R.array.sds_6);
                            i = 0;
                            srtText.setText(list[0]);
                            dogru = 0;
                            listcount = 0;

                            break;
                    }
                    break;


                case (R.id.sonraki):
                    if (i < 25) {
                        if (isclikedonceki) {
                            list = new String[]{"Kas", "At", "Ney", "Öç", "Bir", "Küf", "Saz", "Fon", "Pes", "Yün", "Bek", "Pay", "Sel", "Aç", "Dün", "Koz", "Ürk", "Zar", "Boy", "Baş", "Türk", "Yaş", "Ver", "Çak", "Şap", "Sonuç:"};
                            isclikedonceki = false;

                        }
                        i++;
                        dogru++;
                        srtText.setText(list[i]);
                        pert.setText(String.valueOf(dogru * 4));


                    }

                    break;
                case (R.id.onceki):
                    if (i < 25) {
                        i++;
                        srtText.setText(list[i]);
                    }

                    break;


            }

        }


    }


}






