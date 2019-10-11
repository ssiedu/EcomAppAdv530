<html>
    <script>
      var request;
      function one(){
       var v=document.getElementById("cat").value;
       request=new XMLHttpRequest();
       request.onreadystatechange=two;
       request.open("get", "GetItems.jsp?t1="+v, true);
       request.send(null);
      }
      function two(){
        
            if(request.status==200 && request.readyState==4){
             var v=request.responseText;
             document.getElementById("data").innerHTML=v;
            }
     }
    </script>
    <body>
        <h1>Online Shopping</h1>
        Select Category <select name="cat" id="cat">
            <option onclick="one()">books</option>
            <option onclick="one()">computers</option>
            <option onclick="one()">electronics</option>
            <option onclick="one()">furniture</option>
         </select>
        <hr>
        <div id="data"></div>
        <hr>
    </body>
</html>
