package repository;

import entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Repo {
    public interface StudentRepository extends JpaRepository<Students, Long>{

    }
}
