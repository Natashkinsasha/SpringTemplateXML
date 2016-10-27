package by.natashkinsasha.springtemplatexml.service;



import by.natashkinsasha.springtemplatexml.entity.Waybill;

import java.util.List;

public interface WaybillService {
    List<Waybill> getAll();
    Waybill getByID(long id);
    Waybill save(Waybill waybill);
    void remove(long id);
}
