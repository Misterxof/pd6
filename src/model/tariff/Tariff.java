package model.tariff;

import java.io.Serializable;

/**
 * Class Tariff
 */
public class Tariff implements Serializable{

    private int costTariff;
    private int costMinuteInNet;
    private int costSms;
    private int costMegabyte;
    private Species species;

    /**
     * Constructor of class Tariff
     * @param costTariff - cost of the tariff
     * @param costMinuteInNet - cost of minutes in the Ethernet
     * @param costSms - cost of the sms
     * @param costMegabyte - cost of megabyte
     * @param species - species
     */
    public Tariff(int costTariff, int costMinuteInNet,int costSms, int costMegabyte, Species species) {
        this.costTariff = costTariff;
        this.costMinuteInNet=costMinuteInNet;
        this.costSms=costSms;
        this.costMegabyte=costMegabyte;

        this.species = species;
    }

    /**
     * The method returns the value of the field species
     * @return the value of the field species
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * The method changes the value of the field species
     * @param species - species
     */
    public void setSpecies(Species species) {
        this.species = species;
    }

    /**
     * The method returns the value of the field costTariff
     * @return the value of the field costTariff
     */
    public int getCostTariff() {
        return costTariff;
    }

    /**
     * The method changes the value of the field costTariff
     * @param costTariff - cost of the tariff
     */
    public void setCostTariff(int costTariff) {
        this.costTariff = costTariff;
    }

    /**
     * The method returns the value of the field costMinuteInNet
     * @return the value of the field costMinuteInNet
     */
    public int getCostMinuteInNet(){
        return costMinuteInNet;
    }

    /**
     * The method changes the value of the field costMinuteInNet
     * @param costMinuteInNet - cost of minutes in the Ethernet
     */
    public void setCostMinuteInNet(int costMinuteInNet) {
        this.costMinuteInNet=costMinuteInNet;
    }

    /**
     * The method returns the value of the field costSms
     * @return the value of the field costSms
     */
    public int getCostSms(){
        return costSms;
    }

    /**
     * The method changes the value of the field costSms
     * @param costSms - cost of the sms
     */
    public void setCostSms(int costSms) {
        this.costSms=costSms;
    }

    /**
     * The method returns the value of the field costMegabyte
     * @return the value of the field costMegabyte
     */
    public int getCostMegabyte(){
        return costMegabyte;
    }

    /**
     * The method changes the value of the field costMegabyte
     * @param costMegabyte - cost of megabyte
     */
    public void setCostMegabyte(int costMegabyte) {
        this.costMegabyte=costMegabyte;
    }

    /**
     * Overriding the method toString()
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cost of the tariff = "+ costTariff +", Cost minute in net = " + costMinuteInNet + ", Cost megabyte = " + costMegabyte+ ", Cost sms = " + costSms + ", tariff species - " + species);
        return stringBuilder.toString();
    }
}