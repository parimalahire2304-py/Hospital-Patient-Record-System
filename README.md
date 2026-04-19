# 🏥 Hospital Patient Record System

A web-based application developed using **Spring Boot, Thymeleaf, and MySQL** to manage patients, doctors, prescriptions, and medical history efficiently.

---

## 📌 Features

### 👤 Patient Management

* ➕ Register Patient
* 📋 View All Patients
* ✏️ Edit Patient Details
* 🗑️ Delete Patient

### 👨‍⚕️ Doctor Management

* ➕ Register Doctor
* 📋 View All Doctors

### 💊 Prescription Management

* ➕ Add Prescription
* 🔗 Link Prescription to Patient

### 📜 Patient History

* 📄 View Patient History
* 🔍 Search Patient by ID
* 📊 View Patient Details
* 📁 View All Past Prescriptions

### 🎨 User Interface

* 🌄 Modern UI with background image
* 🧊 Glassmorphism design
* 🎯 Clean and user-friendly layout
* ⚡ Smooth navigation between modules

---

## 🛠️ Technologies Used

* **Backend:** Spring Boot, Spring MVC, Spring Data JPA
* **Frontend:** Thymeleaf, HTML, CSS
* **Database:** MySQL
* **Build Tool:** Maven
* **IDE:** Eclipse

---

## 🗂️ Project Structure

```
Hospital_patient_record_system
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── hospital
│   │   │
│   │   │           ├── controller
│   │   │           │   ├── PatientController.java
│   │   │           │   ├── PrescriptionController.java
│   │   │           │   └── DoctorController.java
│   │   │
│   │   │           ├── entity
│   │   │           │   ├── Patient.java
│   │   │           │   ├── Prescription.java
│   │   │           │   └── Doctor.java
│   │   │
│   │   │           ├── repository
│   │   │           │   ├── PatientRepository.java
│   │   │           │   ├── PrescriptionRepository.java
│   │   │           │   └── DoctorRepository.java
│   │   │
│   │   │           ├── service
│   │   │           │   ├── PatientService.java
│   │   │           │   ├── PatientServiceImple.java
│   │   │           │   ├── PrescriptionService.java
│   │   │           │   ├── PrescriptionServiceImple.java
│   │   │           │   ├── DoctorService.java
│   │   │           │   └── DoctorServiceImple.java
│   │   │
│   │   │           └── HospitalPatientRecordSystemApplication.java
│   │
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── index.html
│   │   │   │   ├── register.html
│   │   │   │   ├── patients.html
│   │   │   │   ├── prescription.html
│   │   │   │   ├── history.html
│   │   │   │   ├── doctorRegister.html
│   │   │   │   └── doctors.html
│   │   │   │
│   │   │   ├── static
│   │   │   │   ├── css/
│   │   │   │   └── images/
│   │   │   │
│   │   │   └── application.properties
│   │
│   └── test
│       └── java
│
├── target/
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/parimalahire2304-py/Hospital-Patient-Record-System.git
cd Hospital-Patient-Record-System
```

---

### 2️⃣ Configure Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

---

### 4️⃣ Access Application

```
http://localhost:8080/
```

---

## 🔮 Future Enhancements

* 🔐 User Authentication (Login System)
* 📊 Dashboard Analytics
* 🔎 Search by Name instead of ID
* 📱 Mobile Responsive UI

---

## 👨‍💻 Authors

* **Parimal Ahire**
  GitHub: https://github.com/parimalahire2304-py

* **Lalit Dhone**
  GitHub: https://github.com/lalitdhone-11

---

## 📄 License

This project is developed for educational purposes.
