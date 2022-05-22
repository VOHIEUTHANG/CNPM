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
          <div id="myCustomToast">
                <div class="custom-toast-content">
                  <h3 class="heading">Chuyển hướng trang trong</h3>
                  <div class="body">
                    <div class="text-center">5</div>
                  </div>
                </div>
              </div>
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
                      <a href="#" class="acc-setting-item tab1">
                        <i class="fa-solid fa-user"></i>
                        <span>Thông tin</span>
                      </a>
                      <a href="#" class="acc-setting-item tab2">
                          <i class="fa-solid fa-paste"></i>
                          <span>Quản lý tin</span>
                      </a>
                      <a href="#" class="acc-setting-item tab3">
                        <i class="fa-solid fa-bell"></i>
                        <span>Thông báo</span>
                      </a>
                      <a href="#" class="acc-setting-item tab4">
                        <i class="fa-solid fa-file-signature"></i>
                        <span>Góp Ý</span>
                      </a>
                      <a href="#" class="acc-setting-item tab5">
                        <i class="fa-solid fa-key"></i>
                        <span>Đổi mật khẩu</span>
                      </a>
                      <div class="separator"></div>
                      <a href="<c:url value='/logout' />" class="acc-setting-item logout">
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
                          <input type="file" class="account-settings-fileinput" accept=".jpg, .png">
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
                                          <input type="password" name="password" class="form-control" />
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
                      <div class="mana-wrapper">
                                             <div class="mana-heading">
                                                 Thống kê số lượng
                                             </div>
                                             <div class="mana-statistical">
                                                     <div class="row">
                                                       <div class="col">
                                                       <i class="fa-solid fa-boxes-packing"></i>
                                                       Tổng tin: <span class="text-primary"> ${tatca}</span>
                                                       </div>
                                                       <div class="col">
                                                       <i class="fa-solid fa-eye"></i>
                                                       Đang hiển thị: <span class="text-success"> ${danghienthi}</span>
                                                       </div>
                                                       <div class="w-100"></div>
                                                       <div class="col">
                                                        <i class="fa-solid fa-spinner"></i>
                                                       Chưa duyệt: <span class="text-warning">${chuaduyet}</span>
                                                       </div>
                                                       <div class="col">
                                                        <i class="fa-solid fa-calendar-xmark"></i>
                                                       Hết hạn: <span class="text-danger"> ${hethan}</span>
                                                       </div>
                                                        <div class="w-100"></div>
                                                        <div class="col">
                                                        <i class="fa-solid fa-eye-slash"></i>
                                                        Ẩn : <span class="text-warning"> ${an}</span>
                                                        </div>
                                                     </div>
                                                   </div>
                                         </div>
                                         <hr>
                                <div class="mana-foot">
                                <div class="manapost-btn button button--hl ">Quản lý chi tiết</div>
                                </div>

                                        <div class="manapost-container ">
                                            <div class="mana-main">
                                                <div class="man-close-btn">
                                                    <i class="fa-solid fa-xmark"></i>
                                                </div>
                                                <h3 class="mana-heading">
                                                    Quản lý tin đăng
                                                </h3>
                                                <div class="mana-body">
                                                    <table class="table table--custom table-responsive-lg table-bordered table-hover">
                                                        <thead class="table-light">
                                                            <tr>
                                                                <th scope="col">Mã tin</th>
                                                                <th scope="col">Hình đại diện</th>
                                                                <th scope="col">Tiêu đề</th>
                                                                <th scope="col">Giá</th>
                                                                <th scope="col">Thời gian bắt đầu</th>
                                                                <th scope="col">Thời gian kết thúc</th>
                                                                <th scope="col">Trạng thái</th>
                                                                <th scope="col">Chi tiết</th>
                                                              </tr>
                                                          </thead>
                                                          <tbody>
                                                            <c:forEach var="post" items="${postList}">
                                                            <tr>
                                                              <td>${post.mabaiviet}</td>
                                                              <td>
                                                                <div class="mana-img-wrapper">
                                                                  <img
                                                                    src="<c:url value='/${post.getAnh()[0].linkanh}'/>"
                                                                    alt=""
                                                                  />
                                                                  <div class="mana-zoom-img">
                                                                    <img
                                                                      src="<c:url value='/${post.getAnh()[0].linkanh}'/>"
                                                                      alt=""
                                                                    />
                                                                  </div>
                                                                </div>
                                                              </td>
                                                              <td>${post.tieude}</td>
                                                              <td>${post.gia} triệu</td>
                                                              <td>${post.chitietbaiviet.getStartDateFormated()}</td>
                                                              <td>${post.chitietbaiviet.getEndDateFormated()}</td>
                                                              <td>
                                                                <c:choose>
                                                                <c:when test="${post.isDisplay()}">
                                                                <p class="text-success targetElement_${post.mabaiviet}" >Hiển thị</p>
                                                                </c:when>
                                                                <c:when test="${!post.isDisplay()}" >
                                                                <p class="text-warning">Ẩn</p>
                                                                </c:when>
                                                                </c:choose>
                                                              </td>
                                                              <td>
                                                                <div class="mana-detail-wrapper">
                                                                  <div class="mana-btn" data-ID="${post.mabaiviet}">
                                                                    <i class="fa-solid fa-ellipsis"></i>
                                                                  </div>
                                                                  <div class="mana-dropdown" data-ID="${post.mabaiviet}">
                                                                    <ul class="mana-list">
                                                                      <li class="mana-item">
                                                                        <a target="_blank" href="../baiviet/chitiet/${post.mabaiviet}"> Xem chi tiết</a>
                                                                      </li>
                                                                      <c:choose >
                                                                      <c:when test="${post.isDisplay()}">
                                                                       <li class="mana-item mana-item--hide" data-ID="${post.mabaiviet}">
                                                                         <span class="mana-hide-btn">
                                                                           <i class="fa-solid fa-eye-slash"></i>
                                                                           Ẩn
                                                                         </span>
                                                                       </li>
                                                                      </c:when>
                                                                       <c:when test="${!post.isDisplay()}">
                                                                        <li class="mana-item disable">
                                                                          <span class="mana-hide-btn">
                                                                            <i class="fa-solid fa-eye-slash"></i>
                                                                            Ẩn
                                                                          </span>
                                                                        </li>
                                                                       </c:when>
                                                                      </c:choose>
                                                                      <li class="mana-item">
                                                                      <a href="./update-post/${post.mabaiviet}">
                                                                      <span class="mana-modify-btn">Chỉnh sửa</span>
                                                                      </a>
                                                                      </li>
                                                                    </ul>
                                                                  </div>
                                                                </div>
                                                              </td>
                                                            </tr>
                                                            </c:forEach>
                                                          </tbody>
                                                      </table>
                                                </div>
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