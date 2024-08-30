package co.com.delibolis.products.applications.services;

import co.com.delibolis.products.domain.ports.in.CreateProductIn;
import co.com.delibolis.products.domain.ports.in.SelectCountIn;
import co.com.delibolis.products.domain.ports.in.SelectProductIn;

public interface ProductService extends CreateProductIn , SelectProductIn, SelectCountIn {
}
