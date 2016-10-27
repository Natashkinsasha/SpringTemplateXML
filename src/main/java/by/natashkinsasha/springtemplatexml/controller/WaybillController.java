package by.natashkinsasha.springtemplatexml.controller;


import by.natashkinsasha.springtemplatexml.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import by.natashkinsasha.springtemplatexml.entity.Waybill;

import java.util.List;

@RestController
public class WaybillController {

    @Autowired
    @Qualifier("mockWaybillService")
    private WaybillService service;

    @RequestMapping(value = "/waybillers", method = RequestMethod.GET)
    @ResponseBody
    public List<Waybill> getAllWaybillers() {
        return service.getAll();
    }

    @RequestMapping(value = "/waybillers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Waybill getWaybiller(@PathVariable("id") long WaybillID) {
        return service.getByID(WaybillID);
    }

    @RequestMapping(value = "/waybillers", method = RequestMethod.POST)
    @ResponseBody
    public Waybill saveRemider(@RequestBody Waybill Waybill) {
        return service.save(Waybill);
    }

    @RequestMapping(value = "/waybillers/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }
}
