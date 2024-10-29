package com.java.api.devicetracker.service;

import com.java.api.devicetracker.model.Device;
import com.java.api.devicetracker.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    public List<Device> listAllDevices() {
        return deviceRepository.findAll();
    }

    public Device updateDevice(Long id, Device updatedDevice) {
        return deviceRepository.findById(id)
                .map(device -> {
                    device.setName(updatedDevice.getName());
                    device.setBrand(updatedDevice.getBrand());
                    return deviceRepository.save(device);
                })
                .orElse(null);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    public List<Device> searchByBrand(String brand) {
        return deviceRepository.findByBrand(brand);
    }
}
