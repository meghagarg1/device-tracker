package com.java.api.devicetracker.service;

import com.java.api.devicetracker.model.Device;
import com.java.api.devicetracker.repository.DeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeviceServiceImplTest {

    @InjectMocks
    private DeviceServiceImpl deviceService;

    @Mock
    private DeviceRepository deviceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddDevice() {
        Device device = new Device();
        device.setName("Device A");
        device.setBrand("Brand A");

        when(deviceRepository.save(device)).thenReturn(device);

        Device savedDevice = deviceService.addDevice(device);

        assertNotNull(savedDevice);
        assertEquals("Device A", savedDevice.getName());
        assertEquals("Brand A", savedDevice.getBrand());
        verify(deviceRepository, times(1)).save(device);
    }

    @Test
    void testGetDeviceById() {
        Long id = 1L;
        Device device = new Device();
        device.setId(id);
        device.setName("Device A");
        device.setBrand("Brand A");

        when(deviceRepository.findById(id)).thenReturn(Optional.of(device));

        Optional<Device> foundDevice = deviceService.getDeviceById(id);

        assertTrue(foundDevice.isPresent());
        assertEquals("Device A", foundDevice.get().getName());
        verify(deviceRepository, times(1)).findById(id);
    }

    @Test
    void testGetDeviceById_NotFound() {
        Long id = 1L;

        when(deviceRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Device> foundDevice = deviceService.getDeviceById(id);

        assertFalse(foundDevice.isPresent());
        verify(deviceRepository, times(1)).findById(id);
    }

    @Test
    void testListAllDevices() {
        Device device1 = new Device();
        device1.setName("Device A");
        device1.setBrand("Brand A");

        Device device2 = new Device();
        device2.setName("Device B");
        device2.setBrand("Brand B");

        List<Device> devices = Arrays.asList(device1, device2);

        when(deviceRepository.findAll()).thenReturn(devices);

        List<Device> foundDevices = deviceService.listAllDevices();

        assertEquals(2, foundDevices.size());
        assertEquals("Device A", foundDevices.get(0).getName());
        verify(deviceRepository, times(1)).findAll();
    }

    @Test
    void testUpdateDevice() {
        Long id = 1L;
        Device existingDevice = new Device();
        existingDevice.setId(id);
        existingDevice.setName("Device A");
        existingDevice.setBrand("Brand A");

        Device updatedDevice = new Device();
        updatedDevice.setName("Updated Device");
        updatedDevice.setBrand("Updated Brand");

        when(deviceRepository.findById(id)).thenReturn(Optional.of(existingDevice));
        when(deviceRepository.save(existingDevice)).thenReturn(existingDevice);

        Device result = deviceService.updateDevice(id, updatedDevice);

        assertNotNull(result);
        assertEquals("Updated Device", result.getName());
        assertEquals("Updated Brand", result.getBrand());
        verify(deviceRepository, times(1)).findById(id);
        verify(deviceRepository, times(1)).save(existingDevice);
    }

    @Test
    void testUpdateDevice_NotFound() {
        Long id = 1L;
        Device updatedDevice = new Device();
        updatedDevice.setName("Updated Device");
        updatedDevice.setBrand("Updated Brand");

        when(deviceRepository.findById(id)).thenReturn(Optional.empty());

        Device result = deviceService.updateDevice(id, updatedDevice);

        assertNull(result);
        verify(deviceRepository, times(1)).findById(id);
        verify(deviceRepository, never()).save(any(Device.class));
    }

    @Test
    void testDeleteDevice() {
        Long id = 1L;

        doNothing().when(deviceRepository).deleteById(id);

        deviceService.deleteDevice(id);

        verify(deviceRepository, times(1)).deleteById(id);
    }

    @Test
    void testSearchByBrand() {
        String brand = "Brand A";
        Device device1 = new Device();
        device1.setName("Device A");
        device1.setBrand(brand);

        Device device2 = new Device();
        device2.setName("Device B");
        device2.setBrand(brand);

        List<Device> devices = Arrays.asList(device1, device2);

        when(deviceRepository.findByBrand(brand)).thenReturn(devices);

        List<Device> foundDevices = deviceService.searchByBrand(brand);

        assertEquals(2, foundDevices.size());
        assertEquals("Device A", foundDevices.get(0).getName());
        verify(deviceRepository, times(1)).findByBrand(brand);
    }
}
