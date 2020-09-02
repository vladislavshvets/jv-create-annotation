package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CitizenDao;
import core.basesyntax.exception.NotFoundDaoAnnotation;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Class<? extends BetDao> betDaoImplClass = Factory.getBetDao().getClass();
        Class<? extends CitizenDao> citizenDaoClass = Factory.getCitizenDao().getClass();
        if (!betDaoImplClass.isAnnotationPresent(Dao.class)
                || !citizenDaoClass.isAnnotationPresent(Dao.class)) {
            throw new NotFoundDaoAnnotation("Incorrect annotation!");
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(CitizenDao.class)) {
                    field.set(instance, Factory.getCitizenDao());
                }
            }
        }
        return instance;
    }
}
