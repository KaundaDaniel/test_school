package ao.com.school.avaluation.service.query;

import ao.com.school.avaluation.domain.School;
import ao.com.school.avaluation.dtos.response.SchoolResponse;
import ao.com.school.avaluation.repository.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolQueryService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SchoolResponse> findAll(){
        List<School> allSchool= schoolRepository.findAll()
                .stream().filter(s->s.getStatus().equals(true))
                .toList();
        Type typeList=new TypeToken<List<SchoolResponse>>(){}.getType();
        return modelMapper.map(allSchool, typeList);
    }

    public SchoolResponse findSchoolById(Long id){
        Optional<School> schoolId= Optional.ofNullable(schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found")));
        SchoolResponse map = modelMapper.map(schoolId.get(), SchoolResponse.class);
        return map;
    }




}
