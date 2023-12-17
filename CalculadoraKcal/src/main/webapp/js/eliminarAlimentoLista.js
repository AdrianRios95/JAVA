
function eliminarAlimentoLista(idAlimento) {
    // Obtener el modal del archivo JSP incluido
    var modal = document.getElementById('eliminarAlimentoLista');
    // Obtener el elemento para mostrar el contenido
    var contenidoModal = modal.querySelector('#idAlimento');
    var inputIdAlimento = modal.querySelector('#inputIdAlimento');
    // Asignar el contenido dinámico al elemento
    contenidoModal.innerText = idAlimento;
    inputIdAlimento.value = idAlimento;
    }


