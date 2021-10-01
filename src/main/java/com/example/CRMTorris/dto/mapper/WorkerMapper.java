package com.example.CRMTorris.dto.mapper;

import com.example.CRMTorris.dto.WorkerDto;
import com.example.CRMTorris.database.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerMapper extends AbstractMapper<Worker, WorkerDto>{

    @Autowired
    public WorkerMapper() {
        super(Worker.class, WorkerDto.class);
    }
}
