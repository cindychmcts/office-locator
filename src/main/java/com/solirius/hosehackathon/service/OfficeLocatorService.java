package com.solirius.hosehackathon.service;

import com.solirius.hosehackathon.domain.Office;

public interface OfficeLocatorService {
    Office getOffice(double lat, double lng);
}
