package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.ports.reactive.in.institute.CreateInstituteIn;
import com.democracy.hhrr.domain.ports.reactive.in.institute.DeleteInstituteIn;
import com.democracy.hhrr.domain.ports.reactive.in.institute.SelectInstituteIn;
import com.democracy.hhrr.domain.ports.reactive.in.institute.UpdateInstituteIn;

public interface InstituteService extends CreateInstituteIn, DeleteInstituteIn, SelectInstituteIn, UpdateInstituteIn {
}
