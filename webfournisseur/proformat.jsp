<%@page import="java.util.List"%>
<%@page import="util.fournisseur.Proformat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Proformat> all = (List<Proformat>) request.getAttribute("listeproformat");
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Puly</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,700" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex justify-content-between">

      <div class="logo">
        <h1><a href="index.html">Puly</a></h1>
      </div>

      <nav id="navbar" class="navbar"> 
        <ul>
          <li><a class="nav-link scrollto active" href="index.jsp">Home</a></li>
          <li><a class="nav-link scrollto" href="proformat">Proformat</a></li>
          <li><a class="nav-link scrollto" href="livraison">Bon de livraison</a></li>
          <li><a class="nav-link scrollto" href="facture">Facture</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- #header -->
  <br>
  <br>
  <!-- ======= Main Content ======= -->
  <main id="main" class="container mt-5">
    <section id="product-table" class="mt-5">
      <div class="container" data-aos="fade-up">
        <h2>Table des Produits</h2>
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Nom de produit</th>
              <th>Description</th>
              <th>Quantité</th>
              <th>Prix unitaire</th>
            </tr>
          </thead>
          <tbody>
            <% 
                if (all != null) {
                    for (Proformat proformat : all) {
            %>
            <tr>
                <td><%= proformat.getProduit().getNom() %></td>
                <td><%= proformat.getProduit().getDescription() %></td>
                <td><%= proformat.getQuantite() %></td>
                <td><%= proformat.getPrixUnitaire() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4">Aucune donnée disponible</td>
            </tr>
            <%
                }
            %>
        </tbody>
        </table>
      </div>
    </section>
  </main><!-- End Main Content -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>
