<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
   <body>
      <p>Đăng xuất thành công, về trang chủ sau <span id="thoigian">5</span>
      </p>
      <script>
      let count=5;
        function createTimer() {
         interval = setInterval(() => {
         count--;
         document.getElementById('thoigian').innerHTML = count.toString();
        }, 1000);
      }
      createTimer();
              setTimeout(function(){
                  window.location.href = '../';
               }, 5000);
            </script>
   </body>
</html>
