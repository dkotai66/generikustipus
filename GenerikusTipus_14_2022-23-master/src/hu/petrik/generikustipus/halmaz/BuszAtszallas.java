package hu.petrik.generikustipus.halmaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuszAtszallas {
    private Halmaz<String> egyikJarat;
    private Halmaz<String> masikJarat;

    public BuszAtszallas(String egyikFajl, String masikFajl) throws FileNotFoundException {
        this.egyikJarat = beolvas(egyikFajl);
        this.masikJarat = beolvas(masikFajl);
    }

    private static Halmaz<String> beolvas(String fajlNev) throws FileNotFoundException {
        Halmaz<String> megallok = new Halmaz<>();
        Scanner file = new Scanner(new File(fajlNev));
        while (file.hasNext()){
            megallok.add(file.nextLine());
        }
        file.close();
        return megallok;
    }

    public Halmaz<String> kozosMegallok() {
        return egyikJarat.intersection(masikJarat);
    }
}
