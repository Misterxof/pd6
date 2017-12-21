package model.tariff;

import java.io.Serializable;

/**
 * Class TariffBonus
 */
public class TariffBonus  extends Tariff implements Serializable{
    private int packageMinute;
    private int packageInternet;

    /**
     * Constructor of class TariffBonus
     * @param costTariff - cost of the tariff
     * @param costMinuteInNet - cost of minutes in the Ethernet
     * @param costSms - cost of the sms
     * @param costMegabyte - cost of megabyte
     * @param species - species
     * @param packageInternet - megabytes in package Internet
     * @param packageMinute - minutes in package Minute
     */
    public TariffBonus(int costTariff, int costMinuteInNet, int costSms, int costMegabyte, Species species,
                       int packageInternet, int packageMinute) {
        super(costTariff, costMinuteInNet, costSms, costMegabyte, species);
        this.packageInternet = packageInternet;
        this.packageMinute = packageMinute;
    }

    /**
     * The method returns the value of the field packageMinute
     * @return the value of the field packageMinute
     */
    public int getPackageMinute() {
        return packageMinute;
    }

    /**
     * The method returns the value of the field packageInternet
     * @return the value of the field packageInternet
     */
    public int getPackageInternet() {
        return packageInternet;
    }

    /**
     * The method changes the value of the field packageInternet
     * @param packageInternet - megabytes in package Internet
     */
    public void setPackageInternet(int packageInternet) {
        this.packageInternet = packageInternet;
    }

    /**
     * The method changes the value of the field packageMinute
     * @param packageMinute - minutes in package Minute
     */
    public void setPackageMinute(int packageMinute) {
        this.packageMinute = packageMinute;
    }

    /**
     * Overriding the method toString()
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Tariff:[Bonus(Package minute = " + packageMinute + ", PackageInternet = " + packageInternet
                + ") " + super.toString() + "]");
        return stringBuilder.toString();
    }
}