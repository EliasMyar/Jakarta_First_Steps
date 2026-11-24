<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Publications</title>
<style>
  body {
    font-family: system-ui, Arial, sans-serif;
    background: #f5f6f8;
    color: #222;
    margin: 0;
    padding: 2rem;
  }
  .container {
    max-width: 960px;
    margin: 0 auto;
    background: #fff;
    padding: 1.5rem 2rem;
    border-radius: 8px;
    box-shadow: 0 1px 4px rgba(0,0,0,.1);
  }
  h1 { margin-top: 0; font-size: 1.6rem; }
  .count { color: #666; margin-bottom: 1rem; }
  table { width: 100%; border-collapse: collapse; }
  th, td {
    text-align: left;
    padding: .65rem .8rem;
    border-bottom: 1px solid #e3e5e8;
  }
  th { background: #2c3e50; color: #fff; }
  tr:nth-child(even) td { background: #fafbfc; }
  tr:hover td { background: #eef3f8; }
  .empty { padding: 1rem; background: #fff7e0; border-radius: 6px; }
  ul.researchers { margin: 0; padding-left: 1.1rem; }
  td { vertical-align: top; }
</style>
</head>
<body>
  <div class="container">
    <h1>List of Publication Titles and Associated Researchers</h1>

    <c:choose>
  <c:when test="${empty publications}">
    <div class="empty">No publications found.</div>
  </c:when>
  <c:otherwise>
    <div class="count">${publications.size()} result(s)</div>
    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>Title</th>
          <th>Researchers</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="p" items="${publications}" varStatus="s">
          <tr>
            <td>${s.count}</td>
            <td><c:out value="${p.title}" /></td>
            <td>
              <c:choose>
                <c:when test="${empty p.researchers}">-</c:when>
                <c:otherwise>
                  <ul class="researchers">
                    <c:forEach var="r" items="${p.researchers}">
                      <li><c:out value="${r}" /></li>
                    </c:forEach>
                  </ul>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </c:otherwise>
</c:choose>
  </div>
</body>
</html>