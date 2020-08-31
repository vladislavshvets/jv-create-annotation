package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Citizen;
import java.util.List;

public class CitizenDaoImpl implements CitizenDao {

    @Override
    public void add(Citizen citizen) {
        Storage.citizens.add(citizen);
    }

    @Override
    public List<Citizen> getAll() {
        return Storage.citizens;
    }
}
