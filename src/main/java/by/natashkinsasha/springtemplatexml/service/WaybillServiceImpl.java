package by.natashkinsasha.springtemplatexml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.natashkinsasha.springtemplatexml.entity.Waybill;
import by.natashkinsasha.springtemplatexml.repository.WaybillRepository;

import java.util.List;

@Service
public class WaybillServiceImpl implements WaybillService {
    @Autowired
    private WaybillRepository repository;

    @Override
    public List<Waybill> getAll() {
        return repository.findAll();
    }

    @Override
    public Waybill getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public Waybill save(Waybill waybill) {
        return repository.saveAndFlush(waybill);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }
}
