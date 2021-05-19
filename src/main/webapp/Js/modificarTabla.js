function tomarGson() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var cuerpo = document.getElementById("res")
            for (let i = 0; i < data.length; i++) {
                var year = data[i].release_year.substr(0, 12)
                cuerpo.innerHTML += `
                <tr>
                     <td>${data[i].edition_id}</td>
                     <td>${data[i].desc}</td>
                     <td>${year}</td>
                  <td>
                <button type="button" id="boton${i}" name="${data[i].edition_id}" class="btn btn-primary" onclick="openForm(document.getElementById('myForm').id , ${"boton" + i},${data[i].edition_id} )"><i class="far fa-eye"></i></button>
                 </td>
                <td>
                <form action="asociarLibrary">
                    <button type="button" value="${data[i].edition_id}" id="id" name="id" class="btn btn-primary" onclick="openForm(document.getElementById('formlibrary').id,null,${data[i].edition_id} )"><i class="far fa-eye"></i></input>
                </form>
                 </td>
                <td>
                <button type="button" value="${data[i].edition_id}" class="btn btn-primary"  onclick="openForm(document.getElementById('formL').id,null,${data[i].edition_id})"><i class="far fa-eye"></i></button>
                </td>
                </tr>
                  `
            }

        }
    }
    xhr.open('GET', 'http://localhost:8080/Taller5Prog-1.0-SNAPSHOT/listOneEdition', true);
    xhr.send(null)

}

function openForm(id, boton,id2) {
    document.getElementById(id).style.display = "block";
    document.cookie = "idBook = "+encodeURIComponent(id2);
    if (id == "myForm") {
        var label = document.getElementById("edicion")
        label.innerHTML = `
       
              <option class="form-option" value="${boton.name}">${boton.name}</option>
            `
    }

}


function closeForm(id) {
    document.getElementById(id).style.display = "none";
    document.cookie = "idBook = "+encodeURIComponent(id2);

}

tomarGson()


