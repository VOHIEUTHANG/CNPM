$(() => {
  (() => {
    return {
      uploadAvatarHandler() {
        $(() => {
          $(".account-settings-fileinput").on("change", function (e) {
            const [file] = e.target.files;
            if (file) {
              $(".image-avatar").attr("src", URL.createObjectURL(file));
            }
          });
        });
      },
      generalSubmitHandler() {
        Validator({
          form: "#form-general",
          formGroupSelector: ".form-group",
          errorSelector: ".form-message",
          rules: [
            Validator.isRequired("#fullName", "Vui lòng nhập họ tên đầy đủ !"),
            Validator.isEmail("#form-email", "Không đúng định dạng email !"),
            Validator.isRequired("#address", "Vui lòng nhập địa chỉ liên hệ!"),
            Validator.isPhoneNumber(
              "#phoneNumber",
              "Số điện thoại không hợp lệ, phải là số có 10 chữ số và bắt đầu bằng 0!"
            ),
          ],
          onSubmit: function (data) {
            let URL = "../api/post-user-general";
            const formData = new FormData();
            const avatarFile = $(".account-settings-fileinput")[0].files[0];
            if (avatarFile) {
              formData.append("avatar", avatarFile);
            } else {
              URL = "../api/post-user-general-no-avatar";
            }
            const userInfo = {
              fullName: $("#fullName").val(),
              address: $("#address").val(),
              phoneNumber: $("#phoneNumber").val(),
              email: $("#form-email").val(),
            };
            formData.append("userInfo", JSON.stringify(userInfo));

            $.ajax({
              url: URL,
              type: "POST",
              data: formData,
              enctype: "multipart/form-data",
              processData: false,
              contentType: false,
              cache: false,
              timeout: 600000,
              success: function (response) {
                if (response === "1") {
                        toast({
                          title: "Cập nhật thành công !",
                          message: "Thông tin của bạn đã được cập nhật thành công !",
                          type: "success",
                          duration: 5000,
                        });
                      } else if (response === "0") {
                        toast({
                          title: "Có lỗi xảy ra !",
                          message: "Có lỗi xảy ra khi cập nhật thông tin dưới cơ sở dữ liệu !",
                          type: "error",
                          duration: 5000,
                        });
                      } else {
                        toast({
                          title: "Có lỗi xảy ra !",
                          message:
                            "Phản hồi trả về từ server không xác định, liên hệ quản trị viên để giải quyết !",
                          type: "error",
                          duration: 5000,
                        });
                      }
              },
              error: function () {
                toast({
                  title: "Có lỗi gửi dữ liệu về server!",
                  message: "Vui lòng liên hệ quản trị viên để giải quyết!",
                  type: "error",
                  duration: 5000,
                });
              },
            });
          },
          onFormInvalid() {
            toast({
              title: "Các trường dữ liệu nhập không hợp lệ!",
              message: "Vui lòng chỉnh sửa lại thông tin cá nhân!",
              type: "error",
              duration: 5000,
            });
          },
        });
      },
      changePasswordHandler() {
              Validator({
                form: "#form-changePassword",
                formGroupSelector: ".form-group",
                errorSelector: ".form-message",
                rules: [
                  Validator.isPassword(
                    "#newPassword",
                    "Mật khẩu tối thiểu phải có 8 ký tự và có ít nhất một ký tự in hoa, 1 ký tự thường !"
                  ),
                  Validator.isConfirmed(
                    "#confirmPassword",
                    () => {
                      return document.getElementById("newPassword").value;
                    },
                    "Mật khẩu xác nhận không trùng khớp!"
                  ),
                ],
                onSubmit: function (passwordInfo) {
                  const formData = new FormData();
                  formData.append("password", JSON.stringify(passwordInfo));
                  $.ajax({
                    url: "../api/post-user-change-password",
                    type: "POST",
                    data: formData,
                    enctype: "multipart/form-data",
                    processData: false,
                    contentType: false,
                    cache: false,
                    timeout: 600000,
                    success: function (data) {
                     switch (data) {
                       case "1":
                             toast({
                               title: "Cập nhật mật khẩu thành công!",
                               message: "Cập nhật mật khẩu thành công, vui lòng đăng nhập lại !",
                               type: "success",
                               duration: 2000,
                             });
                             setTimeout(() => {
                               const text = $(".custom-toast-content > .body > .text-center");
                               $("#myCustomToast").addClass("active");
                               function timeout(time = 5) {
                                 const IntervalID = setInterval(() => {
                                   text.text(--time);
                                   if (time === 0) {
                                     clearInterval(IntervalID);
                                     window.location = "../login";
                                   }
                                 }, 1000);
                               }
                               timeout(5);
                             }, 2000);
                         break;
                       case "0":
                         toast({
                           title: "Có lỗi xảy ra !",
                           message: "Mật khẩu không trùng khớp !",
                           type: "error",
                           duration: 5000,
                         });
                         break;
                       case "-1":
                         toast({
                           title: "Mật khẩu cũ và mật khẩu mới hoàn toàn trùng khớp !",
                           message: "Vui lòng nhập mật khẩu mới khác mật khẩu cũ để thay đổi !",
                           type: "warning",
                           duration: 5000,
                         });
                         break;
                       default:
                         toast({
                           title: "Dữ liệu trả về không thể xác nhận !",
                           message: "Liên hệ quản trị viên để vá lỗi !",
                           type: "warning",
                           duration: 5000,
                         });
                     }
                    },
                    error: function () {
                      toast({
                        title: "Có lỗi gửi dữ liệu về server!",
                        message: "Vui lòng liên hệ quản trị viên để giải quyết!",
                        type: "error",
                        duration: 5000,
                      });
                    },
                  });
                },
                onFormInvalid() {
                  toast({
                    title: "Các trường dữ liệu nhập không hợp lệ!",
                    message: "Vui lòng chỉnh sửa lại mật khẩu cho hợp lệ !",
                    type: "error",
                    duration: 5000,
                  });
                },
              });
            },
      run() {
        this.uploadAvatarHandler();
        this.generalSubmitHandler();
        this.changePasswordHandler();
      },
    };
  })().run();
});


