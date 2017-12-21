package server.sort;

import model.tariff.Tariff;
import model.tariff.TariffBonus;

import java.util.Comparator;

/**
 * Class SortBySpecies
 */
public class SortBySpecies implements Comparator<Tariff> {

    /**
     * Overriding the method compare
     * @param o1 - first Tariff
     * @param o2 - second Tariff
     * @return int
     */
    @Override
    public int compare(Tariff o1, Tariff o2) {
        TariffBonus tariffBonus1 = null;
        TariffBonus tariffBonus2 = null;
        if (o2 instanceof TariffBonus) {
            tariffBonus2 = (TariffBonus) o2;
        }
        if (o1 instanceof TariffBonus) {
            tariffBonus1 = (TariffBonus) o1;
        }
        return tariffBonus1.getSpecies().compareTo(tariffBonus2.getSpecies());
    }

}
