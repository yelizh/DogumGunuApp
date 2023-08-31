package com.yeliz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DogumGunu {
	
	Scanner sc = new Scanner(System.in);
	LocalDate bugununTarihi = LocalDate.now();
	LocalDate dogumGunuTarihiSayi;
	
	
    public void uygulama() {
    	boolean gecerliTarihGirildi = false;
    	while (!gecerliTarihGirildi) {
                gecerliTarihGirildi = tarihGir();
        }
    	
    	int secim;
    	do {
          	menu();
          	secim=secimYap();
          	
          	switch (secim) {
			case 1: kacYilGecti();
				break;
			case 2: kacAyGecti();
				break;
			case 3:kacHaftaGecti();
				break;
			case 4: kacGunGecti();
				break;
			case 5:sonrakiDogumGunumekacGunKaldi();
				break;
			case 0: 
				System.err.println("ÇIKIŞ YAPILDI");
				break;				
			default:
				System.err.println("Geçerli bir seçim numarası giriniz.");;
			}
    	}while(secim!=0);
    	
    	sc.close();
    }    
    
    private boolean tarihGir() {

    	System.out.println("\nDoğum gününüzü yyyy-aa-gg formatında giriniz : ");
    	String dogumGunuTarihi = sc.nextLine(); 	
    	try {
    		dogumGunuTarihiSayi = LocalDate.parse(dogumGunuTarihi);
    	}catch (Exception e){
    		System.err.println("Hata: Geçersiz tarih formatı! Lütfen yyyy-aa-gg formatında girin.");
            return false;
    	}
		return true;
		
	}

	private void sonrakiDogumGunumekacGunKaldi() {

		LocalDate birSonrakiDogumGunu = dogumGunuTarihiSayi.withYear(bugununTarihi.getYear());
		if (birSonrakiDogumGunu.isBefore(bugununTarihi) || birSonrakiDogumGunu.isEqual(bugununTarihi)) {
            birSonrakiDogumGunu = birSonrakiDogumGunu.plusYears(1);
        }
		long sonrakiDogumGunumekacGunKaldi = ChronoUnit.DAYS.between(bugununTarihi, birSonrakiDogumGunu);
        System.out.println("Bir sonraki doğum gününüze kalan gün sayısı: " + sonrakiDogumGunumekacGunKaldi + " gün.");		
	}

	private void kacGunGecti() {
    	long kacGunGecti = dogumGunuTarihiSayi.until(bugununTarihi, ChronoUnit.DAYS);
        System.out.println("  " + kacGunGecti + " gündür hayattasınız. Tebrikler :) ");
		
	}

	private void kacHaftaGecti() {
    	long kacHaftaGecti = dogumGunuTarihiSayi.until(bugununTarihi, ChronoUnit.WEEKS);
        System.out.println(kacHaftaGecti + "  haftadır hayattasınız. Tebrikler :) ");  
		
	}

	private void kacAyGecti() {
    	long kacAyGecti = dogumGunuTarihiSayi.until(bugununTarihi, ChronoUnit.MONTHS);
    	System.out.println("  " + kacAyGecti +  "   aydır hayattasınız. Tebrikler :) ");
		
	}

	private void kacYilGecti() {
    	long kacYılGecti = dogumGunuTarihiSayi.until(bugununTarihi, ChronoUnit.YEARS);
     	System.out.println("  "+kacYılGecti + "  yıldır hayattasınız. Tebrikler :) ");
    	
    }
       
	private void menu() {
		System.out.println("\n..............Hoşgeldiniz................");
		System.out.println("Lütfen yapmak İstediğiniz İşlemi Seciniz;");
		System.out.println(".........................................\n");
		System.out.println("Doğdugunuz günden bugüne kadar ;");
		System.out.println("1-Kaç yıl geçti? ");
		System.out.println("2-Kaç ay geçti? ");
		System.out.println("3-Kaç hafta geçti? ");
		System.out.println("4-Kaç gün geçti? ");
		System.out.println("5-Bir sonraki doğumgünüze kaç gün kaldı?");
		System.out.println("0-ÇIKIŞ.");
	
	}
	private int secimYap() {
		System.out.println("\nSeciminiz : ");
		int secim=sc.nextInt();
		sc.nextLine();
		System.out.println();
		return secim;
		
	}	
		
}