$(() => {
  const container = $(".manapost-container");
  $(".manapost-btn").click(() => {
    container.addClass("active");
  });
  $(".man-close-btn").click((e) => {
    e.stopPropagation();
    container.removeClass("active");
  });
  $(".mana-main").mousedown((e) => {
    e.stopPropagation();
  });
  container.mousedown(() => {
    container.removeClass("active");
  });

  $(".mana-btn").click(function(e){
      e.stopPropagation();
      const dropdown = $(this).siblings('.mana-dropdown');
      const array = [...$(".mana-dropdown")];
      array.forEach(item=>{
       this.dataset.id == item.dataset.id || item.classList.remove('active');
      })
      dropdown && dropdown.toggleClass("active")
  });

  $(".mana-dropdown").click((e) => {
    e.stopPropagation();
  });

  $("body").click((e) => {
    $(".mana-dropdown").hasClass("active") &&
      $(".mana-dropdown").removeClass("active");
  });
  $(".mana-item--hide").click(function (e) {
    const _this = this;
    const ID = this.dataset.id;
    const formData = new FormData();
    formData.append('id',JSON.stringify({id:ID}));
    $.ajax({
      url: "../api/post-hide-post",
      type: "POST",
      data: formData,
      enctype: "multipart/form-data",
      processData: false,
      contentType: false,
      cache: false,
      timeout: 600000,
      success: function (data) {
      if(data==="1"){
        $(".mana-dropdown").hasClass("active") &&
        $(".mana-dropdown").removeClass("active");
        const targetElement = $(`.text-success.targetElement_${_this.dataset.id}`);
        console.log(targetElement);
        targetElement.removeClass('text-success');
        targetElement.addClass('text-warning');
        targetElement.text("Ẩn");
      }else{
      toast({
                title: "Có lỗi upadate table BaiViet trong cơ sở dữ liệu !",
                message: "Vui lòng liên hệ quản trị viên để giải quyết!",
                type: "error",
                duration: 5000,
              });
      }
        toast({
          title: "Thành công !",
          message: "Ẩn bài viết  thành công !",
          type: "success",
          duration: 5000,
        });
      },
      error: function () {
        toast({
          title: "Có lỗi gửi dữ liệu về server!",
          message: "Vui lòng liên hệ quản trị viên để giải quyết!",
          type: "error",
          duration: 5000,
        });
      },
    });
  });
});
