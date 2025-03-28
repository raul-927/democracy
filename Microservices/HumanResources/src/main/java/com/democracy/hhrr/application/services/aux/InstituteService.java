package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.ports.in.institute.CreateInstituteIn;
import com.democracy.hhrr.domain.ports.in.institute.DeleteInstituteIn;
import com.democracy.hhrr.domain.ports.in.institute.SelectInstituteIn;
import com.democracy.hhrr.domain.ports.in.institute.UpdateInstituteIn;

public interface InstituteService extends CreateInstituteIn, DeleteInstituteIn, SelectInstituteIn, UpdateInstituteIn {
}
