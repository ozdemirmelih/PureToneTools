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
            once.setText("Yanlış");
            basa.setText("Sonraki Liste");
            sonra.setText("Doğru");
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
        if (isSDS) {

            switch (v.getId()) {

                case (R.id.basadon):
                    switch (listcount) {
                        case (0):
                            list = null;
                            list = new String[]{"Kas", "At", "Ney", "Öç", "Bir", "Küf", "Saz", "Fon", "Pes", "Yün", "Bek", "Pay", "Sel", "Aç", "Dün", "Koz", "Ürk", "Zar", "Boy", "Baş", "Türk", "Yaş", "Ver", "Çak", "Şap", "Sonuç:"};
                            srtText.setText(list[0]);
                            i = 0;
                            dogru = 0;
                            listcount++;
                            break;


                        case (1):
                            list = null;
                            list = new String[]{"Az", "Borç", "Düş", "Et", "Hür", "Kaz", "Çok", "Muş", "Ol", "Leş", "Pot", "Bal", "Tuş", "Şef", "Pek", "Çiz", "Fer", "Hat", "Ve", "Öp", "İç", "Bel", "Kurt", "Yem", "Zıt", "Sonuç:"};
                            srtText.setText(list[0]);
                            i = 0;
                            dogru = 0;
                            listcount++;
                            break;

                        case (2):
                            list = null;
                            list = new String[]{"Beş", "Göz", "İn", "Kar", "Laf", "Diş", "Muz", "Ak", "Örf", "Çat", "Koç", "Fal", "Ney", "Şen", "Ruh", "Dağ", "Tel", "Kız", "Set", "Yıl", "Kök", "Pil", "Zam", "Yık", "Bey", "Sonuç:"};
                            i = 0;
                            srtText.setText(list[0]);
                            dogru = 0;
                            listcount++;
                            break;

                        case (3):
                            list = null;
                            list = new String[]{"Çay", "Ot", "Fil", "Ön", "Kor", "Al", "Sarp", "Ez", "Dost", "Kul", "Kem", "Sık", "Buz", "Nal", "Sap", "Raf", "Tül", "Cep", "Terk", "Kan", "Şal", "Güz", "Küp", "Din", "Loş", "Sonuç:"};
                            i = 0;
                            dogru = 0;
                            srtText.setText(list[0]);
                            listcount++;
                            break;

                        case (4):
                            list = null;
                            list = new String[]{"Lav", "Kep", "Dik", "Biç", "Öt", "Ser", "Böl", "Var", "İp", "Zarf", "Rey", "Mis", "Post", "Af", "Sat", "Yar", "Nem", "Git", "Çar", "Sis", "Han", "Püf", "Sonuç:"};
                            i = 0;
                            srtText.setText(list[0]);
                            dogru = 0;
                            listcount++;
                            break;

                        case (5):
                            list = null;
                            list = new String[]{"Kir", "Çan", "Öl", "Sen", "Kalp", "An", "Hiç", "Şok", "Far", "Mes", "Kim", "Çit", "Harf", "Nar", "Söz", "Cop", "Fiş", "Bas", "Kor", "Tay", "Şu", "Ek", "İz", "Kaç", "Lif", "Sonuç:"};
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






