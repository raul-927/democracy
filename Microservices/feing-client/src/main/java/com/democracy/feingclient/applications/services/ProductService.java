package com.democracy.feingclient.applications.services;

import com.democracy.feingclient.domain.ports.in.CreateProductIn;
import com.democracy.feingclient.domain.ports.in.SelectCountIn;
import com.democracy.feingclient.domain.ports.in.SelectProductIn;

public interface ProductService extends CreateProductIn , SelectProductIn, SelectCountIn {
}
