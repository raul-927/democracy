package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.person.CreatePersonIn;
import com.democracy.hhrr.domain.ports.in.person.DeletePersonIn;
import com.democracy.hhrr.domain.ports.in.person.SelectPersonIn;
import com.democracy.hhrr.domain.ports.in.person.UpdatePersonIn;

public interface PersonService extends CreatePersonIn, DeletePersonIn, SelectPersonIn, UpdatePersonIn {
}
