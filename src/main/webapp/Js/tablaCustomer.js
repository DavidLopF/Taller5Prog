function printTable() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var cuerpo = document.getElementById("res")
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                cuerpo.innerHTML += `
                <tr>
                     <td>${data[i].email}</td>
                     <td>${data[i].first_name}</td>
                     <td>${data[i].last_name}</td>
                     <td>${data[i].gender}</td>
                     <td>${data[i].age}</td>
              
                </tr>
                `
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-customer', true);
    xhr.send(null)
}

printTable();