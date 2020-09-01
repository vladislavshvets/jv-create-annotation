package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CitizenDao;
import core.basesyntax.dao.CitizenDaoImpl;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<CitizenDaoImpl> citizenDaoClass = CitizenDaoImpl.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(CitizenDao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.citizenDao());
            }
        }
        return instance;
    }
}
