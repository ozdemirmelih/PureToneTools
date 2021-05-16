package com.ozdemir.puretonetools;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pta.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pta extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    int a;
    int b;
    int c;
    int d;
    // TODO: Rename and change types of parameters
    private int page;
    private String title;

    private OnFragmentInteractionListener mListener;

    public Pta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static Pta newInstance(int page, String title) {
        Pta fragment = new Pta();
        Bundle args = new Bundle();
        args.putInt("someint", page);
        args.putString("sometitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt("someint", 0);
            title = getArguments().getString("sometitle");


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pta, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        EditText bh = getView().findViewById(R.id.besyuzHava);
        EditText binh = getView().findViewById(R.id.binhava);
        EditText ikih = getView().findViewById(R.id.ikibinhava);
        EditText dorth = getView().findViewById(R.id.dortbinhava);
        EditText bk = getView().findViewById(R.id.besyuzkemik);
        EditText bink = getView().findViewById(R.id.binkemik);
        EditText ikik = getView().findViewById(R.id.ikibinkemik);
        EditText dortk = getView().findViewById(R.id.dortbinkemik);
        EditText bhl = getView().findViewById(R.id.solbesyuzHava);
        EditText binhl = getView().findViewById(R.id.solbinhava);
        EditText ikihl = getView().findViewById(R.id.solikibinhava);
        EditText dorthl = getView().findViewById(R.id.soldortbinhava);
        EditText bkl = getView().findViewById(R.id.solbesyuzkemik);
        EditText binkl = getView().findViewById(R.id.solbinkemik);
        EditText ikikl = getView().findViewById(R.id.solikibinkemik);
        EditText dortkl = getView().findViewById(R.id.soldortbinkemik);
        LineChart chart = getView().findViewById(R.id.chart);
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("125");
        xAxisLabel.add("250");
        xAxisLabel.add("500");
        xAxisLabel.add("1000");
        xAxisLabel.add("2000");
        xAxisLabel.add("4000");
        xAxisLabel.add("8000");
        YAxis leftAxis = chart.getAxisLeft();
        YAxis rightaxis = chart.getAxisRight();
        XAxis up = chart.getXAxis();
        chart.setVisibleXRange(125, 8000);
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLabel));
        leftAxis.setAxisMaximum(120);
        leftAxis.setAxisMinimum(-20);
        leftAxis.setInverted(true);
        // chart.setTouchEnabled(false);
        leftAxis.setLabelCount(15, true);
        rightaxis.setAxisMaximum(120);
        rightaxis.setAxisMinimum(-20);
        rightaxis.setInverted(true);
        // chart.setTouchEnabled(false);
        rightaxis.setLabelCount(15, true);


        switch (v.getId()) {
            case R.id.temizle:

                bh.setText("0");
                binh.setText("0");
                ikih.setText("0");
                dorth.setText("0");
                bk.setText("0");
                binhl.setText("0");
                bink.setText("0");
                ikik.setText("0");
                dortk.setText("0");
                bhl.setText("0");
                ikihl.setText("0");
                dorthl.setText("0");
                bkl.setText("0");
                binkl.setText("0");
                ikikl.setText("0");
                dortkl.setText("0");
                break;
            case R.id.Hesapla:

                int a = Integer.parseInt(bh.getText().toString());
                int b = Integer.parseInt(binh.getText().toString());
                int c = Integer.parseInt(ikih.getText().toString());
                int d = Integer.parseInt(dorth.getText().toString());

                int j = Integer.parseInt(bk.getText().toString());
                int f = Integer.parseInt(bink.getText().toString());
                int g = Integer.parseInt(ikik.getText().toString());
                int k = Integer.parseInt(dortk.getText().toString());

                int al = Integer.parseInt(bhl.getText().toString());
                int bl = Integer.parseInt(binhl.getText().toString());
                int cl = Integer.parseInt(ikihl.getText().toString());
                int dl = Integer.parseInt(dorthl.getText().toString());

                int jl = Integer.parseInt(bkl.getText().toString());
                int fl = Integer.parseInt(binkl.getText().toString());
                int gl = Integer.parseInt(ikikl.getText().toString());
                int kl = Integer.parseInt(dortkl.getText().toString());
                PtaCalc alr = new PtaCalc();
                PtaCalc all = new PtaCalc();


                LineDataSet dataSet1 = new LineDataSet(ptaair(a, b, c, d), "sağ hava");
                dataSet1.setCircleColor(Color.RED);

                LineDataSet dataSet2 = new LineDataSet(ptabone(j, f, g, k), "sağkemik");
                LineDataSet dataSet3 = new LineDataSet(ptaair(al, bl, cl, dl), "sol Hava");
                LineDataSet dataSet4 = new LineDataSet(ptabone(jl, fl, gl, kl), "sol kemik");
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(dataSet1);
                dataSets.add(dataSet2);
                dataSets.add(dataSet3);
                dataSets.add(dataSet4);
                LineData data = new LineData(dataSets);
                chart.setData(data);

                alr.Ptacal(a, b, c, d, j, g, f, k, false);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setMessage(alr.Ptacal(a, b, c, d, j, g, f, k, false) + System.lineSeparator() + all.Ptacal(al, bl, cl, dl, jl, gl, fl, kl, true));
                builder1.setCancelable(true);
                builder1.setTitle("Sonuçlar:");

                builder1.setPositiveButton(
                        "Tamam",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                break;

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button temiz = getView().findViewById(R.id.temizle);
        temiz.setOnClickListener(this);
        Button hesap = getView().findViewById(R.id.Hesapla);
        hesap.setOnClickListener(this);


    }

    private ArrayList<Entry> ptabone(int a, int b, int c, int d) {
        ArrayList<Entry> ptaset = new ArrayList<Entry>();
        ptaset.add(new Entry(0, a));
        ptaset.add(new Entry(1, b));
        ptaset.add(new Entry(2, c));
        ptaset.add(new Entry(3, d));
        return ptaset;
    }

    private ArrayList<Entry> ptaair(int a, int b, int c, int d) {
        ArrayList<Entry> ptaset = new ArrayList<Entry>();
        ptaset.add(new Entry(0, a));
        ptaset.add(new Entry(1, a));
        ptaset.add(new Entry(2, a));
        ptaset.add(new Entry(3, b));
        ptaset.add(new Entry(4, c));
        ptaset.add(new Entry(5, d));
        ptaset.add(new Entry(6, d));
        return ptaset;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}

