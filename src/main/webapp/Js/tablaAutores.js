function printTable(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("res")
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                <tr>
                <td>${data[i].authorId}</td>
                <td>${data[i].name}</td>
                <td>${data[i].country}</td>
                </tr>`
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/JPATutorial-1.0-SNAPSHOT/list-authors', true);
    xhr.send(null)

}
printTable();