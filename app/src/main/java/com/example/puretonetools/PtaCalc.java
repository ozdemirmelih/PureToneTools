package com.example.puretonetools;

public class PtaCalc {

    String kDerece;
    String kturu;
    String kulak;
    String finalText;

    public String Ptacal(int a, int b, int c, int d, int j, int f, int g, int k, boolean isLeft) {

        int safSes = (a + b + c + d) / 4;
        int kSafses = (j + f + g + k) / 4;
        int gap = safSes - kSafses;

        // Calculating degree and type of hearing loss

        if (isLeft) {
            kulak = "Sağ kulakta";
        } else {
            kulak = "Sol Kulakta";
        }

        if (safSes <= 25) {
            kDerece = "İşitme eşikleri normal olarak";
        } else {
            if (safSes >= 26 && safSes <= 40) {

                kDerece = "Hafif derece";

            } else {
                if (safSes >= 41 && safSes <= 55) {

                    kDerece = "Orta derece";

                } else {
                    if (safSes >= 56 && safSes < 70) {

                        kDerece = "Orta ileri derece";

                    } else {
                        if (safSes >= 71 && safSes < 90) {

                            kDerece = "İleri derece";

                        } else {
                            if (safSes >= 90) {

                                kDerece = "Çok ileri derece";

                            }
                        }
                    }
                }

                if (gap <= 10 && kSafses >= 25) {


                    kturu = "Sensori nöral tip kayıp ";
                } else {
                    if (gap >= 10 && kSafses >= 25) {

                        kturu = "Miks Tip kayıp";
                    } else {
                        if (gap >= 10 && kSafses <= 25) {

                            kturu = "İletim tip kayıp";
                        }
                    }
                }

            }

        }
        // Check the correction Max output and greater bone condiction ( Air cond must greater than bc, it's a audiologic rule ) average
        if (a > 120 || b > 120 || c > 120 || j > 120 || g > 120 || f > 120 || d > 120 || k > 120) {
            finalText = "Değerlerden biri son çıkıştan fazla";
        } else {
            if (gap < 0) {
                finalText = "Kemik yolları daha kötü.";
            } else {
                finalText = kulak + "Hava yolu ortalaması: " + safSes + "dB" + System.lineSeparator() + "Kemik yolu ortalaması: " + kSafses + "dB" + System.lineSeparator() + kDerece + System.lineSeparator() + kturu + System.lineSeparator() + "gözlenmiştir";


            }

        }
        return finalText;
    }
}
