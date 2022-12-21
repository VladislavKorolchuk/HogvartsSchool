CREATE TABLE Human
(
    id   BIGINT PRIMARY KEY,
    name TEXT NOT NULL,
    age  INTEGER CHECK (age > 18),
    driver_license BOOLEAN DEFAULT (driver_license=true),
    car_id  BIGINT REFERENCES Car (id)
);
CREATE TABLE Car
(
    id    BIGINT PRIMARY KEY,
    brand TEXT NOT NULL,
    model TEXT NOT NULL,
    price DECIMAL(19,2)
);
