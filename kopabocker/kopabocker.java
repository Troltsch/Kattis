package Kattis.kopabocker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class kopabocker {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException 
    {
        int libros = sc.nextInt();
        int tiendas = sc.nextInt();

        ArrayList<Tienda> tiendaList = new ArrayList<Tienda>();

        for(int i=0;i<tiendas;++i)
        {
            int cuantos = sc.nextInt();
            int fee = sc.nextInt();

            Tienda tienda = new Tienda();
            tienda.fee = fee;

            for(int j=0;j<cuantos;++j)
            {
                Libro libro = new Libro();
                libro.number = sc.nextInt();
                libro.price = sc.nextInt();
                tienda.libros.put(libro.number, libro);
            }
            tiendaList.add(tienda);
        }

        int total = 0;
        for(int i=0;i<libros;++i)
        {
            int getBook = i+1;
            Tienda cheapestTienda = null;
            int cheapestYet = 0;
            for(Tienda tienda : tiendaList)
            {
                if(!tienda.hasLibro(getBook)) continue;
                int currentPrice = tienda.getPriceWithFee(getBook);

                if(cheapestTienda == null)
                {
                    cheapestTienda = tienda;
                    cheapestYet = currentPrice;
                    continue;
                }
                else if(currentPrice < cheapestYet)
                {
                    cheapestYet = currentPrice;
                    cheapestTienda = tienda;
                }
            }
            cheapestTienda.noBooksYet = false;
            total += cheapestYet;
        }
        System.out.println(total);
    }

    public static class Tienda
    {
        public boolean hasLibro(int number)
        {
            Libro libro = libros.get(number);
            return libro != null;
        }

        public int getPriceWithFee(int number)
        {
            int sum = 0;
            Libro libro = libros.get(number);
            sum += libro.price;
            if(noBooksYet) sum += fee;
            return sum;
        }


        public int fee;
        public HashMap<Integer,Libro> libros = new HashMap<Integer,Libro>();

        public boolean noBooksYet = true;
    }

    public static class Libro
    {
        public int number;
        public int price;
    }
}

/*
7 4
4 9
1 28
6 45
3 49
4 108
7 49
1 26
2 179
3 54
4 99
5 129
6 45
7 244
5 20
7 249
2 184
5 133
4 109
6 42
1 0
6 43
*/