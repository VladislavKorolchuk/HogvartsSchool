package ru.school.hogvartsschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.school.hogvartsschool.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository <Avatar, Long> {

    Optional<Avatar> findByStudentId(Long id);

}
