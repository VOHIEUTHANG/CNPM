<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link rel="icon" href="<c:url value='/resources/assets/images/Logo-icon.png'/>">
<title>Biểu đồ thống kê</title>
<link
      href="<c:url value= '/resources/vendor/fontawesome-free/css/all.min.css'/>"
      rel="stylesheet"
      type="text/css"
    /> 
<!-- Google Fonts -->
    <style>
      @import url("https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,400;0,700;1,400;1,700&display=swap");
    </style>
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value='/resources/css/admin/sb-admin-2.css'/>" rel="stylesheet" />
    <link rel="stylesheet" href="<c:url value='/resources/css/admin/main.css'/>" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<!-- Page Wrapper -->
    <div id="wrapper">
      <!-- Sidebar -->
         <jsp:include page="../Admin/layout/menu.jsp" />

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
          <!-- Topbar -->
          <nav
            class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
          >
            <!-- Sidebar Toggle (Topbar) -->
            <button
              id="sidebarToggleTop"
              class="btn btn-link d-md-none rounded-circle mr-3"
            >
              <i class="fa fa-bars"></i>
            </button>

            <!-- Topbar Navbar -->
            <ul class="navbar-nav ml-auto">
              <!-- Nav Item - User Information -->
              <li class="nav-item dropdown no-arrow">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  id="userDropdown"
                  role="button"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  <span class="mr-2 d-none d-lg-inline text-gray-600 small"
                    >Văn Châu</span
                  >
                <i class="fas fa-user-circle fa-2x text-gray-300"></i>
                </a>
                <!-- Dropdown - User Information -->
                <div
                  class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                  aria-labelledby="userDropdown"
                >
                   <a class="dropdown-item" href="../nguoidung/trangcanhan">
                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                    Thông tin
                  </a>
                  <a class="dropdown-item" href="#">
                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                    Đổi mật khẩu
                  </a>
                  <div class="dropdown-divider"></div>
                  <a
                    class="dropdown-item"
                    href="<c:url value='/logout' />"
                    data-toggle="modal"
                    data-target="#logoutModal"
                  >
                    <i
                      class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"
                    ></i>
                    Đăng xuất
                  </a>
                </div>
              </li>
            </ul>
          </nav>
        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xl-8 col-lg-7">
                                    <!-- Bar Chart -->
                                    <div class="card shadow mb-4">
                                        <div class="card-body">
                                           <input type="number" id="year" min="1900" max="2099" step="1" value="2022" oninput="reload()"/>
                                            <div class="chart-bar">
                                                <canvas id="myBarChart" style="pointer-events: none"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
        </div>
          <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xl-8 col-lg-8">
                                            <!-- Bar Chart -->
                                            <div class="card shadow mb-6">
                                                <div class="card-body">
                                                   <input type="number" id="year2" min="1900" max="2099" step="1" value="2022" oninput="gettheothang()"/>
                                                   <input type="number" id="month" min="1" max="12" step="1" value="5" oninput="gettheothang()"/>
                                                    <div class="chart-bar">
                                                        <canvas id="CharMonth" style="pointer-events: none"></canvas>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                </div>
            <!-- End of Main Content -->
 <!-- Footer -->

        <!-- End of Footer -->
      </div>
      <footer class="sticky-footer bg-white">
               <div class="container my-auto">
                 <div class="copyright text-center my-auto">
                   <span>Copyright &copy; timtro.com 2022</span>
                 </div>
               </div>
             </footer>
    </div>
    <!-- End of Page Wrapper -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
      <script src ="<c:url value= '/resources/js/admin/bieudonam.js'/>"></script>
      <script src ="<c:url value= '/resources/js/admin/bieudothang.js'/>"></script>
</body>
</html>