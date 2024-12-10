package com.keyin.tree;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends CrudRepository<Tree, Long> {

}
