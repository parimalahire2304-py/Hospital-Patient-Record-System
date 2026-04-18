# 🏥 Hospital Patient Record System

A web-based application built using **Spring Boot, Thymeleaf, and MySQL** to manage patients, doctors, and prescriptions efficiently.

---

## 🚀 Features

### 👤 Patient Management

* ➕ Register Patient
* 📋 View All Patients
* ✏️ Edit Patient Details
* 🗑️ Delete Patient

---

### 👨‍⚕️ Doctor Management

* ➕ Register Doctor
* 📋 View All Doctors

---

### 💊 Prescription Management

* ➕ Add Prescription
* 🔗 Link Prescription to Patient

---

### 📜 Patient History

* 🔍 Search Patient by ID
* 📊 View Complete Patient Details
* 📁 View All Past Prescriptions



---

## 🛠️ Technologies Used

* **Backend:** Spring Boot, Spring MVC, Spring Data JPA
* **Frontend:** Thymeleaf, HTML, CSS
* **Database:** MySQL
* **Build Tool:** Maven
* **IDE:** Eclipse

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/Hospital-Patient-Record-System.git
```

---

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

---

### 4️⃣ Open in Browser

```
http://localhost:8080/
```

---

## 🔮 Future Enhancements

* 🔐 Login & Authentication
* 👨‍⚕️ Role-based access (Admin/Doctor)
* 📊 Dashboard analytics
* 🔍 Search by name instead of ID
* 📱 Mobile responsive UI

---


