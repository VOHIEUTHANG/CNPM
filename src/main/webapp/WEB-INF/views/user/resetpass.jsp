<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="<c:url value='/resources/assets/images/Logo-icon.png'/>">
    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/11a1459669.js"
      crossorigin="anonymous"
    ></script>
    <!-- css external links-->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
      integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
      crossorigin="anonymous"
    />

    <!-- google fonts -->
    <style>
      @import url("https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,400;0,700;1,400;1,700&display=swap");
    </style>
    <title>Đặt lại mật khẩu</title>
  </head>
<body>
<form th:action="@{/reset_password}" method="post" style="max-width: 350px; margin: 0 auto;">
    <input type="hidden" name="token" th:value="${token}" />
<div class="border border-secondary rounded p-3">
    <div>
        <p>
            <input type="password" name="pass" id="password" class="form-control"
                placeholder="Enter your new password" required autofocus />
        </p>
        <p class="text-center">
            <input type="submit" value="Change Password" class="btn btn-primary" />
        </p>
    </div>
</div>
</form>
</body>
</html>