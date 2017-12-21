package model.builder;

import model.tariff.TariffBonus;

/**
 * Interface Builder
 */
public interface Builder{

    /**
     * The method returns object of class tariffBonus
     * @param costTariff - cost of the tariff
     * @param costMinuteInNet - cost of minutes in the Ethernet
     * @param costSms - cost of the sms
     * @param costMegabyte - cost of megabyte
     * @param packageInternet - megabytes in package Internet
     * @param packageMinute - minutes in package Minute
     * @return tariffBonus object
     */
    public TariffBonus getTariffBonus(int costTariff, int costMinuteInNet, int costSms, int costMegabyte, int packageInternet, int packageMinute);
}