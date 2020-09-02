package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CitizenDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Citizen;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;

    @Inject
    private CitizenDao citizenDao;

    public void handleCitizen() {
        System.out.println("Please, add name and age! For example: James  65. ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Citizen citizen;
            String[] betData = command.split(" ");
            try {
                String name = (betData[0]);
                int age = Integer.parseInt(betData[1]);
                citizen = new Citizen(name, age);
                citizenDao.add(citizen);
            } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
                System.out.println("Please, add the correct name and age!");
                continue;
            }
            System.out.println(String.valueOf(citizen).toString());
        }
    }

    public void handleBet() {
        System.out.println("Please, add value and risk! For example 50 20");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet;
            String[] betData = command.split(" ");
            try {
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                betDao.add(bet);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please, add the correct value and risk!");
                continue;
            }
            System.out.println(bet.toString());
        }
    }
}
