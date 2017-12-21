package model.builder;

import model.tariff.Species;
import model.tariff.TariffBonus;

import java.io.Serializable;

/**
 * Class ManagerBuilder
 */
public class ManagerBuilder implements Serializable{
    /**
     * The method returns object of class tariffBonus by species
     * @param costTariff - cost of the tariff
     * @param costMinuteInNet - cost of minutes in the Ethernet
     * @param costSms - cost of the sms
     * @param costMegabyte - cost of megabyte
     * @param packageInternet - megabytes in package Internet
     * @param packageMinute - minutes in package Minute
     * @return tariffBonus object
     */
    public static TariffBonus getTariffBonus(int costTariff, int costMinuteInNet, int costSms, int costMegabyte,
                                             Species species, int packageInternet, int packageMinute) {
        TariffBonus tariffBonus = null;
        switch (species) {
            case ABSOLUTE:
                Absolute  builderAbsolute = new Absolute();
                tariffBonus = builderAbsolute.getTariffBonus(costTariff,costMinuteInNet,costSms,costMegabyte,packageInternet,packageMinute);
                break;
            case SMART:
                Smart builderSmart = new Smart();
                tariffBonus = builderSmart.getTariffBonus(costTariff,costMinuteInNet,costSms,costMegabyte,packageInternet,packageMinute);
                break;
            case MEGA:
                Mega builderMega = new Mega();
                tariffBonus = builderMega.getTariffBonus(costTariff,costMinuteInNet,costSms,costMegabyte,packageInternet,packageMinute);
                break;
            case SMARTMINI:
                SmartMini builderSmartMini = new SmartMini();
                tariffBonus = builderSmartMini.getTariffBonus(costTariff,costMinuteInNet,costSms,costMegabyte,packageInternet,packageMinute);
                break;
        }
        return tariffBonus;
    }
}