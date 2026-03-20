# 📱 Maintenance Request System (Android App)

## 📌 Overview
The **Maintenance Request System** is a mobile-based application designed to streamline the process of reporting, tracking, and managing maintenance issues in organizations such as schools, offices, or barangays.

This system replaces traditional manual reporting with a **real-time, centralized platform**, improving efficiency, transparency, and response time.

---

## 🎯 Objectives
- To provide an easy way for users to report maintenance issues  
- To enable administrators to monitor and manage requests efficiently  
- To allow maintenance staff to update task progress in real time  
- To improve communication between users and maintenance personnel  

---

## 👥 Target Users
- **Users (/Employees/Students)** – Submit maintenance requests  
- **Admin** – Manage and assign requests  
- **Maintenance Staff** – Handle and update assigned tasks  

---

## ⚙️ Features

### 👤 User Features
- Register and login  
- Submit maintenance request (title, description, location, image)  
- View request status (Pending, Ongoing, Completed)  
- Receive notifications  

### 🛠️ Admin Features
- View all maintenance requests in real-time  
- Assign tasks to staff  
- Monitor request status  
- Manage users  

### 👷 Staff Features
- View assigned tasks  
- Update task status  
- Mark requests as completed  

---

## 🔄 System Workflow
1. User submits a request  
2. Data is stored in the cloud database  
3. Admin receives and reviews the request  
4. Admin assigns the request to staff  
5. Staff updates the status (Pending → Ongoing → Completed)  
6. User receives real-time updates and notifications  

---

## 🧱 System Architecture

### 📱 Frontend
- Android (Java/Kotlin)
- XML Layouts (Modern UI Design)

### ☁️ Backend (Firebase)
- Firebase Authentication  
- Firebase Firestore / Realtime Database  
- Firebase Cloud Messaging (Notifications)  
- Firebase Storage (Image Uploads)  

---

## 🗃️ Database Structure

### Users
- `user_id`
- `name`
- `email`
- `role` (user/admin/staff)

### Requests
- `request_id`
- `title`
- `description`
- `location`
- `image_url`
- `status`
- `assigned_to`
- `timestamp`

---

## 🎨 UI/UX Design
The application follows modern design principles:
- Minimalist interface  
- Card-based layout  
- Soft color palette  
- Intuitive navigation  
- Responsive and user-friendly experience  

---

## 🚀 Technologies Used
- Android Studio  
- Java / Kotlin  
- Firebase (Auth, Database, Storage, FCM)  
- Material Design Components  

---

## 📊 Expected Outcomes
- Faster reporting of issues  
- Improved tracking of maintenance requests  
- Reduced delays and miscommunication  
- Better organization and accountability  

---

## 🧪 Testing
The system was tested for:
- User authentication  
- Data submission and retrieval  
- Real-time updates  
- Notification delivery  
- Role-based access control  

---

## 🏆 Future Enhancements
- Priority-based request system  
- Analytics dashboard  
- Dark mode  
- Offline support  
- Integration with maps for location tracking  

---

## 📄 License
This project is for educational purposes only.

---

## 👨‍💻 Developer
**Your Name Here**  
ICT102A - Vargas, Nathaniel N.
ICT102A - Isavedra, Pheona
ICT102A - Joseph Ivan Aquino

---

## 💡 Acknowledgment
This project was developed as part of a capstone requirement to demonstrate practical application of mobile and cloud-based technologies.

---
