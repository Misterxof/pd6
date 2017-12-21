package client;

import model.builder.ManagerBuilder;
import model.tariff.Species;
import model.tariff.TariffBonus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rmi_interface.RMITariffManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class Client
 */
public class Client {
    private static RMITariffManager tariffManager;
    private static Logger LOGGER = LogManager.getLogger(Client.class);
    /**
     * The method start client
     * @param args
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        tariffManager = (RMITariffManager) Naming.lookup("//localhost:5000/TariffManager");

        LOGGER.debug("Initialize tariff bonuses and add them to list.");

        TariffBonus smart = ManagerBuilder.getTariffBonus(100,100,10,10, Species.SMART,1024,30);
        TariffBonus mega = ManagerBuilder.getTariffBonus(24,23,14,10,Species.MEGA,2048,360);
        TariffBonus smartMini = ManagerBuilder.getTariffBonus(30,23,16,15,Species.SMARTMINI,1024,100);
        TariffBonus absolute = ManagerBuilder.getTariffBonus(20,45,20,15,Species.ABSOLUTE,1024,100);
        TariffBonus absoluteLite = ManagerBuilder.getTariffBonus(10,65,6,15,Species.ABSOLUTE,1024,50);
        TariffBonus absoluteMax = ManagerBuilder.getTariffBonus(50,60,252,30,Species.ABSOLUTE,2048,200);
        TariffBonus smartPlus = ManagerBuilder.getTariffBonus(150,200,20,20, Species.SMART,512,100);

        List<TariffBonus> tariffBonuses = new LinkedList<>();
        tariffBonuses.add(smart);
        tariffBonuses.add(mega);
        tariffBonuses.add(smartMini);
        tariffBonuses.add(absolute);
        tariffBonuses.add(absoluteLite);
        tariffBonuses.add(absoluteMax);
        tariffBonuses.add(smartPlus);

        System.out.println("Tariffs: ");
        for(TariffBonus tariffBonus: tariffBonuses){
            System.out.println(tariffBonus);
        }

        LOGGER.debug("Searching result by cost sms.");
        System.out.println("\nSearch result by cost sms: ");
        printResult(tariffManager.SearchTariffForCostSms(tariffBonuses, 20));

        LOGGER.debug("Searching result by package minutes.");
        System.out.println("\nSearch result by package minutes: ");
        printResult(tariffManager.SearchTariffForPackageMinute(tariffBonuses, 100));

        LOGGER.debug("Sorting by cost of tariff.");
        System.out.println("\nResult of sorting by cost of tariff: ");
        printResult(tariffManager.SortByCostTariff(tariffBonuses));
    }

    public static void printResult(List<TariffBonus> result){
        for(TariffBonus tariffBonus:result){
            System.out.println(tariffBonus);
        }
    }
}
