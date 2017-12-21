package rmi_interface;

import model.tariff.TariffBonus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface RMITariffManager
 */
public interface RMITariffManager extends Remote{
    /**
     * The method search tariffs by cost of sms
     * @param tariffBonuses - list of TariffBonus objects
     * @param costSms - cost of sms
     * @return result List of TariffBonus objects
     * @throws RemoteException
     */
    public List<TariffBonus> SearchTariffForCostSms(List<TariffBonus> tariffBonuses, int costSms) throws RemoteException;

    /**
     * The method search tariffs by package of minutes
     * @param tariffBonuses - list of TariffBonus objects
     * @param packageMinute - package of minutes
     * @return result List of TariffBonus objects
     * @throws RemoteException
     */
    public List<TariffBonus> SearchTariffForPackageMinute(List<TariffBonus> tariffBonuses, int packageMinute) throws RemoteException;

    /**
     * The method sorts List of TariffBonus objects by cost of tariff
     * @param tariffBonuses - list of TariffBonus objects
     * @return result List of TariffBonus objects
     * @throws RemoteException
     */
    public List<TariffBonus> SortByCostTariff(List<TariffBonus> tariffBonuses) throws RemoteException;

    /**
     * The method sorts List of TariffBonus objects by species
     * @param tariffBonuses - list of TariffBonus objects
     * @return result List of TariffBonus objects
     * @throws RemoteException
     */
    public List<TariffBonus> SortBySpecies(List<TariffBonus> tariffBonuses) throws RemoteException;
}
