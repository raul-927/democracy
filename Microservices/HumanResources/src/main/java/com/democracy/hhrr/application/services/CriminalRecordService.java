package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.criminalrecord.CreateCriminalRecordIn;
import com.democracy.hhrr.domain.ports.in.criminalrecord.DeleteCriminalRecordIn;
import com.democracy.hhrr.domain.ports.in.criminalrecord.SelectCriminalRecordIn;
import com.democracy.hhrr.domain.ports.in.criminalrecord.UpdateCriminalRecordIn;

public interface CriminalRecordService extends CreateCriminalRecordIn, DeleteCriminalRecordIn, SelectCriminalRecordIn, UpdateCriminalRecordIn {
}
