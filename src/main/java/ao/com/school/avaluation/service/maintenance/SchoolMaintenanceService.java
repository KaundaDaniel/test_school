package ao.com.school.avaluation.service.maintenance;

import ao.com.school.avaluation.domain.School;
import ao.com.school.avaluation.dtos.request.SchoolRequest;
import ao.com.school.avaluation.dtos.response.SchoolResponse;
import ao.com.school.avaluation.repository.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolMaintenanceService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private ModelMapper modelMapper;


    public SchoolResponse save(SchoolRequest schoolRequest){
        School school= School.builder()
                .name(schoolRequest.getName())
                .status(schoolRequest.getStatus())
                .build();
        schoolRepository.save(school);
        return modelMapper.map(school, SchoolResponse.class);
    }

    public SchoolResponse update(SchoolRequest schoolRequest, Long id){
        School school= schoolRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id not Found"));
        school.setName(schoolRequest.getName());
        school.setStatus(schoolRequest.getStatus());
        schoolRepository.save(school);
        return modelMapper.map(school, SchoolResponse.class);
    }

    public SchoolResponse delete(Long id, Boolean status) {
        Optional<School> findSchoolOptional = schoolRepository.findById(id);

        if (findSchoolOptional.isPresent()) {
            School foundSchool = findSchoolOptional.get();
            if (!foundSchool.getStatus().equals(status)) {
                foundSchool.setStatus(status);
                schoolRepository.save(foundSchool);
            }
            return modelMapper.map(foundSchool, SchoolResponse.class);
        } else {
            throw new RuntimeException("School with ID " + id + " not found");
        }
    }


}
