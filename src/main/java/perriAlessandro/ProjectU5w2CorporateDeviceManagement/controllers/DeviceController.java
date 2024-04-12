package perriAlessandro.ProjectU5w2CorporateDeviceManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.entities.Device;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.exceptions.BadRequestException;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.payloads.NewDeviceDTO;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.payloads.NewDeviceRespDTO;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.services.DeviceService;
import perriAlessandro.ProjectU5w2CorporateDeviceManagement.services.EmployeeService;

import java.util.UUID;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private EmployeeService employeeService;

    // GET .../devices
    @GetMapping
    private Page<Device> getAllBlogPost(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "id") String sortBy) {
        return deviceService.getDeviceList(page, size, sortBy);
    }

    // POST .../devices (+ body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewDeviceRespDTO saveDevice(@RequestBody @Validated NewDeviceDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return new NewDeviceRespDTO(this.deviceService.saveDevice(body).getId());
    }

    // GET .../devices/{deviceId}
    @GetMapping("/{deviceId}")
    private Device findDeviceById(@PathVariable UUID deviceId) {
        return deviceService.findById(deviceId);
    }

    // PUT .../devices/{deviceId} (+ body)
    @PutMapping("/{deviceId}")
    private Device findDeviceByIdAndUpdate(@PathVariable UUID deviceId, @RequestBody NewDeviceDTO body) {
        return deviceService.findByIdAndUpdate(deviceId, body);
    }

    // DELETE .../devices/{deviceId}
    @DeleteMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204
    private void findByDeviceIdAndDelete(@PathVariable UUID deviceId) {
        deviceService.findByIdAndDelete(deviceId);
    }

//    @PutMapping("/{deviceId}/assign")
//    private Device assignDeviceToEmployee(@PathVariable UUID deviceId, @RequestParam UUID employeeId) {
//        Device device = deviceService.findById(deviceId);
//        if (device == null) {
//            throw new NotFoundException(deviceId);
//        }
//
//        Employee employee = employeeService.findById(employeeId);
//        if (employee == null) {
//            throw new NotFoundException(employeeId);
//        }
//
//        device.setEmployee(employee);
//        device.setStatus("Assigned");
//
//        return deviceService.saveDevice(device);
//    }


}
