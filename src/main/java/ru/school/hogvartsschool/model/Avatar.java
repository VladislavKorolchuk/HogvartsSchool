package ru.school.hogvartsschool.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Avatar {

    @Id
    @GeneratedValue
    private Long id;

    private String pathFile;
    private String fileType;
    private long fileSize;

    @Lob
    private byte[] data;

    @OneToOne
    private Student student;

    public Avatar() {
    }

    public Avatar(Long id, String pathFile, String fileType, long fileSize, byte[] data, Student student) {
        this.id = id;
        this.pathFile = pathFile;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.data = data;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avatar avatar1)) return false;
        return getFileSize() == avatar1.getFileSize() && Objects.equals(getId(), avatar1.getId()) && Objects.equals(getPathFile(), avatar1.getPathFile()) && Objects.equals(getFileType(), avatar1.getFileType()) && Arrays.equals(getData(), avatar1.getData()) && Objects.equals(getStudent(), avatar1.getStudent());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getPathFile(), getFileType(), getFileSize(), getStudent());
        result = 31 * result + Arrays.hashCode(getData());
        return result;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", pathFile='" + pathFile + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize=" + fileSize +
                ", avatar=" + Arrays.toString(data) +
                ", student=" + student +
                '}';
    }

}
