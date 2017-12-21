package server.sort;

import model.tariff.Tariff;

import java.util.Comparator;

/**
 * Class SortByCostTariff
 */
public class SortByCostTariff implements Comparator<Tariff> {
    /**
     * Overriding the method compare()
     * @param o1 - first object of type Tariff
     * @param o2 - second object of type Tariff
     * @return
     */
    @Override
    public int compare(Tariff o1, Tariff o2) {
        int a=o1.getCostTariff();
        int b=o2.getCostTariff();

        if(a>b)
            return 1;
        else if(a<b)
            return -1;
        return 0;
    }
}
