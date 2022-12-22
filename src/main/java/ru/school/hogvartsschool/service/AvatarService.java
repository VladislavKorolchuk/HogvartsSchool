package ru.school.hogvartsschool.service;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ru.school.hogvartsschool.model.Avatar;
import ru.school.hogvartsschool.model.Student;
import ru.school.hogvartsschool.repositories.AvatarRepository;
import ru.school.hogvartsschool.repositories.StudentRepository;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class AvatarService {

    private  AvatarRepository avatarRepository;
    private  StudentRepository studentRepository;

    public AvatarService(AvatarRepository avatarRepository, StudentRepository studentRepository) {
        this.avatarRepository = avatarRepository;
        this.studentRepository = studentRepository;
    }

    public Avatar findAvatar(long studentId) {
        return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    public List<Avatar> getAvatars(Integer pageNumbers, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumbers-1,pageSize);
        return avatarRepository.findAll(pageRequest).getContent();
    }

    @Value("${avatars.dir.path}")
    private String avatarsDir;

    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {

        Student student = studentRepository.getById(studentId);
        Path filePath = Path.of(avatarsDir, studentId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        Avatar avatar = avatarRepository.findByStudentId(studentId).orElseGet(Avatar::new);
        avatar.setStudent(student);
        avatar.setPathFile(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setFileType(file.getContentType());
        avatar.setData(file.getBytes());
        avatarRepository.save(avatar);
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

}
