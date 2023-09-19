package ao.com.school.avaluation.controller.maintenance;

import ao.com.school.avaluation.dtos.request.SchoolRequest;
import ao.com.school.avaluation.dtos.response.SchoolResponse;
import ao.com.school.avaluation.service.maintenance.SchoolMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/domain/school")

public class SchoolMaintenanceController {
    @Autowired
    private SchoolMaintenanceService schoolMaintenanceService;

    @PostMapping
    public ResponseEntity<SchoolResponse> save(@RequestBody SchoolRequest schoolRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolMaintenanceService.save(schoolRequest));
    }

}
