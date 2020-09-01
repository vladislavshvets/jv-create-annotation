package core.basesyntax.dao;

import core.basesyntax.model.Citizen;
import java.util.List;

public interface CitizenDao {

    void add(Citizen citizen);

    List<Citizen> getAll();
}
