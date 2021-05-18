function printSelect() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("selectCusto")
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                 <option value="${data[i].email}">${data[i].first_name + " " + data[i].last_name}</option>
                 `
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-customer', true);
    xhr.send(null)
}

printSelect();