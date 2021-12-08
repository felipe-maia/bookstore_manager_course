package br.com.maia.bookstoremanager.dto;


import br.com.maia.bookstoremanager.entity.Author;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;

    @NonNull
    @Size(max = 200)
    private String name;

    @NotNull
    private Integer chapters;

    @NotNull
    private Integer pages;

    @NonNull
    @Size(max = 100)
    //@Pattern(regexp = "(?:ISBN(?:-10)?:? )?(?=[0-9x]{10}$|(?=(?:[0-9]+[- ])))", message = "ISBN format must be a valid format")
    private String isbn;

    @NonNull
    @Size(max= 200)
    private String publisherName;

    @Valid
    @NotNull
    private AuthorDTO author;

}
