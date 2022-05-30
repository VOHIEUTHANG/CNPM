$(() => {
  const price1Input = $("#range-price1");
  const price2Input = $("#range-price2");
  const area1Input = $("#range-area1");
  const area2Input = $("#range-area2");

  const priceStart = $(".price-start");
  const priceEnd = $(".price-end");
  const areaStart = $(".area-start");
  const areaEnd = $(".area-end");

  let storageProvince = "";
  let storageDistrict = "";

  let filterStorageValue = localStorage.getItem("filter");
  if (filterStorageValue) {
    filterStorageValue = JSON.parse(filterStorageValue);
    price1Input.val(filterStorageValue.giaTu);
    price2Input.val(filterStorageValue.giaDen);
    priceStart.text(filterStorageValue.giaTu);
    priceEnd.text(filterStorageValue.giaDen);

    area1Input.val(filterStorageValue.dienTichTu);
    area2Input.val(filterStorageValue.dienTichDen);
    areaStart.text(filterStorageValue.dienTichTu);
    areaEnd.text(filterStorageValue.dienTichDen);

    storageProvince = filterStorageValue.tinh;
    storageDistrict = filterStorageValue.huyen;
  }

  $(".filter-label").click(() => {
    $(".filter-container").toggleClass("show");
  });
  const province = document.getElementById("filter-province");
  const district = document.getElementById("filter-district");
  const renderHTML = (arr, code, type) => {
    let result = "";
    arr.forEach((item) => {
      if (item.code == code) {
        result = item[type].reduce((acc, item) => {
          return acc + `<option value=${item.code}>${item.name}</option>`;
        }, "");
      }
    });
    return result;
  };
  fetch("https://provinces.open-api.vn/api/?depth=3")
    .then((response) => response.json())
    .then((data) => {
      const htmlProvince = data.reduce((acc, item) => {
        return acc + `<option value=${item.code}>${item.name}</option>`;
      }, "");
      const htmlCommue = data[0].districts[0].wards.reduce((acc, item) => {
        return acc + `<option value=${item.code}>${item.name}</option>`;
      }, "");
      province.innerHTML =
        '<option value="">Chọn Tỉnh, Thành Phố</option>' + htmlProvince;
        if (storageProvince) {
                  for (let option of province.options) {
                    if (option.text === storageProvince) {
                      option.setAttribute("selected", "selected");
                      const provinceCode = option.value;
                      const html = renderHTML(data, provinceCode, "districts");
                      district.innerHTML =
                        '<option value="">Chọn Quận, Huyện</option>' + html;
                      if (storageDistrict) {
                        for (let option of district.options) {
                          if (option.text === storageDistrict) {
                            option.setAttribute("selected", "selected");
                          }
                        }
                      }
                    }
                  }
                }
      province.onchange = (e) => {
        const code = e.target.value;
        const html = renderHTML(data, code, "districts");
        district.innerHTML =
          '<option value="">Chọn Quận, Huyện</option>' + html;
      };
      return htmlCommue;
    })
    .catch((err) => console.error(err));

  let priceStartValue = price1Input.val();
  let priceEndValue = price2Input.val();

  let areaStartValue = area1Input.val();
  let areaEndValue = area2Input.val();

  area1Input.on("input", (e) => {
    areaStartValue = Number(e.target.value);

    if (areaStartValue > areaEndValue) {
      areaStart.text(areaEndValue);
      areaEnd.text(areaStartValue);
    } else {
      areaStart.text(areaStartValue);
      areaEnd.text(areaEndValue);
    }
  });

  area2Input.on("input", (e) => {
    areaEndValue = Number(e.target.value);

    if (areaStartValue > areaEndValue) {
      areaStart.text(areaEndValue);
      areaEnd.text(areaStartValue);
    } else {
      areaStart.text(areaStartValue);
      areaEnd.text(areaEndValue);
    }
  });

  price1Input.on("input", (e) => {
    priceStartValue = Number(e.target.value);

    if (priceStartValue > priceEndValue) {
      priceStart.text(priceEndValue);
      priceEnd.text(priceStartValue);
    } else {
      priceStart.text(priceStartValue);
      priceEnd.text(priceEndValue);
    }
  });

  price2Input.on("input", (e) => {
    priceEndValue = Number(e.target.value);

    if (priceStartValue > priceEndValue) {
      priceStart.text(priceEndValue);
      priceEnd.text(priceStartValue);
    } else {
      priceStart.text(priceStartValue);
      priceEnd.text(priceEndValue);
    }
  });

  area1Input.on("input", (e) => {});

  $("#filter-submit").click((e) => {
    const filterValues = {
      tinh: "",
      huyen: "",
      giaTu: 0,
      giaDen: 5,
      dienTichTu: 0,
      dienTichDen: 30,
    };
    e.preventDefault();
    const provinceCode = $(province).find(":selected").val();
    const provinceValue = $(province).find(":selected").text();
    const districtCode = $(district).find(":selected").val();
    const districtValue = $(district).find(":selected").text();

    if (provinceCode) {
      filterValues.tinh = provinceValue;
    }
    if (districtCode) {
      filterValues.huyen = districtValue;
    }
    filterValues.giaTu = priceStart.text();
    filterValues.giaDen = priceEnd.text();
    filterValues.dienTichTu = areaStart.text();
    filterValues.dienTichDen = areaEnd.text();
    localStorage.setItem("filter", JSON.stringify(filterValues));
    const formData = new FormData();
    formData.append("filterValues", JSON.stringify(filterValues));
    let URL = "./post-filter";
    if (window.location.href.includes("/filter")) {
      URL = "../post-filter";
    }
    $.ajax({
      url: URL,
      type: "POST",
      data: formData,
      enctype: "multipart/form-data",
      processData: false,
      contentType: false,
      cache: false,
      success: function () {
        localStorage.setItem("filter", JSON.stringify(filterValues));
        if (window.location.href.endsWith("/filter")) {
                     window.location.reload();
                   } else if (window.location.href.includes("/filter-province")) {
                     const index = window.location.href.lastIndexOf('-');
                     window.location.href = window.location.href.slice(0,index);
                   }
                   else{
                     window.location.href = window.location.href + "/filter";
                   }
      },
      error: function () {
        toast({
          title: "Có lỗi xảy ra khi gửi request về server !",
          message: "Vui lòng liên hệ quản trị viên để giải quyết !",
          type: "error",
          duration: 5000,
        });
      },
    });
  });
});
     const sendValue = (province) => {
        const formData = new FormData();
        formData.append("province", JSON.stringify({ province }));
        let URL = "./post-filter-by-province";
        if (window.location.href.includes("/filter")) {
          URL = "../post-filter-by-province";
        }
        $.ajax({
          url: URL,
          type: "POST",
          data: formData,
          enctype: "multipart/form-data",
          processData: false,
          contentType: false,
          cache: false,
          success: function (res) {
            console.log(res);
            if (window.location.href.endsWith("/filter")) {
                         window.location.href = window.location.href + "-province";
                       } else if (window.location.href.endsWith("/filter-province")) {
                         window.location.reload();
                       } else {
                         window.location.href = window.location.href + "/filter-province";
                       }
          },
          error: function () {
            toast({
              title: "Có lỗi xảy ra khi gửi request về server !",
              message: "Vui lòng liên hệ quản trị viên để giải quyết !",
              type: "error",
              duration: 5000,
            });
          },
        });
      };
