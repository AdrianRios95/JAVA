
function eliminarComida(idDieta) {
    // Obtener el modal del archivo JSP incluido
    var modal = document.getElementById('modalEliminarComida');
    // Obtener el elemento para mostrar el contenido
    var contenidoModal = modal.querySelector('#idDieta');
    var inputIdDieta = modal.querySelector('#inputIdDieta');
    // Asignar el contenido dinámico al elemento
    contenidoModal.innerText = idDieta;
    inputIdDieta.value = idDieta;

    // Mostrar el modal (si estás usando Bootstrap)
    var bootstrapModal = new bootstrap.Modal(modal);
    bootstrapModal.show();
    }


