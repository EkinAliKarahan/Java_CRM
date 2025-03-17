package org.example;

import java.util.*;

class CRM_Sistemi {

    // Müşteri destek temsilcilerini yönlendirme fonksiyonu
    public static void musteriDestekYonlendirme(int[] musteriTalepleri, int[] temsilciUygunluk) {
        int n = musteriTalepleri.length;
        int m = temsilciUygunluk.length;
        int[][] dp = new int[n + 1][m + 1];

        // Dinamik programlama tablosunu doldurma
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (musteriTalepleri[i - 1] <= temsilciUygunluk[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println("En uygun yönlendirme sayısı: " + dp[n][m]);
    }

    // Pazarlama kampanyası seçimi fonksiyonu
    public static void pazarlamaKampanyasiSecimi(int[] kampanyaMaliyetleri, int[] beklenenGetiriler, int bütçe) {
        int n = kampanyaMaliyetleri.length;
        int[][] dp = new int[n + 1][bütçe + 1];

        // Dinamik programlama tablosunu doldurma
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= bütçe; j++) {
                if (kampanyaMaliyetleri[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - kampanyaMaliyetleri[i - 1]] + beklenenGetiriler[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Maksimum yatırım getirisi: " + dp[n][bütçe]);
    }

    public static void main(String[] args) {
        // Müşteri destek temsilcisi yönlendirme örneği
        int[] musteriTalepleri = {20, 25, 30};
        int[] temsilciUygunluk = {5, 30, 40};
        musteriDestekYonlendirme(musteriTalepleri, temsilciUygunluk);

        // Pazarlama kampanyası seçimi örneği
        int[] kampanyaMaliyetleri = {5, 15, 90};
        int[] beklenenGetiriler = {45, 65, 108};
        int bütçe = 70;
        pazarlamaKampanyasiSecimi(kampanyaMaliyetleri, beklenenGetiriler, bütçe);
    }
}