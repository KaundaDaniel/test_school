package ao.com.school.avaluation.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class SchoolRequest {
    private Long id;
    private String name;
    private Boolean status;
}
