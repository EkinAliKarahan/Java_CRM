# Java_CRM

CRM (Customer Relationship Management) Nedir?

CRM (Müşteri İlişkileri Yönetimi), şirketlerin müşterileriyle olan etkileşimlerini yönetmek, satışları artırmak, müşteri hizmetlerini iyileştirmek ve genel olarak müşteri memnuniyetini artırmak için kullanılan bir strateji, yazılım ve sistemler bütünüdür.

 CRM'in Temel Amaçları:

 *Müşteri Verilerini Yönetmek: Müşteri bilgilerini saklamak ve analiz etmek
 *Satışları Artırmak: Potansiyel müşterileri takip etmek ve dönüşüm oranlarını iyileştirmek
 *Müşteri Destek Hizmetlerini İyileştirmek: Müşteri taleplerine hızlı ve etkili yanıt vermek
 *Pazarlama Kampanyalarını Optimize Etmek: Doğru hedef kitleye doğru kampanyaları sunmak
 *Sadık Müşteri Kitlesi Oluşturmak: Kişiselleştirilmiş hizmetler sunarak müşteri bağlılığını artırmak



 Kodun kullanımı:
    public static void main içindeki
     int[] musteriTalepleri = {20, 25, 30};
        int[] temsilciUygunluk = {5, 30, 40};
        musteriDestekYonlendirme(musteriTalepleri, temsilciUygunluk);

        
        int[] kampanyaMaliyetleri = {5, 15, 90};
        int[] beklenenGetiriler = {45, 65, 108};
        int bütçe = 70;
        int değerleri değiştirilerek yeni hesaplamalar yaratılabilir




Kodun açıklanışı:
1. musteriDestekYonlendirme Fonksiyonu

Bu fonksiyon, müşteri destek taleplerini en uygun temsilciye yönlendirmeye çalışıyor. Dinamik programlama kullanarak mümkün olan en fazla sayıda müşteri talebini karşılamayı hedefliyor.

    Girdi Parametreleri:
        musteriTalepleri: Müşterilerin destek taleplerinin zorluk seviyeleri (örn. 5, 10, 15).
        temsilciUygunluk: Destek temsilcilerinin bu talepleri karşılayabilme kapasitesi (örn. 10, 20, 30).

n ve m dinamik tablonun boyutunu belirler
    
İşleyiş Mantığı:
        dp[i][j] tablosu, i müşteri talebi ve j temsilciye kadar olan durumu saklar.
        Eğer bir müşteri talebi, bir temsilcinin kapasitesine uygunsa:
            dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j])
            Yani ya bu müşteri atanır (+1 eklenir) ya da atanmadan devam edilir.
        Değilse, müşteri atanmadan devam edilir: dp[i][j] = dp[i][j - 1].

    Sonuç: En fazla kaç müşteri talebinin uygun şekilde yönlendirildiğini ekrana yazdırır.





2. pazarlamaKampanyasiSecimi Fonksiyonu

Bu fonksiyon, Sırt Çantası (Knapsack) Problemi mantığında çalışarak belirli bir bütçeyle en yüksek getiriyi sağlayan kampanyaları seçmeye çalışır.

    Girdi Parametreleri:
        kampanyaMaliyetleri: Kampanyaların maliyetleri (örn. 10, 20, 30).
        beklenenGetiriler: Kampanyalardan beklenen kazançlar (örn. 60, 100, 120).
        bütçe: Kullanılabilir bütçe (örn. 50).

    İşleyiş Mantığı:
        dp[i][j] tablosu, i kampanya ve j bütçeye kadar olan maksimum getiriyi saklar.
        Eğer bir kampanyanın maliyeti bütçeye sığıyorsa:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - kampanyaMaliyetleri[i - 1]] + beklenenGetiriler[i - 1])
            Yani ya kampanya seçilmez (dp[i - 1][j]), ya da seçilir ve beklenen getiri eklenir.
        Kampanyanın maliyeti bütçeyi aşarsa:
            dp[i][j] = dp[i - 1][j], yani kampanya dahil edilmez.

    Sonuç: Maksimum yatırım getirisi ekrana yazdırılır.


   
