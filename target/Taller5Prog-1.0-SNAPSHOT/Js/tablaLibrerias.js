function printTable() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("res")

            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                <tr>
                <td>${data[i].libraryId}</td>
                <td>${data[i].name}</td>
                </tr>`
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-libraries', true);
    xhr.send(null)
}

printTable();