package br.com.vinicius.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.vinicius.screenmatch.modelo.Filme;
import br.com.vinicius.screenmatch.modelo.Serie;
import br.com.vinicius.screenmatch.modelo.Titulo;

public class PrincipalLista {
   public static void main(String[] args) {
    
        ArrayList<Titulo> lista = new ArrayList<>();
        Filme crepusculo = new Filme("Crupusculo: lua Cheia", 2001);
        crepusculo.avalia(10);
        Filme diaDoSim = new Filme("Dia do sim", 2020);
        diaDoSim.avalia(2);
        Serie strangerThings = new Serie("Stranger things", 2016);
        strangerThings.avalia(7);
        Serie bokuNoHero = new Serie("Boku no hero", 2016);
        bokuNoHero.avalia(10);

        lista.add(bokuNoHero);
        lista.add(crepusculo);
        lista.add(diaDoSim);
        lista.add(strangerThings);

        for (Titulo titulo : lista) {
            System.out.println(titulo);
            System.out.println(titulo.getAvaliacao());
        }

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLansamento));
        System.out.println(lista);
   }
}
