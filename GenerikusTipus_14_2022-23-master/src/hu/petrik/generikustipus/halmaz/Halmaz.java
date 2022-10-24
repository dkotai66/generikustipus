package hu.petrik.generikustipus.halmaz;

import java.util.ArrayList;
import java.util.List;

public class Halmaz<T> {
    private List<T> elemek;

    public Halmaz() {
        this.elemek = new ArrayList<>();
    }

    public boolean add(T elem) {
        boolean hozzaadva = false;
        if (!this.elemek.contains(elem)) {
            hozzaadva = true;
            this.elemek.add(elem);
        }
        return hozzaadva;
    }

    public boolean remove(T elem) {
        boolean eltavolitva = false;
        if (this.elemek.contains(elem)) {
            this.elemek.remove(elem);
            eltavolitva = true;
        }
        return eltavolitva;
    }

    public int getSize() {
        return this.elemek.size();
    }

    public void clear() {
        this.elemek.clear();
    }

    public boolean isElement(T elem) {
        return this.elemek.contains(elem);
    }

    public boolean isEmpty() {
        return this.elemek.isEmpty();
    }

    public boolean isEquals(Halmaz<T> masikHalmaz) {
        boolean megegyezik = true;
        if (this.getSize() == masikHalmaz.getSize()) {
            int i = 0;
            while (i < this.getSize() && megegyezik) {
                if (masikHalmaz.elemek.contains(this.elemek.get(i))) {
                    i++;
                } else {
                    megegyezik = false;
                }
            }
        } else {
            megegyezik = false;
        }
        return megegyezik;
    }

    public boolean isPartOf(Halmaz<T> masikHalmaz) {
        boolean reszhalmaza = true;
        if (this.getSize() <= masikHalmaz.getSize()) {
            int i = 0;
            while (i < this.getSize() && reszhalmaza) {
                if (masikHalmaz.elemek.contains(this.elemek.get(i))) {
                    i++;
                } else {
                    reszhalmaza = false;
                }
            }
        } else {
            reszhalmaza = false;
        }
        return reszhalmaza;
    }

    public Halmaz<T> unio(Halmaz<T> masikHalmaz) {
        Halmaz<T> unio = new Halmaz<>();
        for (T elem : this.elemek) {
            unio.add(elem);
        }
        for (T elem : masikHalmaz.elemek) {
            unio.add(elem);
        }
        return unio;
    }

    public Halmaz<T> intersection(Halmaz<T> masikHalmaz) {
        Halmaz<T> intersection = new Halmaz<>();
        for (T elem : this.elemek) {
            if (masikHalmaz.isElement(elem)) {
                intersection.add(elem);
            }
        }
        return intersection;
    }

    public Halmaz<T> different(Halmaz<T> masikhalmaz) {
        Halmaz<T> different = new Halmaz<>();

//        for (T elem : this.elemek) {
//            if (!masikhalmaz.isElement(elem)) {
//                different.add(elem);
//            }
//        }

        Halmaz<T> intersection = this.intersection(masikhalmaz);

        for (T elem: this.elemek){
            different.add(elem);
        }

        for (T elem: intersection.elemek) {
            different.remove(elem);
        }

        return different;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.elemek.get(0).toString());
        for (int i = 1; i < this.getSize(); i++) {
            sb.append(", ").append(this.elemek.get(i));
        }
        return sb.toString();
    }
}
