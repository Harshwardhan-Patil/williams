<%@ page import="java.sql.*" %>
<%
    int bookId = Integer.parseInt(request.getParameter("book_id"));

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "system";
    String password = "system";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        String query = "SELECT * FROM Book WHERE book_id = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, bookId);
        rs = ps.executeQuery();

        if (rs.next()) {
%>
            <h2>Book Found</h2>
            <p><strong>ID:</strong> <%= rs.getInt("book_id") %></p>
            <p><strong>Title:</strong> <%= rs.getString("title") %></p>
            <p><strong>Publisher:</strong> <%= rs.getString("publisher") %></p>
<%
        } else {
%>
            <h2>Book Not Found</h2>
            <form action="insertBook.jsp" method="post">
                <input type="hidden" name="book_id" value="<%= bookId %>" />
                Title: <input type="text" name="title" required /><br/>
                Publisher: <input type="text" name="publisher" required /><br/>
                <input type="submit" value="Add Book" />
            </form>
<%
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }
%>
