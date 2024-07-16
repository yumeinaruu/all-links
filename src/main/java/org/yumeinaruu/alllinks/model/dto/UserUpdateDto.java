package org.yumeinaruu.alllinks.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 2, max = 15)
    private String username;

    @Size(min = 1, max = 255)
    private String description;
}
