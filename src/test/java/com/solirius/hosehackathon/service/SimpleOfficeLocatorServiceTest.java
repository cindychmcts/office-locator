package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.domain.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimpleOfficeLocatorServiceTest {

    private SimpleOfficeLocatorService simpleOfficeLocatorService;
    private OfficeRepository officeRepository;

    private Office office1;
    private Office office2;
    private Office office3;

    @BeforeEach
    void setUp() {
        List<Office> officeFindAll = new ArrayList<>();
        office1 = new Office(-0.285419, 50.828782, "Adur Estuary", false, true, false, true, true, true, true, false);
        officeFindAll.add(office1);
        office2 = new Office(-7.743797,54.218553, "Aghatirourke", false, true, false, true, true, true, true, false);
        officeFindAll.add(office2);
        office3 = new Office(-5.116096,55.25298, "Adur Estuary", false, true, false, true, true, true, true, false);
        officeFindAll.add(office3);
        officeRepository = mock(OfficeRepository.class);
        simpleOfficeLocatorService = new SimpleOfficeLocatorService(officeRepository);
        when(officeRepository.findAll()).thenReturn(officeFindAll);
    }

    @Test
    void getOffice_Normal_ReturnOffice() {
        double userLat = -7.743797;
        double userLon = 54.218553;
        Office office = simpleOfficeLocatorService.getOffice(userLat, userLon);
        assertEquals(office2, office);
    }

}