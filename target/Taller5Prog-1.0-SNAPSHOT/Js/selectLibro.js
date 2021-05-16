function printSelect() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("selectLibro")
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                 <option value="${data[i].bookId}">${data[i].title}</option>
                 `
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-books', true);
    xhr.send(null)
}

printSelect();