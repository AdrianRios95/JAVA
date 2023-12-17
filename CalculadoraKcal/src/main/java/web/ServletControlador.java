package web;

import datos.AlimentosDaoJDBC;
import datos.DietaDaoJDBC;
import dominio.Alimento;
import dominio.AlimentoComida;
import dominio.Comida;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = (String) request.getParameter("accion");
        System.out.println(accion);
        if (accion != null) {
            switch (accion) {
                case "listarAlimentos":
                    this.listarAlimentos(request, response);
                    break;
                case "editarDieta":
                    this.editarDieta(request, response);
                    break;
                case "editarAlimentoLista":
                    this.editarAlimentoLista(request, response);
                    break;
                default:
                    this.listarDieta(request, response);
            }
        } else {
            this.listarDieta(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = (String) request.getParameter("accion");
        System.out.println(accion);
        if (accion != null) {
            switch (accion) {
                case "insertarAlimentoDieta":
                    this.insertarAlimentoDieta(request, response);
                    break;
                case "modificarDieta":
                    this.modificarDieta(request, response);
                    break;
                case "eliminarComida":
                    this.eliminarComida(request, response);
                    break;
                case "modificarAlimentoLista":
                    this.modificarAlimentoLista(request, response);
                    break;
                case "eliminarAlimentoLista":
                    this.eliminarAlimentoLista(request, response);
                    break;
                case "agregarAlimentoLista":
                    this.agregarAlimentoLista(request, response);
                    break;
                default:
                    this.listarDieta(request, response);
            }
        } else {
            this.listarDieta(request, response);
        }
    }

    protected void listarDieta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.accionPorDefecto(request, response);
        response.sendRedirect("dieta.jsp");
    }

    protected void listarAlimentos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.accionPorDefecto(request, response);
        response.sendRedirect("listarAlimentos.jsp");
    }

    protected void accionPorDefecto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AlimentoComida> listaAlimentosDieta = prepararListadoDieta();
        List<Alimento> listaAlimentos = new AlimentosDaoJDBC().listarAlimentos();
        HttpSession session = request.getSession();
        session.setAttribute("listaAlimentosDieta", listaAlimentosDieta);
        session.setAttribute("listaAlimentos", listaAlimentos);
        session.setAttribute("timings", Comida.TIMINGS);
    }

    protected List<AlimentoComida> prepararListadoDieta() {
        List<AlimentoComida> listaAlimentosDieta = new ArrayList<>();
        //Estructura lista (idDieta, idAlimento, nombreAlimento, cantidad, totalGrasas, totalCarbohidratos, totalProteinas, totalKcal, timing)

        for (String timing : Comida.TIMINGS) {
            List<Comida> dieta = new DietaDaoJDBC().listarDieta(timing);

            for (Comida comida : dieta) {
                Alimento alimento = new AlimentosDaoJDBC().encontrar(comida);

                int idDieta = comida.getIdDieta();
                int idAlimento = alimento.getIdAlimento();
                String nombreAlimento = alimento.getNombre();
                double cantidad = comida.getCantidad();
                double totalGrasas = 0;
                double totalProteinas = 0;
                double totalCarbohidratos = 0;
                double totalKcal = 0;
                // Si se trata de una porcion no se ajustan las caloria, de lo contrario se hace la regla de 3 por cada 100g
                if (alimento.getPorcion()) {
                    totalGrasas = cantidad * alimento.getGrasas();
                    totalProteinas = cantidad * alimento.getProteinas();
                    totalCarbohidratos = cantidad * alimento.getCarbohidratos();
                    totalKcal = cantidad * alimento.getKcal();
                } else {
                    totalGrasas = cantidad * alimento.getGrasas() / 100;
                    totalProteinas = cantidad * alimento.getProteinas() / 100;
                    totalCarbohidratos = cantidad * alimento.getCarbohidratos() / 100;
                    totalKcal = cantidad * alimento.getKcal() / 100;
                }

                String timingComida = timing;

                AlimentoComida alimentoComida = new AlimentoComida(idDieta, idAlimento, nombreAlimento, cantidad, totalGrasas, totalCarbohidratos, totalProteinas, totalKcal, timingComida);
                listaAlimentosDieta.add(alimentoComida);
            }
        }
        return listaAlimentosDieta;
    }

    protected void insertarAlimentoDieta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAlimento = 0;
        String idAlimentoString = request.getParameter("idAlimento");
        if (idAlimentoString != null && !"".equals(idAlimentoString)) {
            idAlimento = Integer.parseInt(idAlimentoString);
        }
        double cantidad = 0;
        String cantidadString = request.getParameter("cantidad");
        if (cantidadString != null && !"".equals(cantidadString)) {
            cantidad = Double.parseDouble(cantidadString);
        }
        String timing = request.getParameter("timing");

        Comida comida = new Comida(idAlimento, cantidad, timing);

        System.out.println(comida);

        int registrosModificados = new DietaDaoJDBC().insertarAlimentoADieta(comida);
        System.out.println("Registros Modificados: " + registrosModificados);

        this.listarDieta(request, response);
    }

    protected void editarDieta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDieta = Integer.parseInt(request.getParameter("idDieta"));
        Comida comida = new DietaDaoJDBC().encontrarComida(new Comida(idDieta));
        Alimento alimetno = new AlimentosDaoJDBC().encontrar(comida);

        AlimentoComida alimentoComida = new AlimentoComida(comida, alimetno);

        HttpSession session = request.getSession();
        session.setAttribute("alimentoComida", alimentoComida);
        String editarDietaString = "/WEB-INF/Dieta/editarDieta.jsp";
        request.getRequestDispatcher(editarDietaString).forward(request, response);
    }

    protected void modificarDieta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDieta = Integer.parseInt(request.getParameter("idDieta"));
        int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
        String timing = request.getParameter("timing");
        double cantidad = 0;
        String cantidadString = request.getParameter("cantidad");
        if (cantidadString != null & !"".equals(cantidadString)) {
            cantidad = Double.parseDouble(cantidadString);
        }

        Comida comida = new Comida(idDieta, idAlimento, cantidad, timing);
        int registrosModificados = new DietaDaoJDBC().actualizar(comida);
        System.out.println(registrosModificados);

        this.listarDieta(request, response);
    }

    protected void eliminarComida(HttpServletRequest request, HttpServletResponse respons) throws IOException {
        int idDieta = Integer.parseInt(request.getParameter("idDieta"));
        Comida comida = new Comida(idDieta);
        int registrosModificados = new DietaDaoJDBC().eliminar(comida);
        System.out.println(registrosModificados);

        this.listarDieta(request, respons);
    }

    protected void editarAlimentoLista(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
        int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
        Alimento alimento = new AlimentosDaoJDBC().encontrar(new Alimento(idAlimento));
        System.out.println(alimento);

        HttpSession session = request.getSession();
        session.setAttribute("alimento", alimento);
        request.getRequestDispatcher("/WEB-INF/Alimentos/editarAlimento.jsp").forward(request, respons);
    }

    protected void modificarAlimentoLista(HttpServletRequest request, HttpServletResponse respons) throws IOException {
        int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));

        Alimento alimento = obtenerDatosFormularioAlimentoSinID(request, respons);
        alimento.setIdAlimento(idAlimento);

        int registrosModificados = new AlimentosDaoJDBC().actualizar(alimento);
        System.out.println(registrosModificados);

        this.listarAlimentos(request, respons);
    }

    protected void eliminarAlimentoLista(HttpServletRequest request, HttpServletResponse respons) throws IOException {
        int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));

        int rows = new AlimentosDaoJDBC().eliminar(new Alimento(idAlimento));
        System.out.println(rows);

        int rows2 = new DietaDaoJDBC().eliminarPorEliminarAlimento(new Alimento(idAlimento));
        System.out.println(rows2);

        this.listarAlimentos(request, respons);
    }

    protected void agregarAlimentoLista(HttpServletRequest request, HttpServletResponse respons) throws IOException {
        Alimento alimento = obtenerDatosFormularioAlimentoSinID(request, respons);
        int rows = new AlimentosDaoJDBC().insertarAlimento(alimento);
        System.out.println(rows);

        this.listarAlimentos(request, respons);
    }

    protected Alimento obtenerDatosFormularioAlimentoSinID(HttpServletRequest request, HttpServletResponse respons) {
        String nombreAlimento = request.getParameter("nombreAlimento");
        double grasas = 0;
        String grasasdString = request.getParameter("grasas");
        if (grasasdString != null & !"".equals(grasasdString)) {
            grasas = Double.parseDouble(grasasdString);
        }
        double carbohidratos = 0;
        String carbohidratosString = request.getParameter("carbohidratos");
        if (carbohidratosString != null & !"".equals(carbohidratosString)) {
            carbohidratos = Double.parseDouble(carbohidratosString);
        }
        double proteinas = 0;
        String proteinasString = request.getParameter("proteinas");
        if (proteinasString != null & !"".equals(proteinasString)) {
            proteinas = Double.parseDouble(proteinasString);
        }
        double kcal = 0;
        String kcalString = request.getParameter("kcal");
        if (kcalString != null & !"".equals(kcalString)) {
            kcal = Double.parseDouble(kcalString);
        }
        boolean porcion = Boolean.parseBoolean(request.getParameter("porcion"));

        Alimento alimento = new Alimento(nombreAlimento, grasas, carbohidratos, proteinas, kcal, porcion);

        return alimento;
    }
}
