package ao.com.school.avaluation.controller.maintenance;

import ao.com.school.avaluation.dtos.request.SchoolRequest;
import ao.com.school.avaluation.dtos.response.SchoolResponse;
import ao.com.school.avaluation.service.maintenance.SchoolMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/domain/school")

public class SchoolMaintenanceController {
    @Autowired
    private SchoolMaintenanceService schoolMaintenanceService;

    @PostMapping
    public ResponseEntity<SchoolResponse> save(@RequestBody SchoolRequest schoolRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolMaintenanceService.save(schoolRequest));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<SchoolResponse>update(@RequestBody SchoolRequest schoolRequest, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolMaintenanceService.update(schoolRequest, id));
    }

    @PutMapping("/delete/{id}/status")
    public ResponseEntity<SchoolResponse>delete(@PathVariable Long id, @RequestParam Boolean status){
    return ResponseEntity.status(HttpStatus.OK).body(schoolMaintenanceService.delete(id, status));
    }

}
