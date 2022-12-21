ALTER TABLE Student
    ADD CONSTRAINT age_student CHECK (age > 16);
ALTER TABLE Student
    ADD CONSTRAINT nickname_unique UNIQUE (name) NOT NULL;
ALTER TABLE Faculty
    ADD CONSTRAINT name_color_unique UNIQUE (name, color);
ALTER TABLE Student
    ADD CONSTRAINT age_default DEFAULT (age = 20);