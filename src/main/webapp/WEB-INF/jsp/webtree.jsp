<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>jsTree test</title>
    <!-- 2 load the theme CSS file -->
    <link rel="stylesheet" href="dist/themes/default/style.min.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<!-- 3 setup a container element -->
<h3>Web File Tree</h3>
<div class="row">
    <div class="col-md-4 col-sm-8 col-xs-8">
        <button type="button" class="btn btn-success btn-sm" onclick="create_element();"><i
                class="glyphicon glyphicon-asterisk"></i> Create
        </button>
        <button type="button" class="btn btn-warning btn-sm" onclick="rename_element();"><i
                class="glyphicon glyphicon-pencil"></i> Rename
        </button>
        <button type="button" class="btn btn-danger btn-sm" onclick="delete_element();"><i
                class="glyphicon glyphicon-remove"></i> Delete
        </button>
    </div>
</div>
<div id="jstree"></div>


<!-- include the jQuery library -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<!-- include the minified jstree source -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
<script type="text/javascript" src="resources/js/tree_scripts.js"></script>
<script type="text/javascript" src="resources/js/button_scripts.js"></script>
</body>
</html>