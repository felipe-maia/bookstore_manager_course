package br.com.maia.bookstoremanager.dto;


import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    @NonNull
    @Size(max = 200)
    private String name;

    @NotNull
    //@Size(max = 100)
    private Integer age;
}
