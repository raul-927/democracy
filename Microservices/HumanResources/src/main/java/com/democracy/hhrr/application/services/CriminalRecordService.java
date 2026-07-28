package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.criminalrecord.CreateCriminalRecordIn;
import com.democracy.hhrr.domain.ports.reactive.in.criminalrecord.DeleteCriminalRecordIn;
import com.democracy.hhrr.domain.ports.reactive.in.criminalrecord.SelectCriminalRecordIn;
import com.democracy.hhrr.domain.ports.reactive.in.criminalrecord.UpdateCriminalRecordIn;

public interface CriminalRecordService extends CreateCriminalRecordIn, DeleteCriminalRecordIn, SelectCriminalRecordIn, UpdateCriminalRecordIn {
}
