<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String Path = request.getContextPath() + "/"; %>
<%--<jsp:forward page="/FormServlet"/>--%>
<html>
<head>
    <title>Form表单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.js"></script>
</head>
<body>
     <div class="form">
         <input  class="name" name="name"/>
        <input type="submit" value="提交" id="btn" class="btn"/>
     </div>
<script>
    $.fetch('div.form');
    var ajax = function () {
        $.ajax({
            url:'book/getBookInfo',
            type:'GET',
            dataType:"JSON",
            success:function(resp) {
                if(resp){
                    console.log(resp);
                }
            }
        });
    };
    $('input.btn').click(function (ev) {
        ajax();
    });
</script>
</body>
</html>