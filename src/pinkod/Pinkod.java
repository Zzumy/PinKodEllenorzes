package pinkod;

import java.util.Scanner;

public class Pinkod {
    
    public static Scanner sc;
    private int[] pinTarolo;
    private int pinKod;
    private int belepesiPin;
    
    public Pinkod() {
        Pinkod.sc = new Scanner(System.in);
        letrehozasEllenorzes();
        belepesiEllenorzes(pinKod);
    }
    
    private void letrehozasEllenorzes() {
        pinTarolo = new int[1];
        boolean megfelel;
        do {
            System.out.print("Kód megadása(4-6)hosszú: ");
            pinKod = sc.nextInt();
            if (pinKod < 1000 || pinKod > 999999) {
                System.out.println("Nem megfelelő formátum, minimum 4 maximum 6 számjegy hosszú legyen!");
            }
            megfelel = pinKod >= 1000 && pinKod <= 999999;
        } while (!megfelel);
        pinTarolo[0] = pinKod;
        System.out.println("Pin elmentve!");

        belepesiEllenorzes(pinKod);
    }
    
    private void belepesiEllenorzes(int pinKod) {
        int ix = 1;
        boolean eggyezik;
        do {
            System.out.print("Kérem a belépési kódot(" + ix + "/3): ");
            belepesiPin = sc.nextInt();
            ix++;
            if (pinKod != belepesiPin) {
                System.out.println("Hibás pin kód!");
            }
            eggyezik = pinKod == belepesiPin || ix >= 4;
        } while (!eggyezik);
        if (ix >= 4 && pinKod != belepesiPin) {
            System.out.println("Belépés megtagadva!");
        } else {
            System.out.println("Rendben, sikeres belépés!");
        }
    }
}
