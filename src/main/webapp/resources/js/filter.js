$(()=>{
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
        province.onchange = (e) => {
          const code = e.target.value;
          const html = renderHTML(data, code, "districts");
          district.innerHTML =
            '<option value="">Chọn Quận, Huyện</option>' + html;
        };
        return htmlCommue;
      })
      .catch((err) => console.error(err));

//      Sbumit filter

$("#filter-submit").click((e)=>{
e.preventDefault();
const provinceCode = $(province).find(':selected').val();
const provinceValue = $(province).find(':selected').text();
const districtCode =  $(district).find(':selected').val();
const districtValue =  $(district).find(':selected').text();
const provinceRange1Val =
})
})

