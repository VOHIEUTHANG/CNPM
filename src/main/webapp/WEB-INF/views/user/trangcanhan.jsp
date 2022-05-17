<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <!DOCTYPE html>
        <html lang="en">
        <head>
          <title>${user.tenND} | Trang Cá Nhân</title>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
            integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
          <link rel="icon" href="<c:url value='/resources/assets/images/Logo-icon.png'/>">
          <!-- fontawesome -->
          <script src="https://kit.fontawesome.com/11a1459669.js" crossorigin="anonymous"></script>
          <!-- css external links-->
          <link rel="stylesheet" href="<c:url value='/resources/css/header_footer.css'/>">
          <link rel="stylesheet" href="<c:url value='/resources/css/global.css'/>">
          <link rel="stylesheet" href="<c:url value='/resources/css/index.css'/>">
          <link rel="stylesheet" href="<c:url value='/resources/css/user.css'/>">
          <!-- google fonts -->
          <style>
            @import url('https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,400;0,700;1,400;1,700&display=swap');
          </style>
        </head>

        <body id="app">
          <div id="toast"></div>
          <header id="header">
            <div class="header-wrapper">
              <div class="header-login">
                <div class="logo">
                  <a href="" #>
                    <img src="<c:url value='/resources/assets/images/logo.png'/>" alt="main logo" />
                  </a>
                </div>
                <div class="acc-wrapper signed">
                  <div class="acc-login acc-component">
                    <button class="button btn-login">Đăng nhập</button>
                  </div>
                  <div class="acc-sign acc-component">
                    <button class="button button--hl">Đăng ký</button>
                  </div>
                  <div class="acc-search acc-component">
                    <i class="fa-solid fa-magnifying-glass"></i>
                  </div>
                  <div class="acc-component acc-control">
                    <div class="acc-profile">
                      <div class="acc-name">
                        <span>${user.tenND}</span>
                      </div>
                      <div class="acc-avatar">
                        <img src="${user.linkanhdaidien}" alt="avatar" />
                      </div>
                    </div>
                    <div class="acc-setting">
                      <a href="#account-general" class="acc-setting-item">
                        <i class="fa-solid fa-user"></i>
                        <span>Thông tin</span>
                      </a>

                      <a href="#" class="acc-setting-item">
                        <i class="fa-solid fa-bell"></i>
                        <span>Thông báo</span>
                      </a>
                      <a href="#" class="acc-setting-item">
                        <i class="fa-solid fa-file-signature"></i>
                        <span>Góp Ý</span>
                      </a>
                      <a href="#" class="acc-setting-item">
                        <i class="fa-solid fa-key"></i>
                        <span>Đổi mật khẩu</span>
                      </a>
                      <div class="separator"></div>
                      <a href="#" class="acc-setting-item logout">
                        <i class="fa-solid fa-right-from-bracket"></i>
                        <span>Đăng xuất</span>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="header-nav">
                <nav class="navigation">
                  <ul class="nav-list">
                    <li class="nav-item">
                      <a class="nav-link" href="../">Trang chủ</a>
                    </li>
                    <li class="nav-item ">
                      <a class="nav-link" href="#">Khám phá</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">Cộng đồng</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">Dịch vụ</a>
                    </li>
                    <li class="nav-item active">
                      <a class="nav-link" href="#">Cá nhân</a>
                    </li>
                  </ul>
                  <div class="post">
                    <a href="../nguoidung/dangbai">
                      <i class="fa-solid fa-pen-to-square"></i>
                      <span>Đăng tin</span>
                    </a>
                  </div>
                </nav>
              </div>
            </div>
          </header>
          <a href="#" class="gototop hide">
            <i class="fa-solid fa-angle-up"></i>
          </a>
          <div class="container container-iso">
            <div class="overflow-hidden">
              <div class="row no-gutters row-bordered row-border-light">
                <div class="col-md-3  nav-control">
                  <div class="list-group list-group-flush account-settings-links">
                    <a class="list-group-item  active" data-toggle="list" href="#account-general">Thông tin cá nhân</a>
                    <a class="list-group-item " data-toggle="list" href="#account-post">Quản lý tin đăng</a>
                    <a class="list-group-item " data-toggle="list" href="#account-notifications">Thông báo</a>
                    <a class="list-group-item " data-toggle="list" href="#account-feedback">Góp ý</a>
                    <a class="list-group-item " data-toggle="list" href="#account-change-password">Đổi mật khẩu</a>
                  </div>
                </div>
                <div class="col-md-9">
                  <div class="tab-content">
                    <div class="tab-pane fade active show" id="account-general">
                      <div class="card-body" style="display:flex;align-items:center;flex-direction:column">
                        <div class="avatar">
                          <img src="${user.linkanhdaidien}" class="image-avatar" accept=".jpg, .png">
                        </div>
                        <label class="btn upload-avatar">
                          <i class="fa-solid fa-upload"></i>
                          <span>Tải ảnh</span>
                          <input type="file" class="account-settings-fileinput">
                      </div>
                      <hr class="border-light m-0">
                      <div class="card-body">
                        <form id="form-general" enctype="multipart/form-data">
                          <div class="form-group">
                            <label class="form-label">Tên Đăng Nhập</label>
                            <input type="text" name="userName" readonly class="form-control mb-1" value="${acc.tenDN}">
                          </div>
                          <div class="form-group">
                            <label class="form-label">Họ và tên</label>
                            <input type="text" name="fullName" id="fullName" class="form-control" value="${user.tenND}">
                            <span class="form-message"></span>
                          </div>
                          <div class="form-group">
                            <label class="form-label">Email</label>
                            <input type="text" name="email" id="form-email" class="form-control mb-1"
                              value="${user.email}">
                            <span class="form-message"></span>
                          </div>
                          <div class="form-group">
                            <label class="form-label">Số điện thoại</label>
                            <input type="text" name="phoneNumber" id="phoneNumber" class="form-control"
                              value="${user.sdt}">
                            <span class="form-message"></span>
                          </div>
                          <div class="form-group">
                            <label class="form-label">Địa chỉ</label>
                            <input type="text" name="address" id="address" class="form-control mb-1"
                              value="${user.diachi}">
                            <span class="form-message"></span>
                          </div>
                          <div class="text-right mt-5">
                            <button id="submit-general" type="submit" class="button button--hl">Lưu thay
                              đổi</button>&nbsp;
                            <button onclick="location.reload()" class="button ">Huỷ</button>
                          </div>
                      </div>
                      </form>
                    </div>
                    <div class="tab-pane fade " id="account-change-password">
                                    <div class="card-body pb-2">
                                      <form action="" id="form-changePassword">
                                        <div class="form-group">
                                          <label class="form-label">Mật khẩu hiện tại</label>
                                          <input type="currentPassword" name="password" class="form-control" />
                                          <span class="form-message"></span>
                                        </div>
                                        <div class="form-group">
                                          <label class="form-label">Nhập mật khẩu mới</label>
                                          <input type="password" id="newPassword" name="newPassword" class="form-control" />
                                          <span class="form-message"></span>
                                        </div>
                                        <div class="form-group">
                                          <label class="form-label">Nhập lại mật khẩu </label>
                                          <input type="password" id="confirmPassword" class="form-control" />
                                          <span class="form-message"></span>
                                        </div>
                                        <div class="text-right mt-5">
                                          <button id="submit-password" type="submit" class="button button--hl">
                                            Lưu thay đổi</button>&nbsp;
                                          <button onclick="location.reload()" class="button">Huỷ</button>
                                        </div>
                                      </form>
                                    </div>
                                  </div>
                    <div class="tab-pane fade" id="account-post">
                      <div class="card-body pb-2">
                        <div class="table-responsive">
                          <table class="table table-striped table-bordered">
                            <thead class="table-light">
                              <tr>
                                <th scope="col">Mã tin</th>
                                <th scope="col">Tiêu đề</th>
                                <th scope="col">Ngày bắt đầu</th>
                                <th scope="col">Ngày hết hạn</th>
                                <th scope="col">Diện tích</th>
                                <th scope="col">Trạng thái</th>
                              </tr>
                            </thead>
                            <tbody>
                              <c:forEach var="post" items="${postList}">
                              <tr>
                                <th scope="row">${post.mabaiviet}</th>
                                <td>${post.tieude}</td>
                                <td>${post.chitietbaiviet.getStartDateFormated()}</td>
                                <td>${post.chitietbaiviet.getEndDateFormated()}</td>
                                <td>${post.dientich} m<sup>2</sup></td>
                                <td>
                                  <c:choose>
                                    <c:when test="${post.tinhtrang}"><p class="text-success">Đã duyệt</p></c:when>
                                    <c:when test="${!post.tinhtrang}"><p class="text-warning">Chưa duyệt</p></c:when>
                                  </c:choose>
                                </td>
                              </tr>
                               </c:forEach>
                            </tbody>
                            <tfoot>
                              <tr>
                                <th scope="col">Mã tin</th>
                                <th scope="col">Tiêu đề</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Diện tích</th>
                                <th scope="col">Chi tiết</th>
                              </tr>
                            </tfoot>
                          </table>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane fade" id="account-feedback">
                      <div class="card-body pb-2">
                        <div class="table-responsive">
                          <table class="table table-striped table-bordered">
                            <thead class="table-light">
                              <tr>
                                <th scope="col">Mã tin</th>
                                <th scope="col">Tiêu đề</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Diện tích</th>
                                <th scope="col">Trạng thái</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <th scope="row">1</th>
                                <td>Title</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>
                                  <p class="text-danger">Chưa Duyệt</p>
                                </td>
                              </tr>
                              <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                                <td>
                                  <p class="text-success">Đã xét duyệt</p>
                                </td>
                              </tr>
                              <tr>
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                                <td>
                                  <p class="text-success">Đã xét duyệt</p>
                                </td>
                              </tr>
                            </tbody>
                            <tfoot>
                              <tr>
                                <th scope="col">Mã tin</th>
                                <th scope="col">Tiêu đề</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Diện tích</th>
                                <th scope="col">Chi tiết</th>
                              </tr>
                            </tfoot>
                          </table>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane fade" id="account-notifications">
                      <div class="card-body pb-2">
                        <div class="table-responsive">
                          <table class="table table-striped table-bordered">
                            <thead class="table-light">
                              <tr>
                                <th scope="col">Mã tin</th>
                                <th scope="col">Tiêu đề</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Diện tích</th>
                                <th scope="col">Trạng thái</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <th scope="row">1</th>
                                <td>Title</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>
                                  <p class="text-danger">Chưa Duyệt</p>
                                </td>
                              </tr>
                              <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                                <td>
                                  <p class="text-success">Đã xét duyệt</p>
                                </td>
                              </tr>
                              <tr>
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                                <td>
                                  <p class="text-success">Đã xét duyệt</p>
                                </td>
                              </tr>
                            </tbody>
                            <tfoot>
                              <tr>
                                <th scope="col">Mã tin</th>
                                <th scope="col">Tiêu đề</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Diện tích</th>
                                <th scope="col">Chi tiết</th>
                              </tr>
                            </tfoot>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <jsp:include page="../Layout/footer.jsp" />
          <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous">
            </script>
          <script src="<c:url value='/resources/js/global.js'/>"></script>
          <script src="<c:url value ='/resources/js/validateLibrary.js'/>"></script>
          <script src="<c:url value='/resources/js/toast.js'/>"></script>
          <script src="<c:url value='/resources/js/user.js'/>"></script>
          <script src="<c:url value='/resources/js/signedIn.js'/>"></script>
        </body>

        </html>