function printSelect() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("selectEdicion")
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                 <option value="${data[i].edition_id}">${data[i].desc}</option>
                 `
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-edtions', true);
    xhr.send(null)
}

printSelect();