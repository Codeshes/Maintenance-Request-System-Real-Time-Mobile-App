<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maintenance Request System</title>

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    <style>

        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
        }

        body{
            font-family:'Poppins',sans-serif;
            background:#f4f7fb;
            color:#1e293b;
            line-height:1.7;
        }

        .hero{
            background:linear-gradient(135deg,#2563eb,#1e40af);
            color:white;
            padding:80px 20px;
            text-align:center;
        }

        .hero h1{
            font-size:3rem;
            margin-bottom:15px;
        }

        .hero p{
            max-width:700px;
            margin:auto;
            font-size:1.1rem;
            opacity:0.95;
        }

        .container{
            width:90%;
            max-width:1200px;
            margin:auto;
            padding:50px 0;
        }

        .card{
            background:white;
            border-radius:20px;
            padding:30px;
            margin-bottom:30px;
            box-shadow:0 10px 30px rgba(0,0,0,0.08);
            transition:0.3s ease;
        }

        .card:hover{
            transform:translateY(-5px);
        }

        h2{
            color:#2563eb;
            margin-bottom:20px;
            font-size:1.8rem;
        }

        ul{
            padding-left:20px;
        }

        ul li{
            margin-bottom:10px;
        }

        .grid{
            display:grid;
            grid-template-columns:repeat(auto-fit,minmax(280px,1fr));
            gap:20px;
        }

        .feature-box{
            background:#eff6ff;
            border-radius:18px;
            padding:25px;
            transition:0.3s ease;
        }

        .feature-box:hover{
            background:#dbeafe;
        }

        .feature-box h3{
            margin-bottom:12px;
            color:#1d4ed8;
        }

        .table{
            width:100%;
            border-collapse:collapse;
            margin-top:20px;
        }

        .table th,
        .table td{
            border:1px solid #e2e8f0;
            padding:15px;
            text-align:left;
        }

        .table th{
            background:#2563eb;
            color:white;
        }

        .footer{
            background:#0f172a;
            color:white;
            text-align:center;
            padding:30px 20px;
            margin-top:50px;
        }

        .badge{
            display:inline-block;
            padding:8px 15px;
            background:#2563eb;
            color:white;
            border-radius:50px;
            margin:5px;
            font-size:0.9rem;
        }

        @media(max-width:768px){

            .hero h1{
                font-size:2.2rem;
            }

            h2{
                font-size:1.5rem;
            }

        }

    </style>
</head>
<body>

    <section class="hero">
        <h1>📱 Maintenance Request System</h1>
        <p>
            A real-time Android-based maintenance management application designed
            to streamline issue reporting, tracking, and task management using
            Firebase and Cloudinary.
        </p>
    </section>

    <div class="container">

        <div class="card">
            <h2>📌 Overview</h2>
            <p>
                The Maintenance Request System is a mobile-based application
                developed to modernize maintenance reporting in schools,
                offices, and organizations. It replaces manual processes
                with a centralized real-time platform for faster communication
                and efficient maintenance management.
            </p>
        </div>

        <div class="card">
            <h2>🎯 Objectives</h2>

            <ul>
                <li>Provide an easy way to report maintenance issues</li>
                <li>Enable real-time request monitoring</li>
                <li>Improve communication between users and staff</li>
                <li>Reduce delays and manual paperwork</li>
            </ul>
        </div>

        <div class="card">
            <h2>⚙️ Features</h2>

            <div class="grid">

                <div class="feature-box">
                    <h3>👤 User Features</h3>
                    <ul>
                        <li>Register & Login</li>
                        <li>Submit Requests</li>
                        <li>Upload Images</li>
                        <li>Track Request Status</li>
                    </ul>
                </div>

                <div class="feature-box">
                    <h3>🛠️ Admin Features</h3>
                    <ul>
                        <li>Manage Requests</li>
                        <li>Assign Tasks</li>
                        <li>Monitor Progress</li>
                        <li>Manage Users</li>
                    </ul>
                </div>

                <div class="feature-box">
                    <h3>👷 Staff Features</h3>
                    <ul>
                        <li>View Assigned Tasks</li>
                        <li>Update Status</li>
                        <li>Mark as Completed</li>
                    </ul>
                </div>

            </div>
        </div>

        <div class="card">
            <h2>🔄 System Workflow</h2>

            <ul>
                <li>User submits maintenance request</li>
                <li>Image uploads to Cloudinary</li>
                <li>Data stores in Firebase Realtime Database</li>
                <li>Admin reviews and assigns tasks</li>
                <li>Maintenance staff updates progress</li>
                <li>Users receive real-time updates</li>
            </ul>
        </div>

        <div class="card">
            <h2>🧱 System Architecture</h2>

            <div class="grid">

                <div class="feature-box">
                    <h3>📱 Frontend</h3>

                    <span class="badge">Android Studio</span>
                    <span class="badge">Java</span>
                    <span class="badge">XML</span>
                    <span class="badge">Material UI</span>

                </div>

                <div class="feature-box">
                    <h3>☁️ Backend & Cloud</h3>

                    <span class="badge">Firebase Auth</span>
                    <span class="badge">Realtime DB</span>
                    <span class="badge">FCM</span>
                    <span class="badge">Cloudinary</span>

                </div>

            </div>
        </div>

        <div class="card">
            <h2>🗃️ Database Structure</h2>

            <table class="table">

                <tr>
                    <th>Field</th>
                    <th>Description</th>
                </tr>

                <tr>
                    <td>request_id</td>
                    <td>Unique request identifier</td>
                </tr>

                <tr>
                    <td>title</td>
                    <td>Maintenance request title</td>
                </tr>

                <tr>
                    <td>description</td>
                    <td>Issue description</td>
                </tr>

                <tr>
                    <td>location</td>
                    <td>Issue location</td>
                </tr>

                <tr>
                    <td>image_url</td>
                    <td>Cloudinary image URL</td>
                </tr>

                <tr>
                    <td>status</td>
                    <td>Pending / Ongoing / Completed</td>
                </tr>

            </table>
        </div>

        <div class="card">
            <h2>☁️ Why Cloudinary?</h2>

            <p>
                Cloudinary was used for image hosting and management instead
                of Firebase Storage to avoid billing requirements during
                development while still supporting reliable cloud-based uploads.
            </p>

        </div>

        <div class="card">
            <h2>🚀 Technologies Used</h2>

            <span class="badge">Android Studio</span>
            <span class="badge">Java</span>
            <span class="badge">Firebase</span>
            <span class="badge">Cloudinary</span>
            <span class="badge">Material Design</span>

        </div>

        <div class="card">
            <h2>🏆 Future Enhancements</h2>

            <ul>
                <li>Priority-based request system</li>
                <li>Analytics dashboard</li>
                <li>Dark mode support</li>
                <li>Offline functionality</li>
                <li>GPS & Maps integration</li>
            </ul>

        </div>

    </div>

    <footer class="footer">

        <h3>👨‍💻 Developers</h3>

        <p>
            Nathaniel N. Vargas <br>
            Pheona Isavedra <br>
            Joseph Ivan Aquino
        </p>

        <br>

        <p>
            ICT102A • Maintenance Request System
        </p>

    </footer>

</body>
</html>
