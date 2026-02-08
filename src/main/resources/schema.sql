CREATE TABLE IF NOT EXISTS patients (
                          patient_id INT PRIMARY KEY,
                          full_name VARCHAR(100) NOT NULL,
                          birth_date DATE,
                          phone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS doctors (
                         doctor_id INT PRIMARY KEY,
                         full_name VARCHAR(100) NOT NULL,
                         specialization VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS medicines (
                           medicine_id INT PRIMARY KEY,
                           medicine_name VARCHAR(100) NOT NULL,
                           price DECIMAL(10,2) CHECK (price > 0)
);

CREATE TABLE IF NOT EXISTS prescriptions (
                               prescription_id INT PRIMARY KEY,
                               patient_id INT NOT NULL,
                               doctor_id INT NOT NULL,
                               prescription_date DATE DEFAULT CURRENT_DATE,
                               FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
                               FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);

CREATE TABLE IF NOT EXISTS prescription_items (
                                    prescription_id INT,
                                    medicine_id INT,
                                    quantity INT CHECK (quantity > 0),
                                    PRIMARY KEY (prescription_id, medicine_id),
                                    FOREIGN KEY (prescription_id) REFERENCES prescriptions(prescription_id),
                                    FOREIGN KEY (medicine_id) REFERENCES medicines(medicine_id)
);

CREATE TABLE IF NOT EXISTS sales (
                       sale_id INT PRIMARY KEY,
                       prescription_id INT UNIQUE,
                       sale_date DATE DEFAULT CURRENT_DATE,
                       total_amount DECIMAL(10,2),
                       FOREIGN KEY (prescription_id) REFERENCES prescriptions(prescription_id)
);