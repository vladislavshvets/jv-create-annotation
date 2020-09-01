package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CitizenDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Citizen;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;
    @Inject
    CitizenDao citizenDao;

    public void handleCitizen() {
        System.out.println("Please, add name and age! ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Citizen citizen = null;
            try {
                String[] betData = command.split(" ");
                String name = (betData[0]);
                int age = Integer.parseInt(betData[1]);
                citizen = new Citizen(name, age);

            } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
                System.out.println("Please, add to correct name and age!");
            }
            citizenDao.add(citizen);
            System.out.println(citizenDao == null ? null : (String.valueOf(citizen)).toString());
        }
    }

    public void handleBet() {
        System.out.println("Please, add value and risk! ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please, add to correct value and risk!");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
