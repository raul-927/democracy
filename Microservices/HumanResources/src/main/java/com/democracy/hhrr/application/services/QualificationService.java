package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.qualification.CreateQualificationIn;
import com.democracy.hhrr.domain.ports.reactive.in.qualification.DeleteQualificationIn;
import com.democracy.hhrr.domain.ports.reactive.in.qualification.SelectQualificationIn;
import com.democracy.hhrr.domain.ports.reactive.in.qualification.UpdateQualificationIn;

public interface QualificationService extends CreateQualificationIn, DeleteQualificationIn, SelectQualificationIn, UpdateQualificationIn {
}
