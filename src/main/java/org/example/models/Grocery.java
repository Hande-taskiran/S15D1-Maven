package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();
    public void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Seçiniz=> 0:Uygulamayı Durdur, 1:Eleman Ekle, 2:Eleman Çıkar");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("Uygulama durduruldu.");
                    break;
                case 1:
                    System.out.println("Eklemek istediğiniz elemanları giriniz (tek veya virgülle ayırarak birden fazla eleman girebilirsiniz)");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.println("Çıkarmak istediğiniz elemanları giriniz (tek veya virgülle ayırarak birden fazla eleman girebilirsiniz)");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Geçersiz seçim. 0, 1 ya da 2 seçebilirsiniz.");
            }
            printSorted();
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item.trim());
            } else {
                System.out.println(item + " zaten listede bulunuyor.");
            }
        }
        Collections.sort(groceryList);
    }
    public static void removeItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item.trim());
            } else {
                System.out.println(item + " listede bulunmuyor.");
            }
        }
        Collections.sort(groceryList);
    }
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }
    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Güncel liste (sıralı): " + groceryList);
    }

}

