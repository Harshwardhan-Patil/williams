<%@ page import="java.sql.*" %>
<%
    String bookIdStr = request.getParameter("book_id");
    int bookId = Integer.parseInt(bookIdStr);

    String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Use your SID
    String user = "system";
    String password = "system";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        String checkQuery = "SELECT * FROM Book WHERE book_id = ?";
        ps = conn.prepareStatement(checkQuery);
        ps.setInt(1, bookId);
        rs = ps.executeQuery();

        if (rs.next()) {
%>
            <h2>Book Details</h2>
            <p><strong>ID:</strong> <%= rs.getInt("book_id") %></p>
            <p><strong>Title:</strong> <%= rs.getString("title") %></p>
            <p><strong>Author:</strong> <%= rs.getString("author") %></p>
<%
        } else {
            // For simplicity, insert dummy data
            String title = "New Book Title";
            String author = "New Author";

            ps.close(); // close previous prepared statement

            String insertQuery = "INSERT INTO Book (book_id, title, author) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(insertQuery);
            ps.setInt(1, bookId);
            ps.setString(2, title);
            ps.setString(3, author);

            int rows = ps.executeUpdate();

            if (rows > 0) {
%>
                <h2>New Book Added</h2>
                <p><strong>ID:</strong> <%= bookId %></p>
                <p><strong>Title:</strong> <%= title %></p>
                <p><strong>Author:</strong> <%= author %></p>
<%
            }
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
