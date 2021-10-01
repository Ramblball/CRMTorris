package com.example.CRMTorris.dto;

import com.example.CRMTorris.dto.transfer.Exist;
import lombok.Data;

import javax.validation.constraints.Null;
import java.io.Serializable;

@Data
public abstract class AbstractDto implements Serializable {

    @Null(groups = {Exist.class})
    private Long id;

}
