package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.department.CreateDepartmentIn;
import com.democracy.hhrr.domain.ports.reactive.in.department.DeleteDepartmentIn;
import com.democracy.hhrr.domain.ports.reactive.in.department.SelectDepartmentIn;
import com.democracy.hhrr.domain.ports.reactive.in.department.UpdateDepartmentIn;

public interface DepartmentService extends CreateDepartmentIn, DeleteDepartmentIn, SelectDepartmentIn, UpdateDepartmentIn {
}
