package domain;

public interface DepartmentRepository {

    Department findById(Long id);
    void save(Department department);
    void closeSession();
}
