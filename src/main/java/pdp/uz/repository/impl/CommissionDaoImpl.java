package pdp.uz.repository.impl;

import org.springframework.stereotype.Repository;
import pdp.uz.domain.Commission;
import pdp.uz.repository.CommissionDao;
import pdp.uz.repository.GenericRepository;

@Repository
public class CommissionDaoImpl extends GenericRepository implements CommissionDao {

    @Override
    public Commission findByOperationCode(String operationCode) {
        return (Commission) getSession().createQuery("from Commission t where t.operationCode = '" + operationCode + "'").getSingleResult();
    }
}
