package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.ports.in.aux.departmentcity.CreateDepartmentCityIn;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.DeleteDepartmentCityIn;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.SelectDepartmentCityIn;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.UpdateDepartmentCityIn;

public interface DepartmentCityService extends CreateDepartmentCityIn, DeleteDepartmentCityIn, SelectDepartmentCityIn, UpdateDepartmentCityIn {
}
