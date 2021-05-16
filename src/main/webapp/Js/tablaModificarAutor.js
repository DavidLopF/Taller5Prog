function printTable(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("selectAuthor")
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                <option value="${data[i].authorId}">${data[i].name}</option>
               `
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/list-authors', true);
    xhr.send(null)

}
printTable();