package com.fc.crud;

import com.fc.common.Api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public abstract class CRUDAbstractApiController<DTO, ENTITY> implements CRUDInterface<DTO>{

    @Autowired(required = false)
    private CURDAbstractService<DTO, ENTITY> crudAbstractService;


    @PostMapping("")
    @Override
    public DTO create(
            @Valid
            @RequestBody
            DTO dto
    ) {
        return crudAbstractService.create(dto);
    }

    @Override
    public Optional<DTO> read(
            @PathVariable
            Long id
    ) {
        return crudAbstractService.read(id);
    }

    @Override
    public DTO update(
            @Valid
            @RequestBody
            DTO dto
    ) {
        return crudAbstractService.update(dto);
    }

    @Override
    public void delete(
            @PathVariable
            Long id
    ) {
        crudAbstractService.delete(id);
    }

    @Override
    public Api<List<DTO>> list(
            @PageableDefault
            Pageable pageable
    ) {
        return crudAbstractService.list(pageable);
    }
}
