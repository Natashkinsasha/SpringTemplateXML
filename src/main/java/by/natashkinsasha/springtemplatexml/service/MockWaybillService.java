package by.natashkinsasha.springtemplatexml.service;

import by.natashkinsasha.springtemplatexml.entity.User;
import by.natashkinsasha.springtemplatexml.entity.Waybill;
import by.natashkinsasha.springtemplatexml.entity.WaybillStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MockWaybillService implements WaybillService {
    private Map<Long, Waybill> waybills;
    private Long userID =0L;
    private Long waybillID =0L;

    @PostConstruct
    public void init(){
        waybills = new HashMap<>();
        User firstUser = new User();
        firstUser.setId(++userID);
        firstUser.setUsername("Ivan Ivanovich");
        User secondUser = new User();
        secondUser.setId(++userID);
        secondUser.setUsername("Peta Petrov");
        Waybill firstWaybill = new Waybill();
        firstWaybill.setId(++waybillID);
        firstWaybill.setStatus(WaybillStatus.CHECKING_COMPLETED);
        firstWaybill.setCheckedBy(firstUser);
        firstWaybill.setResponsiblePerson(secondUser);
        waybills.put(firstWaybill.getId(), firstWaybill);
    }


    @Override
    public List<Waybill> getAll() {
        return new ArrayList<Waybill>(waybills.values());
    }

    @Override
    public Waybill getByID(long id) {
        return waybills.get(id);
    }

    @Override
    public Waybill save(Waybill waybill) {
        waybills.put(++waybillID,waybill);
        return waybill;
    }

    @Override
    public void remove(long id) {
        waybills.remove(id);
    }
}
