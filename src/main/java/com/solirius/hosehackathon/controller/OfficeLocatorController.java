package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.service.OfficeLocatorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeLocatorController {

    private final OfficeLocatorService officeLocatorService;

    public OfficeLocatorController(OfficeLocatorService officeLocatorService) {
        this.officeLocatorService = officeLocatorService;
    }

    @GetMapping({"/locate-offices/{lat}/{lng}"})
    public String locateOffice(@PathVariable double lat, @PathVariable double lng) {
        return officeLocatorService.getOffice(lat, lng).getName();
    }
}
