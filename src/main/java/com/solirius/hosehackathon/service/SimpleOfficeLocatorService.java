package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.domain.Office;
import com.solirius.hosehackathon.repository.OfficeRepository;
import com.solirius.hosehackathon.utilities.Calculate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleOfficeLocatorService implements OfficeLocatorService {
    
    private final OfficeRepository officeRepository;

    public SimpleOfficeLocatorService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office getOffice(double lat, double lng) {
        Office selectedOffice = null;
        double selectedDistance = -1L;
        List<Office> listOffice = officeRepository.findAll();
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
