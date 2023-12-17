function agregarAlimentoDieta(timing) {
    // Obtener el modal del archivo JSP incluido
    var modal = document.getElementById('agregarAlimentoDieta');
    // Obtener el elemento para mostrar el contenido
    var contenidoModal = modal.querySelector('#valorTiming');
    var inputTiming = modal.querySelector('#inputTiming');
    // Asignar el contenido dinámico al elemento
    contenidoModal.innerText = timing;
    inputTiming.value = timing;

    // Mostrar el modal (si estás usando Bootstrap)
    var bootstrapModal = new bootstrap.Modal(modal);
    bootstrapModal.show();
    }
    
