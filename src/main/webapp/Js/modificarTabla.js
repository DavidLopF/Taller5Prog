function tomarGson(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var cuerpo = document.getElementById("res")
            for (let i = 0; i < data.length; i++) {
                var year = data[i].release_year.substr(0, 12)
                cuerpo.innerHTML +=`
                <tr>
                     <td>${data[i].edition_id}</td>
                     <td>${data[i].desc}</td>
                     <td>${year}</td>
                  <td>
                <button type="button" class="btn btn-primary" onclick="openForm(document.getElementById('myForm').id)"><i class="far fa-eye"></i></button>
                 </td>
                <td>
                <button type="button" class="btn btn-primary" onclick="openForm(document.getElementById('formlibrary').id)"><i class="far fa-eye"></i></button>
                 </td>
                <td>
                <button type="button" class="btn btn-primary" onclick="openForm(document.getElementById('formL').id)"><i class="far fa-eye"></i></button>
                </td>
                </tr>
                  `
            }

        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/listOneEdition', true);
    xhr.send(null)

}
function openForm(id) {
    document.getElementById(id).style.display = "block";
}
function closeForm(id) {
    document.getElementById(id).style.display = "none";
}
tomarGson()


