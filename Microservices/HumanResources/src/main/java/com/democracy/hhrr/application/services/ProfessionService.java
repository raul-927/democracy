package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.profession.CreateProfessionIn;
import com.democracy.hhrr.domain.ports.reactive.in.profession.DeleteProfessionIn;
import com.democracy.hhrr.domain.ports.reactive.in.profession.SelectProfessionIn;
import com.democracy.hhrr.domain.ports.reactive.in.profession.UpdateProfessionIn;

public interface ProfessionService extends CreateProfessionIn, DeleteProfessionIn, SelectProfessionIn, UpdateProfessionIn {
}
