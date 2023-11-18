package com.allergenie.server.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MedicineReq {
    @NotBlank
    private Long MedicineId;

}
