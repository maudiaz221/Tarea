package Tarea;

import java.util.ArrayList;

public class Distancia {

    public static int edit(String s1, String s2, int cont){
        if(s1.length()==0 || s2.length()==0)
            return s1.length() + s2.length() - cont;
        if(s1.charAt(0)== s2.charAt(0))
            return edit(s1.substring(1), s2.substring(1), cont);
        int sus = edit(s1.substring(1), s2.substring(2), cont + 1); //sustituir
        int ins = edit(s1.substring(1), s2, cont+1);//insertar
        int bor = edit(s1, s2.substring(1), cont+1);//borrar
        return minimo(sus, ins, bor);
    }

    public static int minimo(int sus, int ins, int bor){//3,4,2
        ArrayList<Integer> arre = new ArrayList();
        arre.add(sus);
        arre.add(ins);
        arre.add(bor);

        int min = arre.get(0);
        for(int i = 1; i < arre.size(); i++){
            if(arre.get(i) <= min){
                min = arre.get(i);
            }
        }

        return min;


    }
}
