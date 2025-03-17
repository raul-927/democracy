package com.democracy.feingtarget.applications.services;

import com.democracy.feingtarget.domain.ports.in.CreateProductIn;
import com.democracy.feingtarget.domain.ports.in.SelectCountIn;
import com.democracy.feingtarget.domain.ports.in.SelectProductIn;

public interface ProductService extends CreateProductIn , SelectProductIn, SelectCountIn {
}
