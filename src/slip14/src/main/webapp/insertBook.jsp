<%@ page import="java.sql.*" %>
<%
    int bookId = Integer.parseInt(request.getParameter("book_id"));
    String title = request.getParameter("title");
    String publisher = request.getParameter("publisher");

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "system";
    String password = "system";

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        String insert = "INSERT INTO Book (book_id, title, publisher) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(insert);
        ps.setInt(1, bookId);
        ps.setString(2, title);
        ps.setString(3, publisher);

        int rows = ps.executeUpdate();
        if (rows > 0) {
%>
            <h2>Book Inserted Successfully</h2>
            <p><strong>ID:</strong> <%= bookId %></p>
            <p><strong>Title:</strong> <%= title %></p>
            <p><strong>Publisher:</strong> <%= publisher %></p>
<%
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }
%>
