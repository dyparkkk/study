package springBootBestPractice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // 이게 뭐임 ???
@Builder
public class APIResponse<T> {

    private String status;
    private List<ErrorDto> errors;
    private T results;
}
