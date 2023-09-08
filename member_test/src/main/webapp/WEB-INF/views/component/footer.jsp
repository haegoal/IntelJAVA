<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="footer">

</div>
<script>
    const data= new Date();
    const footer = document.getElementById("footer");
    footer.innerHTML = "<p> &copy;" + data.getFullYear() + "&nbsp; 펌환영 </p>";
</script>

