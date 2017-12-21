package server;

import model.tariff.TariffBonus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rmi_interface.RMITariffManager;
import server.sort.SortByCostTariff;
import server.sort.SortBySpecies;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class TariffManager
 */
public class TariffManager extends UnicastRemoteObject implements RMITariffManager {

    private static Logger LOGGER = LogManager.getLogger(TariffManager.class);

    /**
     * Constructor for TariffManager class
     * @throws RemoteException
     */
    public TariffManager() throws RemoteException {
        super();
    }

    /**
     * Overriding method SearchTariffForCostSms
     * @param tariffBonuses - list of TariffBonus objects
     * @param costSms - cost of sms
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SearchTariffForCostSms(List<TariffBonus> tariffBonuses, int costSms) throws RemoteException {

        TariffBonus tariffBonus;
        List<TariffBonus> result = new LinkedList<>();

        for (int i = 0; i < tariffBonuses.size(); i++) {
            if (tariffBonuses.get(i) instanceof TariffBonus) {
                tariffBonus = tariffBonuses.get(i);
                if (tariffBonus.getCostSms() == costSms) {
                    result.add(tariffBonus);
                }
            }
        }
        return result;
    }

    /**
     * Overriding method SearchTariffForPackageMinute
     * @param tariffBonuses - list of TariffBonus objects
     * @param packageMinute - package of minutes
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SearchTariffForPackageMinute(List<TariffBonus> tariffBonuses, int packageMinute) throws RemoteException {

        TariffBonus tariffBonus;
        List<TariffBonus> result = new LinkedList<>();

        for (int i = 0; i < tariffBonuses.size(); i++) {
            if (tariffBonuses.get(i) instanceof TariffBonus) {
                tariffBonus = tariffBonuses.get(i);
                if (tariffBonus.getPackageMinute() == packageMinute) {
                    result.add(tariffBonus);
                }
            }
        }
        return result;
    }

    /**
     * Overriding method SortByCostTariff
     * @param tariffBonuses - list of TariffBonus objects
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SortByCostTariff(List<TariffBonus> tariffBonuses) throws RemoteException {
        Collections.sort(tariffBonuses, new SortByCostTariff());
        return tariffBonuses;
    }

    /**
     * Overriding method SortBySpecies
     * @param tariffBonuses - list of TariffBonus objects
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SortBySpecies(List<TariffBonus> tariffBonuses) throws RemoteException {
        Collections.sort(tariffBonuses, new SortBySpecies());
        return tariffBonuses;
    }

    /**
     * The method start server
     * @param args
     */
    public static void main(String[] args){
        try {
            LOGGER.debug("Initialize TariffManager.");
            TariffManager tariffManager = new TariffManager();

            LOGGER.debug("Create and export registry on the local host that accepts requests on the port 5000.");

            LocateRegistry.createRegistry(5000);

            LOGGER.debug("Rebind the specified name to a new remote object tariffManager.");

            Naming.rebind("//localhost:5000/TariffManager", tariffManager);
            System.err.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
