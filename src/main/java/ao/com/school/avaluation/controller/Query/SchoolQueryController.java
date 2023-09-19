package ao.com.school.avaluation.controller.Query;

import ao.com.school.avaluation.dtos.response.SchoolResponse;
import ao.com.school.avaluation.service.query.SchoolQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/domain/school")
public class SchoolQueryController {

    @Autowired
    private SchoolQueryService schoolQueryService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<SchoolResponse> findById(@PathVariable Long id){
        SchoolResponse schoolResponse= schoolQueryService.findSchoolById(id);
        return ResponseEntity.status(HttpStatus.OK).body(schoolResponse);
    }
    @GetMapping
    public ResponseEntity<List<SchoolResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(schoolQueryService.findAll());
    }

}
