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
    boolean isclikedonceki;

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

        if (!isSDS) {
            list = new String[]{"Hatıra", "Fotoğraf", "Hediye", "Tebeşir", "Sinema", "Tükenmez", "Salıncak", "Oduncu", "Harika", "Bayraklı", "Hamarat", "Hünerli", "Hemşire", "Havadar", "Paskalya", "Parmaklık", "Merdiven", "Sıradağ", "Asansör", "Coğrafya", "Harita", "Aracı ", "Pusula", "Telefon", "Şekerli", "Kafadar", "Yükseklik", "Kiracı", "Korkulu", "Satılık", "Kapalı", "Marmara", "Yasemin", "Kolonya", "Karanlık", "Badana", "Kaçamak", "Aydınlık", "Boyalı", "Yoğurtlu", "Hastalık", "Demirci", "Kulaklık", "Okyanus", "Dokuma", "Halıcı", "Sonbahar", "Kaymaklı", "İşitme", "Sarıyer", "Limonlu", "Adana", "Köstebek", "Cevizli", "İndirim", "Fıstıklı", "Tarafsız", "Kaplıca", "Çiçekli", "Akarsu", "Değerli", "Çilingir", "Yakacak", "Dönemeç", "Elbise", "Kızamık", "Papatya", "Giyecek", "Güvercin", "Kıvılcım", "Fabrika", "Aralık", "Sekreter", "Yasama", "Ağustos", "Ünite", "Çaydanlık", "Tüketim", "Otobüs", "Harabe", "Üretim", "Serinlik", "Postacı", "Dağıtım", "Tabure", "Tutacak", "Gemici", "Eflatun", "Danışma", "Arkadaş", "Değerli", "Çilingir", "Yakacak", "Dönemeç", "Elbise", "Kızamık", "Papatya", "Giyecek", "Güvercin", "Kıvılcım", "Fabrika", "Aralık", "Sekreter", "Yasama", "Ağustos", "Ünite", "Çaydanlık", "Tüketim", "Otobüs", "Harabe", "Üretim", "Serinlik", "Postacı", "Dağıtım", "Tabure", "Tutacak", "Gemici", "Eflatun", "Danışma", "Arkadaş", "Kızılcık", "Tabaka", "Kıymetli", "Cesaret", "Kahveci", "Lacivert", "Kanarya", "Çankırı", "Şikayet", "Karavan", "Begonya", "Öğrenci", "Hastane", "Lokanta", "Karanfil", "Pastane", "Domates", "Süpürge", "Köstebek", "Eczane", "Kanepe", "Haziran", "Kıvırcık", "Sürekli", "Sandalye", "Ihlamur", "Öneri", "Harita", "Denetim", "Kelime", "Kilimci", "Sipariş", "Patlıcan", "Gelincik", "Esinti", "Maydanoz", "Kitaplık", "Akasya", "Gezinti", "Gelenek", "Makina", "Hatalı", "Emanet", "Görenek", "Çekmece", "Bereket", "Tedavi", "Baharat", "Bankacı", "Kırmızı", "Hareket", "Eleman", "Etiket", "Almanya", "Hazine", "Derece", "Sigorta", "Hürriyet", "Hikaye", "Sanayi"
            };

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


    }


}






