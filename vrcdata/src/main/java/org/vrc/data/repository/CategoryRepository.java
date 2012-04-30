package org.vrc.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.vrc.data.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
}
