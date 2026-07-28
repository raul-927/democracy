package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.penal.CreatePenalIn;
import com.democracy.hhrr.domain.ports.reactive.in.penal.DeletePenalIn;
import com.democracy.hhrr.domain.ports.reactive.in.penal.SelectPenalIn;
import com.democracy.hhrr.domain.ports.reactive.in.penal.UpdatePenalIn;

public interface PenalService extends CreatePenalIn, DeletePenalIn, SelectPenalIn, UpdatePenalIn {
}
