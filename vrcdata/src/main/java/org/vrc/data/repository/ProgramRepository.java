package org.vrc.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.vrc.data.domain.Program;

public interface ProgramRepository extends CrudRepository<Program, Long>
{
}
