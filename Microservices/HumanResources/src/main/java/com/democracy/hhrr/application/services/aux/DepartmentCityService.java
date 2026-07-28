package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.ports.reactive.in.aux.departmentcity.CreateDepartmentCityIn;
import com.democracy.hhrr.domain.ports.reactive.in.aux.departmentcity.DeleteDepartmentCityIn;
import com.democracy.hhrr.domain.ports.reactive.in.aux.departmentcity.SelectDepartmentCityIn;
import com.democracy.hhrr.domain.ports.reactive.in.aux.departmentcity.UpdateDepartmentCityIn;

public interface DepartmentCityService extends CreateDepartmentCityIn, DeleteDepartmentCityIn, SelectDepartmentCityIn, UpdateDepartmentCityIn {
}
