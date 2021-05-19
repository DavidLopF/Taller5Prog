function printTable() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tBody = document.getElementById("res")

            for (let i = 0; i < data.length; i++) {
                tBody.innerHTML += `
                <tr>
                <td>${data[i].libro}</td>
                <td>${data[i].fecha}</td>
                <td>${data[i].edicion}</td>
                </tr>
               `
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-Rents', true);
    xhr.send(null)
}

printTable();