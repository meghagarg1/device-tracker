package com.java.api.devicetracker.controller;

import com.java.api.devicetracker.model.Device;
import com.java.api.devicetracker.service.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class DeviceControllerTest {

    @InjectMocks
    private DeviceController deviceController;

    @Mock
    private DeviceService deviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddDevice() {
        Device device = new Device();
        device.setName("Device A");
        device.setBrand("Brand A");

        Device savedDevice = new Device(1L, "Device A", "Brand A", LocalDateTime.now());

        when(deviceService.addDevice(device)).thenReturn(savedDevice);

        ResponseEntity<Device> response = deviceController.addDevice(device);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Device A", response.getBody().getName());
        verify(deviceService, times(1)).addDevice(device);
    }

    @Test
    void testGetDeviceById() {
        Long id = 1L;
        Device device = new Device(id, "Device A", "Brand A", LocalDateTime.now());

        when(deviceService.getDeviceById(id)).thenReturn(Optional.of(device));

        ResponseEntity<Device> response = deviceController.getDeviceById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
        verify(deviceService, times(1)).getDeviceById(id);
    }

    @Test
    void testGetDeviceById_NotFound() {
        Long id = 1L;

        when(deviceService.getDeviceById(id)).thenReturn(Optional.empty());

        ResponseEntity<Device> response = deviceController.getDeviceById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(deviceService, times(1)).getDeviceById(id);
    }

    @Test
    void testListAllDevices() {
        Device device1 = new Device(1L, "Device A", "Brand A", LocalDateTime.now());
        Device device2 = new Device(2L, "Device B", "Brand B", LocalDateTime.now());
        List<Device> devices = Arrays.asList(device1, device2);

        when(deviceService.listAllDevices()).thenReturn(devices);

        List<Device> response = deviceController.listAllDevices();

        assertEquals(2, response.size());
        assertEquals("Device A", response.get(0).getName());
        verify(deviceService, times(1)).listAllDevices();
    }

    @Test
    void testUpdateDevice() {
        Long id = 1L;
        Device updatedDevice = new Device(id, "Updated Device", "Updated Brand", LocalDateTime.now());

        when(deviceService.updateDevice(id, updatedDevice)).thenReturn(updatedDevice);

        ResponseEntity<Device> response = deviceController.updateDevice(id, updatedDevice);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Device", Objects.requireNonNull(response.getBody()).getName());
        verify(deviceService, times(1)).updateDevice(id, updatedDevice);
    }

    @Test
    void testUpdateDevice_NotFound() {
        Long id = 1L;
        Device updatedDevice = new Device(id, "Updated Device", "Updated Brand", LocalDateTime.now());

        when(deviceService.updateDevice(id, updatedDevice)).thenReturn(null);

        ResponseEntity<Device> response = deviceController.updateDevice(id, updatedDevice);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(deviceService, times(1)).updateDevice(id, updatedDevice);
    }

    @Test
    void testDeleteDevice() {
        Long id = 1L;

        doNothing().when(deviceService).deleteDevice(id);

        ResponseEntity<Void> response = deviceController.deleteDevice(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deviceService, times(1)).deleteDevice(id);
    }

    @Test
    void testSearchByBrand() {
        String brand = "Brand A";
        Device device1 = new Device(1L, "Device A", brand, LocalDateTime.now());
        Device device2 = new Device(2L, "Device B", brand, LocalDateTime.now());
        List<Device> devices = Arrays.asList(device1, device2);

        when(deviceService.searchByBrand(brand)).thenReturn(devices);

        List<Device> response = deviceController.searchByBrand(brand);

        assertEquals(2, response.size());
        assertEquals("Device A", response.get(0).getName());
        verify(deviceService, times(1)).searchByBrand(brand);
    }
}
