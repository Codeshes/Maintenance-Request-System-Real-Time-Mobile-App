# 📱 Maintenance Request System (Android App)

## 📌 Overview

The **Maintenance Request System** is a mobile-based Android application designed to streamline the process of reporting, tracking, and managing maintenance issues in organizations such as schools, offices, and barangays.

The system replaces traditional manual reporting with a **real-time centralized platform**, improving efficiency, transparency, communication, and response time.

---

# 🎯 Objectives

- Provide an easy way for users to report maintenance issues
- Enable administrators to monitor and manage requests efficiently
- Allow maintenance staff to update task progress in real time
- Improve communication between users and maintenance personnel

---

# 👥 Target Users

## 👤 Users (Students / Employees / Residents)
- Submit maintenance requests
- Track request progress
- Receive real-time updates

## 🛠️ Admin
- Manage maintenance requests
- Assign tasks to staff
- Monitor request progress
- Manage users and records

## 👷 Maintenance Staff
- View assigned tasks
- Update request status
- Mark requests as completed

---

# ⚙️ Features

## 👤 User Features

- Register and Login using Firebase Authentication
- Submit maintenance requests with:
  - Title
  - Description
  - Location
  - Image Attachment
- Upload images through Cloudinary
- View request status:
  - Pending
  - Ongoing
  - Completed
- Receive real-time updates and notifications

---

## 🛠️ Admin Features

- View all maintenance requests in real time
- Assign maintenance tasks to staff
- Monitor request progress
- Manage users and request records

---

## 👷 Staff Features

- View assigned maintenance tasks
- Update task progress/status
- Mark requests as completed

---

# 🔄 System Workflow

1. User logs into the application
2. User submits a maintenance request with an image
3. Image uploads to Cloudinary
4. Request data and image URL are stored in Firebase Realtime Database
5. Admin reviews the request
6. Admin assigns the request to maintenance staff
7. Staff updates the request status
8. Users receive real-time updates and notifications

---

# 🧱 System Architecture

## 📱 Frontend

- Android Studio
- Java
- XML Layouts
- Material Design Components

---

## ☁️ Backend & Cloud Services

- Firebase Authentication
- Firebase Realtime Database
- Firebase Cloud Messaging (FCM)
- Cloudinary (Image Hosting & Storage)

---

# 🗃️ Database Structure

## 👤 Users Table

| Field | Description |
|------|-------------|
| user_id | Unique user ID |
| name | Full name |
| email | User email |
| role | user/admin/staff |

---

## 📋 Requests Table

| Field | Description |
|------|-------------|
| request_id | Unique request ID |
| title | Request title |
| description | Maintenance issue description |
| location | Issue location |
| image_url | Cloudinary image URL |
| status | Pending / Ongoing / Completed |
| assigned_to | Assigned maintenance staff |
| timestamp | Date and time submitted |

---

# ☁️ Why Cloudinary Was Used

Firebase Storage requires a billing-enabled project for extended usage and production-level uploads. To avoid upgrading plans during development, the system uses **Cloudinary** for image storage.

## ✅ Benefits of Cloudinary

- Free image hosting
- Fast image delivery using CDN
- Easy Android integration
- Secure image URLs
- Reliable cloud-based media management

---

# 🎨 UI/UX Design

The application follows modern UI/UX principles:

- Minimalist interface
- Card-based layouts
- Responsive components
- User-friendly navigation
- Material Design implementation

---

# 🚀 Technologies Used

- Android Studio
- Java
- Firebase Authentication
- Firebase Realtime Database
- Firebase Cloud Messaging (FCM)
- Cloudinary Android SDK
- Material Design Components

---

# 📊 Expected Outcomes

- Faster maintenance issue reporting
- Improved communication between users and maintenance staff
- Better monitoring and tracking of requests
- Reduced delays and manual paperwork
- Increased efficiency and accountability

---

# 🧪 Testing

The application was tested for:

- User authentication
- Real-time database updates
- Cloudinary image uploads
- Form validation
- Role-based access control
- Request submission and retrieval

---

# 🔐 Security Features

- Firebase Authentication for secure login
- Input validation for maintenance requests
- Role-based user access control
- Secure cloud-hosted image management using Cloudinary

---

# 🏆 Future Enhancements

- Priority-based request classification
- Admin analytics dashboard
- Push notification improvements
- Offline support
- GPS/Map integration for precise locations
- Dark mode support
- In-app chat system

---

# 📄 License

This project is for educational purposes only.

---

# 👨‍💻 Developers

- **Nathaniel N. Vargas** – ICT102A
- **Pheona Isavedra** – ICT102A
- **Joseph Ivan Aquino** – ICT102A

---

# 💡 Acknowledgment

This project was developed as part of a capstone/research requirement to demonstrate the practical application of mobile development, real-time databases, and cloud-based technologies in solving real-world maintenance management problems.

---
