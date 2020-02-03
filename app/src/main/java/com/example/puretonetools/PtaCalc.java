package com.example.puretonetools;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

public class PtaCalc extends Application {
    String kDerece;
    String kturu;
    String kulak;
    String finalText;
    protected static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    public PtaCalc() {
    }

    public static Context getAppContext() {
        return context;
    }

    public String Ptacal(int a, int b, int c, int d, int j, int f, int g, int k, boolean isLeft) {
        Context con = getAppContext();
        double freksayi = 4.0;
        double rawsafSes = (a + b + c + d) / freksayi;
        int safSes = (int) Math.round(rawsafSes);

        double rawkSafses = (j + f + g + k) / freksayi;

        int kSafses = (int) Math.round(rawkSafses);
        int gap = safSes - kSafses;

        // Calculating degree and type of hearing loss

        if (isLeft) {
            kulak = con.getResources().getString(R.string.sagkulak) + System.lineSeparator();
        } else {
            kulak = System.lineSeparator() + con.getResources().getString(R.string.solkulak) + System.lineSeparator();
        }

        if (safSes <= 25) {
            kDerece = con.getResources().getString(R.string.normal);
        } else {
            if (safSes >= 26 && safSes <= 40) {

                kDerece = con.getResources().getString(R.string.hafif);

            } else {
                if (safSes >= 41 && safSes <= 55) {

                    kDerece = con.getResources().getString(R.string.orta);

                } else {
                    if (safSes >= 56 && safSes < 70) {

                        kDerece = con.getResources().getString(R.string.ortaileri);

                    } else {
                        if (safSes >= 71 && safSes < 90) {

                            kDerece = con.getResources().getString(R.string.ileri);

                        } else {
                            if (safSes >= 90) {

                                kDerece = con.getResources().getString(R.string.cokileri);

                            }
                        }
                    }
                }

                if (gap <= 10 && kSafses >= 25) {


                    kturu = con.getResources().getString(R.string.sn);
                } else {
                    if (gap >= 10 && kSafses >= 25) {

                        kturu = con.getResources().getString(R.string.mix);
                    } else {
                        if (gap >= 10 && kSafses <= 25) {

                            kturu = con.getResources().getString(R.string.iletim);
                        } else {
                            kturu = " ";
                        }
                    }
                }

            }

        }
        // Check the correction Max output and greater bone condiction ( Air cond must greater than bc, it's a audiologic rule ) average
        if (a > 120 || b > 120 || c > 120 || j > 120 || g > 120 || f > 120 || d > 120 || k > 120) {
            finalText = con.getResources().getString(R.string.yuksek);
        } else {
            if (gap < 0) {
                finalText = con.getResources().getString(R.string.kemikotu);
            } else {
                finalText = kulak + con.getResources().getString(R.string.hava_ort) + safSes + "dB" + System.lineSeparator() + con.getResources().getString(R.string.kemik_ort) + kSafses + "dB" + System.lineSeparator() + kDerece + System.lineSeparator() + kturu + System.lineSeparator() + con.getResources().getString(R.string.gozlem);


            }

        }

        return finalText;
    }
}
