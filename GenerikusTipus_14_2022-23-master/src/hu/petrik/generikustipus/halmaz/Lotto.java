package hu.petrik.generikustipus.halmaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lotto {
    private Halmaz<Integer> lottoSzamok;


    public Lotto(String fajlnev) throws FileNotFoundException{
        this.lottoSzamok=beolvas(fajlnev);
    }

    private static Halmaz<Integer> beolvas(String fajlnev) throws FileNotFoundException{
        Halmaz<Integer> szamok=new Halmaz<>();
        Scanner file=new Scanner(new File(fajlnev));
        while(file.hasNext()){
            String[] adatok=file.nextLine().split(" ");
            szamok.add(Integer.parseInt(adatok[0]));
            szamok.add(Integer.parseInt(adatok[1]));
            szamok.add(Integer.parseInt(adatok[2]));
            szamok.add(Integer.parseInt(adatok[3]));
            szamok.add(Integer.parseInt(adatok[4]));
        }
        file.close();
        return szamok;
    }


    public boolean LottoSzamok() {
        boolean trueorfalse=false;
        for (int i = 1; i < 91; i++) {
            if (lottoSzamok.isElement(i)){
                trueorfalse=true;
            }
        }
        return trueorfalse;
    }
}
