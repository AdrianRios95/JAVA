<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${alimento.porcion eq false}">
    <div class="col-3 mx-auto mt-4">
        <input type="radio" class="btn-check" name="porcion" value="false" id="100g" autocomplete="off" checked>
        <label class="btn" for="100g">por 100g</label>

        <input type="radio" class="btn-check" name="porcion" value="true" id="porcion" autocomplete="off">
        <label class="btn" for="porcion">porcion</label>
    </div>
</c:if>
<c:if test="${alimento.porcion eq true}">
    <div class="col-3 mx-auto mt-4">
        <input type="radio" class="btn-check" name="porcion" value="false" id="100g" autocomplete="off">
        <label class="btn" for="100g">por 100g</label>

        <input type="radio" class="btn-check" name="porcion" value="true" id="porcion" autocomplete="off" checked>
        <label class="btn" for="porcion">porcion</label>
    </div>
</c:if>