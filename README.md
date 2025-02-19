# 📝 To-Do App with Spring Security

A simple and secure **To-Do List Application** built using **Spring Boot, Spring Security, Thymeleaf, and Bootstrap**. Users can **register, log in, and manage** their tasks securely.

## 🚀 Features
- 🔐 **User Authentication** (Sign Up, Login, Logout)
- ✅ **Add, Toggle, and Delete Tasks**
- 👤 **User-Specific Task Management** (Each user sees only their tasks)
- 🎨 **Responsive UI** with Bootstrap
- 🔒 **Password Encryption** using **BCrypt**
- 🗃️ **Spring Data JPA** for Database Management

## 🛠️ Tech Stack
- **Backend**: Spring Boot, Spring Security, Spring Data JPA  
- **Frontend**: Thymeleaf, Bootstrap, HTML, CSS  
- **Database**: H2 (In-memory) / MySQL  
- **Security**: Spring Security with BCrypt  

## 📌 Installation & Setup

### 1️⃣ Clone the Repository

git clone https://github.com/your-username/todo-app-spring-security.git
cd todo-app-spring-security
2️⃣ Configure Database (Optional)

application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=yourpassword

🎯 API Endpoints
Method	Endpoint	Description
POST	/register	User Registration
GET	/login	User Login Page
POST	/tasks	Add a New Task
GET	/tasks	View All Tasks (User-Specific)
GET	/tasks/{id}/toggle	Toggle Task Completion
GET	/tasks/{id}/delete	Delete a Task
GET	/logout	Logout User
