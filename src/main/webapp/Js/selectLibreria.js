function printSelect() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("selectLibreria")
            console.log(data)
            //return data
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                 <option value="${data[i].libraryId}">${data[i].name}</option>
                 `
            }

        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-libraries', true);
    xhr.send(null)
}



printSelect();