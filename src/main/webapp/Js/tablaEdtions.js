function printTable() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var  cuerpo = document.getElementById("tabla-edition")
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                var year = data[i].release_year.substr(0, 12)
                cuerpo.innerHTML +=`
                <tr>
                     <td>${data[i].edition_id}</td>
                     <td>${data[i].libro}</td>
                     <td>${data[i].desc}</td>
                     <td>${year}</td>
                </tr>
                `
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-edtions', true);
    xhr.send(null)
}

printTable();