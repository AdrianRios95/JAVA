<div class="modal fade" id="agregarAlimentoLista" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Añadir Alimento al Listado</h5>
                <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button> <!-- X que cierra modal -->
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=agregarAlimentoLista" method="POST" class="was-validated">
                <!-- envia al servlet controlador los datos con el nombre de insertar y la variable es accion -->
                <div class="modal-body">


                    <div class="form-group">
                        <label for="nombreAlimento">Alimetno</label>
                        <input type="text" name="nombreAlimento" class="form-control" required>
                    </div>

                    <div class="col-3 mx-auto mt-4">
                        <input type="radio" class="btn-check" name="porcion" value="false" id="100g" autocomplete="off" checked>
                        <label class="btn" for="100g">por 100g</label>

                        <input type="radio" class="btn-check" name="porcion" value="true" id="porcion" autocomplete="off">
                        <label class="btn" for="porcion">porcion</label>
                    </div>

                    <div class="form-group">
                        <label for="grasas">Grasas</label>
                        <input type="number" class="form-control" name="grasas" required step="any">
                    </div>
                    <div class="form-group">
                        <label for="carbohidratos">Carbohidratos</label>
                        <input type="number" class="form-control" name="carbohidratos" required step="any">
                    </div>
                    <div class="form-group">
                        <label for="proteinas">Proteinas</label>
                        <input type="text" class="form-control" name="proteinas" required >
                    </div>
                    <div class="form-group">
                        <label for="kcal">Kcal</label>
                        <input type="number" class="form-control" name="kcal" required step="any">
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
