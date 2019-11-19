<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Java EE</title>
    <meta charset="utf-8">
  </head>
  <body>
${2 + 5}<br>
${(2 + 5) < 10} équivalent à ${(2 + 5) lt 10}<br>
${empty maliste ? "liste vide" : maliste[0]}<br>
${not empty maliste ? maliste[0] : "liste vide"}<br>
  </body>
</html>