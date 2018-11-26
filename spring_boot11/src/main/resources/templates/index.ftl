<html>
<head>
    <title>AAAA</title>
    <script src="${request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
    <link href="${request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .pageDetail {
            display: none;
        }

        .show {
            display: table-row;
        }
    </style>
</head>

<body>
  
      <a   href="${request.contextPath}/toAdd">新增</a>

      
   
       
          
     
      <form action="${request.contextPath}/countries/save" method="post">
   
    <table class="gridtable" style="width:800px;" cellspacing="1" border="1">
         <tr>
            <th>id</th>
            
            <th>name</th>
            
            <th>操作
        </tr>
        
         <#list list as country>
        <tr>
           
            <th>${country.id}
            </th>
            
            <th>${country.name}
            </th>
            <th><a   href="javascript:updateHrm(${country.id})">修改</a>
                         
                        <a href="${request.contextPath}/delete/${country.id}">删除</a>
                   
        </tr>
        </#list>
    <#if msg??>
        <tr style="color:#00ba00;">
            <th colspan="5">${msg}</th>
        </tr>
    </#if>
    </table>
</form>
      
   
   
   

</body>
<script >
function updateHrm(ss){
alert(ss);
}
</script>
</html>