package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Citizen;
import java.util.List;

@Dao
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
