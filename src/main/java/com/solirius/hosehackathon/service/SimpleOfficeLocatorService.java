package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.domain.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import com.solirius.hosehackathon.utilities.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleOfficeLocatorService implements OfficeLocatorService {
    
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office getOffice(double lat, double lng) {
        Office selectedOffice = null;
        double selectedDistance = -1L;
        List<Office> listOffice = (List<Office>) officeRepository.findAll();
        for (Office currentOffice : listOffice) {
            double currentDistance =
                    Calculate.distance(lat, lng, currentOffice.getLatitude(), currentOffice.getLongitude());
            if (selectedDistance > currentDistance || selectedOffice == null) {
                selectedOffice = currentOffice;
                selectedDistance = currentDistance;
            }
        }
        return selectedOffice;
    }
}
