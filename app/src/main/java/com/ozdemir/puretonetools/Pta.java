package com.ozdemir.puretonetools;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


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
     *
     *
     */
    // TODO: Rename and change types and number of parameters
    public static Pta newInstance(int page, String title) {
        Pta fragment = new Pta();
        Bundle args = new Bundle();
        args.putInt("someint", page );
        args.putString("sometitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           page=getArguments().getInt("someint",0);
           title=getArguments().getString("sometitle");
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
        switch (v.getId()){
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

                int a=Integer.parseInt(bh.getText().toString());
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
                alr.Ptacal(a, b, c, d, j, g, f, k, false);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setMessage(alr.Ptacal(a, b, c, d, j, g, f, k, false) +System.lineSeparator()  + all.Ptacal(al, bl, cl, dl, jl, gl, fl, kl, true));
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button temiz = getView().findViewById(R.id.temizle);
       temiz.setOnClickListener(this);
       Button hesap = getView().findViewById(R.id.Hesapla);
       hesap.setOnClickListener(this);





    }


}

