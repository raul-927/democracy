package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Institute;
import com.democracy.hhrr.domain.ports.in.institute.CreateInstituteIn;
import com.democracy.hhrr.domain.ports.in.institute.DeleteInstituteIn;
import com.democracy.hhrr.domain.ports.in.institute.SelectInstituteIn;
import com.democracy.hhrr.domain.ports.in.institute.UpdateInstituteIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InsituteServiceImpl implements InstituteService{
    private final CreateInstituteIn createInstituteIn;
    private final DeleteInstituteIn deleteInstituteIn;
    private final SelectInstituteIn selectInstituteIn;
    private final UpdateInstituteIn updateInstituteIn;

    public InsituteServiceImpl(CreateInstituteIn createInstituteIn, DeleteInstituteIn deleteInstituteIn, SelectInstituteIn selectInstituteIn, UpdateInstituteIn updateInstituteIn) {
        this.createInstituteIn = createInstituteIn;
        this.deleteInstituteIn = deleteInstituteIn;
        this.selectInstituteIn = selectInstituteIn;
        this.updateInstituteIn = updateInstituteIn;
    }

    @Override
    public Mono<Integer> createInstitute(Institute institute) {
        return this.createInstituteIn.createInstitute(institute);
    }

    @Override
    public Mono<Integer> deleteInstitute(String instituteId) {
        return this.deleteInstituteIn.deleteInstitute(instituteId);
    }

    @Override
    public Flux<Institute> selectInstitute(Institute institute) {
        return this.selectInstituteIn.selectInstitute(institute);
    }

    @Override
    public Flux<Institute> selectAllInstitutes() {
        return this.selectInstituteIn.selectAllInstitutes();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectInstituteIn.selectCount();
    }

    @Override
    public Mono<Integer> updateInstitute(Institute institute) {
        return this.updateInstituteIn.updateInstitute(institute);
    }
}
