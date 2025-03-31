package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.profession.CreateProfessionIn;
import com.democracy.hhrr.domain.ports.in.profession.DeleteProfessionIn;
import com.democracy.hhrr.domain.ports.in.profession.SelectProfessionIn;
import com.democracy.hhrr.domain.ports.in.profession.UpdateProfessionIn;

public interface ProfessionService extends CreateProfessionIn, DeleteProfessionIn, SelectProfessionIn, UpdateProfessionIn {
}
