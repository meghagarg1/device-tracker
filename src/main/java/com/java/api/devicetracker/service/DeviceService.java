package com.java.api.devicetracker.service;

import com.java.api.devicetracker.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    Device addDevice(Device device);

    Optional<Device> getDeviceById(Long id);

    List<Device> listAllDevices();

    Device updateDevice(Long id, Device updatedDevice);

    void deleteDevice(Long id);

    List<Device> searchByBrand(String brand);
}
