package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.service.OfficeLocatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeLocatorController {

    private final OfficeLocatorService officeLocatorService;

    public OfficeLocatorController(OfficeLocatorService officeLocatorService) {
        this.officeLocatorService = officeLocatorService;
    }

    @GetMapping("/locateoffice")
    public String locateOffice(@RequestParam("latitude") double lat, @RequestParam("longitude") double lng) {
        return officeLocatorService.getOffice(lat, lng).getName();
    }

//    @GetMapping("/locate-office")
//    public String locateOffice(@RequestParam("latitude") double lat, @RequestParam("longitude") double lng,
//                               @RequestParam(name="wifi", required=false) boolean wifi,
//                               @RequestParam(name="extendedAccess", required=false) boolean extendedAccess,
//                               @RequestParam(name="kitchen", required=false) boolean kitchen,
//                               @RequestParam(name="breakArea", required=false) boolean breakArea,
//                               @RequestParam(name="petFriendly", required=false) boolean petFriendly) {
//        return officeLocatorService.getOffice(lat, lng).getName();
//    }
}
