package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CitizenDao;
import core.basesyntax.dao.CitizenDaoImpl;
import core.basesyntax.exceptions.IncorrectAnnotation;
import core.basesyntax.lib.Dao;

public class Factory {
    private static BetDao betDao;
    private static CitizenDao citizenDao;

    public static BetDao getBetDao() {
        if (betDao == null && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
            betDao = new BetDaoImpl();
        } else {
            throw new IncorrectAnnotation("Incorrect annotation for BetDaoImpl!");
        }
        return betDao;
    }

    public static CitizenDao citizenDao() {
        if (citizenDao == null && CitizenDaoImpl.class.isAnnotationPresent(Dao.class)) {
            citizenDao = new CitizenDaoImpl();
        } else {
            throw new IncorrectAnnotation("Incorrect annotation for CitizenDaoImpl!");
        }
        return citizenDao;
    }
}
